package com.voteroid.APIClusterNode.dtos;

import org.springframework.stereotype.Component;

@Component
public class GeneralOperations {

	public int generateApiIdFromApiNoAndClientId(int apiNo, int clientId) {
		return (clientId*100000) + apiNo;
	}
}
