package com.voteroid.APIClusterNode.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.voteroid.APIClusterNode.dtos.Constants;
import com.voteroid.APIClusterNode.dtos.GeneralOperations;
import com.voteroid.APIClusterNode.dtos.Messages;
import com.voteroid.APIClusterNode.dtos.Reply;
import com.voteroid.APIClusterNode.entities.APIClusterTbl;
import com.voteroid.APIClusterNode.exceptions.DataNotRecieved;
import com.voteroid.APIClusterNode.exceptions.MethodChangeNotAllowed;
import com.voteroid.APIClusterNode.exceptions.NoAPIFound;
import com.voteroid.APIClusterNode.exceptions.NoAPIIDRecieved;
import com.voteroid.APIClusterNode.exceptions.PathChangeNotAllowed;
import com.voteroid.APIClusterNode.exceptions.SomethingWentWrong;
import com.voteroid.APIClusterNode.exceptions.URIChangeNotAllowed;
import com.voteroid.APIClusterNode.exceptions.UserAuthenticationFailed;
import com.voteroid.APIClusterNode.repositories.APIClusterTblRepository;
import com.voteroid.APIClusterNode.repositories.ClientServiceProxy;
import com.voteroid.APIClusterNode.repositories.SAGProxy;

@RestController
public class APIClusterController {

	private static final Logger LOGGER = LoggerFactory.getLogger(APIClusterController.class);
	
	@Autowired
	public APIClusterTblRepository repository;
	
	@Autowired
	public ClientServiceProxy clientProxy;
	
	@Autowired
	public SAGProxy sagProxy;
	
	@Autowired
	public GeneralOperations operaions;
	
	@PostMapping("/apiCluster/registerApi")
	public Reply saveAPIDetails(@RequestHeader(Constants.TOKEN_DATA) String data,@RequestBody APIClusterTbl clusterTbl) {
		Reply reply = new Reply(data);
		if(reply.getAttribute(Constants.CLIENT_ID)==null)
			throw new UserAuthenticationFailed("No Client Id Recieved for Authentication!!!");
		
		LOGGER.info("API Registration in API Cluster Microservice called");
		if(clusterTbl.getMethodName()==null || clusterTbl.getMethodName().isEmpty())
			throw new DataNotRecieved("API Method",Constants.FieldConstants.API_METHOD,"String");
		if(clusterTbl.getPath()==null||clusterTbl.getPath().isEmpty())
		    throw new DataNotRecieved("API Path",Constants.FieldConstants.API_PATH,"String");
		if(clusterTbl.getApiURL()==null || clusterTbl.getApiURL().isEmpty())
			throw new DataNotRecieved("API URL",Constants.FieldConstants.API_URL,"String");
		if(clusterTbl.getDescription()==null || clusterTbl.getDescription().isEmpty())
			throw new DataNotRecieved("API Description",Constants.FieldConstants.API_DESCRIPTION,"String");
		//******************** Fetching API ID from client macro service call ***************
		int clientId = Integer.parseInt(reply.getAttribute(Constants.CLIENT_ID)+"");
		int apiIdTemp = clientProxy.fetchNextApiNumber(clientId);   
		LOGGER.info("Recieved Next API ID from Client Micro Service : "+apiIdTemp);
		if(apiIdTemp==0)
			throw new SomethingWentWrong("Generation of Temporary API ID Failed from Client Service !!");
		//***********************************************************************************
		
		int apiId = operaions.generateApiIdFromApiNoAndClientId(apiIdTemp,clientId);
		clusterTbl.setApiId(apiId);
		LOGGER.info("Generated API ID from Temp API ID and Client Id : "+apiId);
		
		//****************** Storing data by SAG Micro Service ****************
		clusterTbl.setApiCall(clusterTbl.getPath());
		String accessKey = "hwhps1427k";
		boolean replyFromSAG = sagProxy.registerStandardApi(accessKey,clusterTbl);
		LOGGER.info("Standard API Saved Status from SAG : "+replyFromSAG);
		if(!replyFromSAG)
			throw new SomethingWentWrong("Standard API Registration Failed in SAG Service !!");
		//*********************************************************************
		
		//Setting up API Id Inside the Inner tables
		if(clusterTbl.getResponseBody()!=null && !clusterTbl.getRequestBody().isEmpty()) 
			clusterTbl.getResponseBody().forEach(data1->data1.setApiId(clusterTbl));
		if(clusterTbl.getQueryParams()!=null && !clusterTbl.getQueryParams().isEmpty()) 
			clusterTbl.getQueryParams().forEach(data1->data1.setApiClusterTbl(clusterTbl));
		if(clusterTbl.getPathVariables()!=null && !clusterTbl.getPathVariables().isEmpty()) 
			clusterTbl.getPathVariables().forEach(data1->data1.setApiClusterTbl(clusterTbl));
		if(clusterTbl.getReq_headers()!=null && !clusterTbl.getReq_headers().isEmpty()) 
			clusterTbl.getReq_headers().forEach(data1->data1.setApiId(clusterTbl));
		if(clusterTbl.getRes_headers()!=null && !clusterTbl.getRes_headers().isEmpty()) 
			clusterTbl.getRes_headers().forEach(data1->data1.setApiId(clusterTbl));
		
		repository.save(clusterTbl);
		reply.setData(Messages.Responses.API_SAVED_SUCCESSFULLY);
		return reply;
	}
	
