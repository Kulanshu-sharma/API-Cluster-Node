package com.voteroid.APIClusterNode.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;


@Entity
@Table(name="API_CLUSTER_TBL")
public class APIClusterTbl implements Serializable {

	private static final long serialVersionUID = -177859133036864082L;

	@Id
	@Column(name="API_ID")
	private int apiId;
	
	@Column(name="METHOD")
	private String methodName;
	
	@Column(name="PATH")
	private String path;
	
	@OneToMany
	@Column(name="HEADERS_Tbl")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<RequestHeadersTbl> req_headers;
	
	@OneToMany
	@Column(name="PATH_VARIABLES_TBL")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<PathVariablesTbl> pathVariables;
	
	@OneToMany
	@Column(name="QUERY_PARAM_TBL")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<QueryParamsTbl> queryParams;
	
	@OneToMany
	@Column(name="HEADERS_Tbl")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<RespnseHeadersTbl> res_headers;
	
	@Lob
	@Column(name="REQUEST_BODY")
	private String requestBody;
	
	@Lob
	@Column(name="RESPONSE_BODY")
	private String responseBody;

	public int getApiId() {
		return apiId;
	}

	public void setApiId(int apiId) {
		this.apiId = apiId;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<RequestHeadersTbl> getReq_headers() {
		return req_headers;
	}

	public void setReq_headers(List<RequestHeadersTbl> req_headers) {
		this.req_headers = req_headers;
	}

	public List<PathVariablesTbl> getPathVariables() {
		return pathVariables;
	}

	public void setPathVariables(List<PathVariablesTbl> pathVariables) {
		this.pathVariables = pathVariables;
	}

	public List<QueryParamsTbl> getQueryParams() {
		return queryParams;
	}

	public void setQueryParams(List<QueryParamsTbl> queryParams) {
		this.queryParams = queryParams;
	}

	public List<RespnseHeadersTbl> getRes_headers() {
		return res_headers;
	}

	public void setRes_headers(List<RespnseHeadersTbl> res_headers) {
		this.res_headers = res_headers;
	}

	public String getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}

	public String getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}
	
	
}
