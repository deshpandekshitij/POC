package com.example.poc.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SimpleAdEntAuthenticator {
	
	@Value("${authenticator.provideurl}")
	private String provideUrl;
	
	@Value("${authenticator.domain}")
	private String domain;
	
	@Value("${authenticator.searchbase}")
	private String searchBase;
	
	@Value("${authenticator.searchfilter}")
	private String searchFilter;

	public String getProvideUrl() {
		return provideUrl;
	}

	public void setProvideUrl(String provideUrl) {
		this.provideUrl = provideUrl;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getSearchBase() {
		return searchBase;
	}

	public void setSearchBase(String searchBase) {
		this.searchBase = searchBase;
	}

	public String getSearchFilter() {
		return searchFilter;
	}

	public void setSearchFilter(String searchFilter) {
		this.searchFilter = searchFilter;
	}

}
