package com.voteroid.APIClusterNode.repositories;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.voteroid.APIClusterNode.dtos.Reply;


@FeignClient(name="client-service")
public interface ClientServiceProxy {

	@GetMapping("/client/nextApiNumber/{clientId}")
	public int fetchNextApiNumber(@PathVariable(value="clientId") int clientId);
}
