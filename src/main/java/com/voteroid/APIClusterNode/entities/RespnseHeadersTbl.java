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
	private String resHeaderKey;
	
	@Column(name="HEADER_VALUE")
	private String resHeaderValue;

	@Column(name="DESCRIPTION")
	private String resDescription;
	
	@Column(name="TYPE")
	private int resType;
	

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

	public String getResHeaderKey() {
		return resHeaderKey;
	}

	public void setResHeaderKey(String resHeaderKey) {
		this.resHeaderKey = resHeaderKey;
	}

	public String getResHeaderValue() {
		return resHeaderValue;
	}

	public void setResHeaderValue(String resHeaderValue) {
		this.resHeaderValue = resHeaderValue;
	}

	public String getResDescription() {
		return resDescription;
	}

	public void setResDescription(String resDescription) {
		this.resDescription = resDescription;
	}

	public int getResType() {
		return resType;
	}

	public void setResType(int resType) {
		this.resType = resType;
	}

	
	
	
}
