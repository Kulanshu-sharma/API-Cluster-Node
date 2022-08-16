package com.voteroid.APIClusterNode.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="RESPONSE_HEADERS_TBL")
public class RespnseHeadersTbl implements Serializable {
	
	private static final long serialVersionUID = 3434093514247515152L;

	@Id
	@Column(name="HEADER_ID")
	@GeneratedValue(generator = "api-resHead-sequence-generator")
	@SequenceGenerator(name = "api-resHead-sequence-generator", sequenceName = "resHeadIdSequence", initialValue = 1, allocationSize = 100)
	private int headerId;
	
	@ManyToOne
	private APIClusterTbl apiId;
	
	@Column(name="HEADER_KEY")
	private String headerKey;
	
	@Column(name="HEADER_VALUE")
	private String headerValue;

	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="TYPE")
	private int type;
	

	public APIClusterTbl getApiId() {
		return apiId;
	}

	public void setApiId(APIClusterTbl apiId) {
		this.apiId = apiId;
	}

	public String getHeaderKey() {
		return headerKey;
	}

	public void setHeaderKey(String headerKey) {
		this.headerKey = headerKey;
	}

	public String getHeaderValue() {
		return headerValue;
	}

	public void setHeaderValue(String headerValue) {
		this.headerValue = headerValue;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
