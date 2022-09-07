package com.voteroid.APIClusterNode.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	
	@OneToMany(mappedBy="apiId")
	@Column(name="HEADERS_Tbl")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<RequestHeadersTbl> req_headers;
	
	@OneToMany(mappedBy="apiClusterTbl")
	@Column(name="PATH_VARIABLES_TBL")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<PathVariablesTbl> pathVariables;
	
	@OneToMany(mappedBy="apiClusterTbl")
	@Column(name="QUERY_PARAM_TBL")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<QueryParamsTbl> queryParams;
	
	@OneToMany(mappedBy="apiId")
	@Column(name="HEADERS_Tbl")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<RespnseHeadersTbl> res_headers;
	
	@Lob
	@Column(name="REQUEST_BODY")
	private String requestBody;
	
	@OneToMany(mappedBy="apiId")
	@Column(name="RESPONSE_BODY")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<ResponseBodyTbl> responseBody;
	
	@Lob
	@Column(name="DESCRIPTION")
	private String description;
	
	@Transient
	private String apiCall;
	
	@Transient
	private String apiURL;

	@Transient
	private float rate;
	
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

	public List<ResponseBodyTbl> getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(List<ResponseBodyTbl> responseBody) {
		this.responseBody = responseBody;
	}

	public String getApiCall() {
		return apiCall;
	}

	public void setApiCall(String apiCall) {
		this.apiCall = apiCall;
	}

	public String getApiURL() {
		return apiURL;
	}

	public void setApiURL(String apiURL) {
		this.apiURL = apiURL;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}
	
	
	
	
}
