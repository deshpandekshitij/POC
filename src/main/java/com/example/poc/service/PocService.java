package com.example.poc.service;

import java.util.List;

import com.example.poc.documents.Book;
import com.example.poc.entities.StudentEntity;

public interface PocService {
	
	public List<StudentEntity> getAllStudent();
	
	public List<Book> getAllBooks();
	
	public void insertBook(Book book);

}
