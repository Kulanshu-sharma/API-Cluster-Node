package com.voteroid.APIClusterNode.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="RESPONSE_BODY_TBL")
public class ResponseBodyTbl implements Serializable{

	private static final long serialVersionUID = 5706982013658896892L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="STATUS_CODE")
	private int statusCode;
	
	@Lob
	@Column(name="RESPONSE_BODY")
	private String responseBody;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="apiId", nullable = false)
	private APIClusterTbl apiId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}

	public APIClusterTbl getApiId() {
		return apiId;
	}

	public void setApiId(APIClusterTbl apiId) {
		this.apiId = apiId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
