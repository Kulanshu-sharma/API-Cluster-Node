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
@Table(name="PATH_VARIABLES_TBL")
public class PathVariablesTbl implements Serializable {
	
	private static final long serialVersionUID = -6657027849916854560L;

	@Id
	@Column(name="PATH_VARIABLE_ID")
	@GeneratedValue(generator = "api-pathVar-sequence-generator")
	@SequenceGenerator(name = "api-pathVar-sequence-generator", sequenceName = "pathVarIdSequence", initialValue = 1, allocationSize = 100)
	private int pathVarId;
	
	@ManyToOne
	private APIClusterTbl apiClusterTbl;
	
	@Column(name="PATH_VARIABLE")
	private String pathVariables;
	
	@Column(name="DESCRIPTION")
	private String description;

	public APIClusterTbl getApiClusterTbl() {
		return apiClusterTbl;
	}

	public void setApiClusterTbl(APIClusterTbl apiClusterTbl) {
		this.apiClusterTbl = apiClusterTbl;
	}

	public String getPathVariables() {
		return pathVariables;
	}

	public void setPathVariables(String pathVariables) {
		this.pathVariables = pathVariables;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
