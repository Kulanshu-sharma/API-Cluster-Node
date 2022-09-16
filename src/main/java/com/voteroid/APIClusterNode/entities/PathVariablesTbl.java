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
	private String pathVariable;
	
	@Column(name="TYPE")
	private int pvType;
	
	@Column(name="DESCRIPTION")
	private String pvDescription;

	public APIClusterTbl getApiClusterTbl() {
		return apiClusterTbl;
	}

	public void setApiClusterTbl(APIClusterTbl apiClusterTbl) {
		this.apiClusterTbl = apiClusterTbl;
	}

	public int getPathVarId() {
		return pathVarId;
	}

	public void setPathVarId(int pathVarId) {
		this.pathVarId = pathVarId;
	}

	public String getPathVariable() {
		return pathVariable;
	}

	public void setPathVariable(String pathVariable) {
		this.pathVariable = pathVariable;
	}

	public int getPvType() {
		return pvType;
	}

	public void setPvType(int pvType) {
		this.pvType = pvType;
	}

	public String getPvDescription() {
		return pvDescription;
	}

	public void setPvDescription(String pvDescription) {
		this.pvDescription = pvDescription;
	}

	

	
	
	
}
