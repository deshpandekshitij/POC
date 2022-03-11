package com.example.poc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.poc.documents.Book;
import com.example.poc.entities.StudentEntity;
import com.example.poc.repositories.BookRepository;
import com.example.poc.repositories.StudentRepository;
import com.example.poc.service.PocService;

@Service
public class PocServiceImpl implements PocService{
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<StudentEntity> getAllStudent() {
		return studentRepository.findAll();
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public void insertBook(Book book) {		
		
		bookRepository.save(book);
	}
	
	

}
