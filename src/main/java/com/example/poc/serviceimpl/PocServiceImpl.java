package com.example.poc.serviceimpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.poc.entities.SimpleAdEntAuthenticator;
import com.example.poc.service.PocService;
import com.example.poc.utils.SpCallerModel;
import com.example.poc.utils.StoredProcedureCaller;

@Service
public class PocServiceImpl implements PocService{
	
	@Autowired
	private StoredProcedureCaller caller;
	
	@Autowired
	private SimpleAdEntAuthenticator userAuthenticator;
	
	@Override
	public void printInfo() {
		System.out.println(userAuthenticator.getProvideUrl());
		System.out.println(userAuthenticator.getDomain());
		System.out.println(userAuthenticator.getSearchBase());
		System.out.println(userAuthenticator.getSearchFilter());
		
	}

	private Map<String, Object> getAdAuthenticateSqlParameters() {
		Map<String, Object> inParams = Map.ofEntries(
				Map.entry("IN_AD_ENT", "1234"), 
				Map.entry("IN_SSO_KEY", "SSO_KEY"), 
				Map.entry("IN_APP", "App"), 
				Map.entry("IN_OS", "Unix"), 
				Map.entry("IN_IP", "IP_ADDRESS"));
		
		return inParams;
	}
	

	@Override
	public int callStoredProcedure(int inParam) {
		SpCallerModel model = new SpCallerModel("SESS.PR_AUTHENTICATE_AD_ENT", getAdAuthenticateSqlParameters());
		Map<String, Object> response = caller.callStoredProcedure(model);
		return Integer.parseInt(response.get("STATUS").toString());
	}

}