	@GetMapping("/apiCluster/findApiDetails/{apiId}")
	public Reply fetchAPIDetails(@RequestHeader("userData") String data,@PathVariable("apiId") int apiId) {
		Reply reply = new Reply(data);
		if(apiId==0)
			throw new NoAPIIDRecieved();
		Optional<APIClusterTbl> apiClusterTbl = repository.findById(apiId);
		if(!apiClusterTbl.isPresent())
			throw new NoAPIFound();
		reply.setData(apiClusterTbl.get());
		return reply;
	}
	
	@GetMapping("/apiCluster/fetchAllApis")
	public Reply fetchAllApisByClientId(@RequestHeader("userData") String data) {
		Reply reply = new Reply(data);
		int clientId = Integer.parseInt(reply.getAttribute(Constants.CLIENT_ID)+"");
		List<APIClusterTbl> apiClusterTbls = sagProxy.fetchApiListFromClientId("hwhps1427k",clientId);
		reply.setData(apiClusterTbls);
		return reply;
	}
	
	@PutMapping("/apiCluster/editApi/{apiId}")
	public Reply editAPIDetails(@RequestHeader("userData") String data,@RequestBody APIClusterTbl clusterTbl
																	  ,@PathVariable("apiId") int apiId) {
		Reply reply = new Reply(data);
		if(apiId==0)
			throw new NoAPIIDRecieved();
		Optional<APIClusterTbl> apiClusterTbl = repository.findById(apiId);
		if(!apiClusterTbl.isPresent())
			throw new NoAPIFound();
		APIClusterTbl act = apiClusterTbl.get();
		if(!act.getMethodName().equals(clusterTbl.getMethodName()))
			throw new MethodChangeNotAllowed();
		if(!act.getPath().equals(clusterTbl.getPath()))
			throw new PathChangeNotAllowed();
		if(!act.getApiURL().equals(clusterTbl.getApiURL()))
			throw new URIChangeNotAllowed();
		act.setDescription(clusterTbl.getDescription());
		act.setPathVariables(clusterTbl.getPathVariables());
		act.setQueryParams(clusterTbl.getQueryParams());
		act.setReq_headers(clusterTbl.getReq_headers());
		act.setRequestBody(clusterTbl.getRequestBody());
		act.setResponseBody(clusterTbl.getResponseBody());
		act.setRes_headers(clusterTbl.getRes_headers());
		repository.save(act);
		reply.setData(Messages.Responses.API_UPDATED_SUCCESSFULLY);
		//Notify all users by email id...
		return reply;
	}
}
