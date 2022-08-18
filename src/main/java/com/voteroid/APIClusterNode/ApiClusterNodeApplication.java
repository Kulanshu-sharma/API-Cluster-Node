package com.voteroid.APIClusterNode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.voteroid.APIClusterNode")
@EnableDiscoveryClient
public class ApiClusterNodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiClusterNodeApplication.class, args);
	}

}
