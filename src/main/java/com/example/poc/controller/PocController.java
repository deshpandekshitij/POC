package com.example.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.poc.service.PocService;

@RestController
@RequestMapping("/api")
public class PocController {
	
	@Autowired
	private PocService service;

	@GetMapping("/v1/oracle/sp/{inParam}")
	public int getDataFromOracle(@PathVariable int inParam) {
		return service.callStoredProcedure(inParam);
	}
}
