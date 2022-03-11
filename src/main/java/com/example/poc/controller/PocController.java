package com.example.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.poc.documents.Book;
import com.example.poc.entities.StudentEntity;
import com.example.poc.service.PocService;

@RestController
@RequestMapping("/api")
public class PocController {
	
	@Autowired
	private PocService service;

	@GetMapping("/v1/oracle")
	public List<StudentEntity> getDataFromOracle() {
		return service.getAllStudent();
	}
	
	@PostMapping("/v1/mongo/insert")
	public String insertBook(@RequestBody Book book) {
		service.insertBook(book);
		return "SUCCESS";
	}
	
	@GetMapping("/v1/mongo/fetch")
	public List<Book> getDataFrommongoDb() {
		return service.getAllBooks();
	}

}
