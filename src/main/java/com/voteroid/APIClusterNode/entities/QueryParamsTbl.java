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
@Table(name="QUERY_PARAMS_TBL")
public class QueryParamsTbl implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="QUERY_VARIABLE_ID")
	@GeneratedValue(generator = "api-queryVar-sequence-generator")
	@SequenceGenerator(name = "api-queryVar-sequence-generator", sequenceName = "queryVarIdSequence", initialValue = 1, allocationSize = 100)
	private int queryVarId;
	
	@ManyToOne
	private APIClusterTbl apiClusterTbl;
	
	@Column(name="QUERY_PARAM")
	private String queryParam;
	
	@Column(name="TYPE")
	private int qpType;
	
	@Column(name="DESCRIPTION")
	private String qpDescription;

	public APIClusterTbl getApiClusterTbl() {
		return apiClusterTbl;
	}

	public void setApiClusterTbl(APIClusterTbl apiClusterTbl) {
		this.apiClusterTbl = apiClusterTbl;
	}

	public String getQueryParam() {
		return queryParam;
	}

	public void setQueryParam(String queryParam) {
		this.queryParam = queryParam;
	}

	public int getQueryVarId() {
		return queryVarId;
	}

	public void setQueryVarId(int queryVarId) {
		this.queryVarId = queryVarId;
	}

	public int getQpType() {
		return qpType;
	}

	public void setQpType(int qpType) {
		this.qpType = qpType;
	}

	public String getQpDescription() {
		return qpDescription;
	}

	public void setQpDescription(String qpDescription) {
		this.qpDescription = qpDescription;
	}

	
	
	
	
	
}
