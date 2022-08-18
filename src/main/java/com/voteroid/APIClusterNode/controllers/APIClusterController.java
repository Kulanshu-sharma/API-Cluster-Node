package com.voteroid.APIClusterNode.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.voteroid.APIClusterNode.dtos.Constants;
import com.voteroid.APIClusterNode.dtos.GeneralOperations;
import com.voteroid.APIClusterNode.dtos.Messages;
import com.voteroid.APIClusterNode.dtos.Reply;
import com.voteroid.APIClusterNode.entities.APIClusterTbl;
import com.voteroid.APIClusterNode.exceptions.NoAPIFound;
import com.voteroid.APIClusterNode.exceptions.NoAPIIDRecieved;
import com.voteroid.APIClusterNode.exceptions.NoAPIMethodNameRecieved;
import com.voteroid.APIClusterNode.exceptions.NoAPIUriPresent;
import com.voteroid.APIClusterNode.repositories.APIClusterTblRepository;
import com.voteroid.APIClusterNode.repositories.ClientServiceProxy;
import com.voteroid.APIClusterNode.repositories.SAGProxy;

@RestController
public class APIClusterController {

	@Autowired
	public APIClusterTblRepository repository;
	
	@Autowired
	public ClientServiceProxy clientProxy;
	
	@Autowired
	public SAGProxy sagProxy;
	
	@Autowired
	public GeneralOperations operaions;
	
	@PostMapping("/apiCluster/registerApi")
	public Reply saveAPIDetails(@RequestHeader("userData") String data,@RequestBody APIClusterTbl clusterTbl) {
		Reply reply = new Reply(data);
		if(clusterTbl.getMethodName()==null || clusterTbl.getMethodName().isEmpty())
			throw new NoAPIMethodNameRecieved();
		if(clusterTbl.getPath()==null||clusterTbl.getApiURL()==null||clusterTbl.getPath().isEmpty()||clusterTbl.getApiURL().isEmpty())
		    throw new NoAPIUriPresent();
		
		//******************** Fetching API ID from client macro service call ***************
		int clientId = Integer.parseInt(reply.getAttribute(Constants.CLIENT_ID)+"");
		int apiIdTemp = clientProxy.fetchNextApiNumber(clientId);   
		//***********************************************************************************
		
		int apiId = operaions.generateApiIdFromApiNoAndClientId(apiIdTemp,clientId);
		clusterTbl.setApiId(apiId);
		
		//****************** Storing data by SAG Micro Service ****************
		clusterTbl.setApiCall(clusterTbl.getPath());
		String accessKey = "hwhps1427k";
		boolean replyFromSAG = sagProxy.registerStandardApi(accessKey,clusterTbl);
		//*********************************************************************
		
		repository.save(clusterTbl);
		reply.setData(Messages.Responses.API_SAVED_SUCCESSFULLY);
		return reply;
	}
	
	@GetMapping("/apiCluster/findApiDetails/{apiId}")
	public Reply fetchAPIDetails(@RequestHeader("userData") String data,@PathVariable int apiId) {
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
}
