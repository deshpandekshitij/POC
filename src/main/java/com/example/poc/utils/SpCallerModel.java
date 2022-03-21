package com.example.poc.utils;

import java.util.Map;

public class SpCallerModel {
	
	private String procedureName;
	private Map<String, Object> inputParams;
	
	public SpCallerModel(String procedureName, Map<String, Object> inputParams) {
		this.procedureName = procedureName;
		this.inputParams = inputParams;
	}
	
	public String getProcedureName() {
		return procedureName;
	}
	
	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}
	
	public Map<String, Object> getInputParams() {
		return inputParams;
	}
	
	public void setInputParams(Map<String, Object> inputParams) {
		this.inputParams = inputParams;
	}

}
