package com.example.poc.serviceimpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import com.example.poc.service.PocService;

@Service
public class PocServiceImpl implements PocService{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int callStoredProcedure(int inParam) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("sample_sp");
		
		Map<String, Object> result = simpleJdbcCall.execute(new MapSqlParameterSource("in_param", inParam));
		
		System.out.println(result.get("OUT_PARAM"));
		
		return  Integer.parseInt(result.get("OUT_PARAM").toString());
	}

	
	

}
