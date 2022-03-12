package com.example.poc.serviceimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Service;

import com.example.poc.service.PocService;

@Service
public class PocServiceImpl implements PocService{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int callStoredProcedure(int inParam) {
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.NVARCHAR), 
				new SqlParameter(Types.NVARCHAR),
				new SqlParameter(Types.NVARCHAR),
				new SqlParameter(Types.NVARCHAR),
				new SqlParameter(Types.NVARCHAR),
				new SqlOutParameter("STATUS" ,Types.INTEGER),
				new SqlOutParameter("USER_ID", Types.INTEGER),
				new SqlOutParameter("SESSION_ID", Types.NVARCHAR));
		String userName = "abcd";
		String ssoKey = "sso parameter";
		String app = "app parameter";
		String remoteAddr = "remote address";
		
		Map<String, Object> output = jdbcTemplate.call(new CallableStatementCreator() {

			@Override
			public CallableStatement createCallableStatement(Connection con) throws SQLException {

				CallableStatement cs = con.prepareCall("{call PR_AUTHENTICATE_AD_ENT(?, ?, ?, ?, ?, ?, ?, ?)}");
				cs.setString(1, userName);
				cs.setString(2, ssoKey);
				cs.setString(3, app);
				cs.setString(4, "UNIX");
				cs.setString(5, remoteAddr);
				cs.registerOutParameter(6, Types.INTEGER);
				cs.registerOutParameter(7, Types.INTEGER);
				cs.registerOutParameter(8, Types.NVARCHAR);
				return cs;
			}
		}, parameters);
		
		System.out.println(output);
		return Integer.parseInt(output.get("STATUS").toString());
	}

	
	

}
