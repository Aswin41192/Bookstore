package com.bookstore.iravalputhagam.helper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bookstore.iravalputhagam.model.Book;
import com.bookstore.iravalputhagam.repository.BookRepository;

@Component
public class BookStoreHelper {

	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getBooks(){
		return bookRepository.findByAvailableOrderByName(true);
	}
	
	public List<Book> findByAuthor(String author){
		return bookRepository.findByAvailableAndAuthor(true, author);
	}
	
	public List<Book> search(String criteria){
		return bookRepository.search(criteria);
	}
}
