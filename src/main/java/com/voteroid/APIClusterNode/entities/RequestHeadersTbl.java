package com.voteroid.APIClusterNode.entities;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="REQUEST_HEADERS_TBL")
public class RequestHeadersTbl implements Serializable {
	
	private static final long serialVersionUID = -7278840726208725525L;

	@Id
	@Column(name="HEADER_ID")
	@GeneratedValue(generator = "api-reqHead-sequence-generator")
	@SequenceGenerator(name = "api-reqHead-sequence-generator", sequenceName = "reqHeadIdSequence", initialValue = 1, allocationSize = 100)
	private int headerId;
	
	@ManyToOne
	private APIClusterTbl apiId;
	
	@Column(name="HEADER_KEY")
	private String reqHeaderKey;
	
	@Column(name="HEADER_VALUE")
	private String reqHeaderValue;

	@Column(name="TYPE")
	private int reqType;
	
	@Column(name="DESCRIPTION")
	private String reqDescription;
	

	public APIClusterTbl getApiId() {
		return apiId;
	}

	public void setApiId(APIClusterTbl apiId) {
		this.apiId = apiId;
	}

	public int getHeaderId() {
		return headerId;
	}

	public void setHeaderId(int headerId) {
		this.headerId = headerId;
	}

	public String getReqHeaderKey() {
		return reqHeaderKey;
	}

	public void setReqHeaderKey(String reqHeaderKey) {
		this.reqHeaderKey = reqHeaderKey;
	}

	public String getReqHeaderValue() {
		return reqHeaderValue;
	}

	public void setReqHeaderValue(String reqHeaderValue) {
		this.reqHeaderValue = reqHeaderValue;
	}

	public int getReqType() {
		return reqType;
	}

	public void setReqType(int reqType) {
		this.reqType = reqType;
	}

	public String getReqDescription() {
		return reqDescription;
	}

	public void setReqDescription(String reqDescription) {
		this.reqDescription = reqDescription;
	}

	
	
	
}
