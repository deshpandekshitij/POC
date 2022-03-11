package com.example.poc.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.poc.documents.Book;

public interface BookRepository extends MongoRepository<Book, Long>{
	
	List<Book> findAll();

}
