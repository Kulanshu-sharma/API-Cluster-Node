package com.voteroid.APIClusterNode.repositories;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.voteroid.APIClusterNode.entities.APIClusterTbl;


@FeignClient(name="sag")
public interface SAGProxy {

	@PostMapping("/sag/registerStandardApi")
	public boolean registerStandardApi(@RequestHeader("accessKey") String accessKey,@RequestBody APIClusterTbl apiClusterTbl);
	
	@GetMapping("/sag/apisList/{clientId}")
	public List<APIClusterTbl> fetchApiListFromClientId(@RequestHeader("accessKey") String accessKey,@PathVariable(name="clientId") int clientId);
}
