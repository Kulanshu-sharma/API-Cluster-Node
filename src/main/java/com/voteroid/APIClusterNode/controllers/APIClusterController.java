package com.voteroid.APIClusterNode.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.voteroid.APIClusterNode.dtos.Reply;
import com.voteroid.APIClusterNode.entities.APIClusterTbl;
import com.voteroid.APIClusterNode.repositories.APIClusterTblRepository;

@RestController
public class APIClusterController {

	@Autowired
	public APIClusterTblRepository repository;
	
	@PostMapping("/apiCluster/registerApi")
	public Reply saveAPIDetails(@RequestHeader("userData") String data,@RequestBody APIClusterTbl clusterTbl) {
		Reply reply = new Reply(data);
		repository.save(clusterTbl);
		return reply;
	}
	
	@GetMapping("/apiCluster/findApiDetails/{apiId}")
	public Reply fetchAPIDetails(@RequestHeader("userData") String data,@PathVariable int apiId) {
		Reply reply = new Reply(data);
		Optional<APIClusterTbl> apiClusterTbl = repository.findById(apiId);
		reply.setData(apiClusterTbl.get());
		return reply;
	}
}
