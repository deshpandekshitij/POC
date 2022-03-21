package com.example.poc.utils;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

@Component
public class StoredProcedureCaller {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Map<String, Object> callStoredProcedure(SpCallerModel model) {
//		Setup Simple Jdbc Call
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName(model.getProcedureName());
//		Call Stored procedure
		Map<String, Object> result = simpleJdbcCall.execute(new MapSqlParameterSource(model.getInputParams()));
		
		return result;
	}

}
