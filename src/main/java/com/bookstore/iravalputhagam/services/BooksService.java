package com.bookstore.iravalputhagam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bookstore.iravalputhagam.helper.BookStoreHelper;
import com.bookstore.iravalputhagam.model.Book;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/books/",produces=MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
@Api("Manages the book in the store")
public class BooksService {
	
	@Autowired
	private BookStoreHelper helper;
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	@ApiOperation(value="Get all available books in the store")
	 public List<Book> getBooks(){
		return helper.getBooks();
	}

	@RequestMapping(value="/getByAuthor/{author}" , method=RequestMethod.GET)
	@ApiOperation(value="Get all available books in the store written by the author")
	public List<Book> getBooksByAuthor(@PathVariable("author") String author){
			return helper.findByAuthor(author);
	}
	
	@RequestMapping(value="/search/{criteria}",method=RequestMethod.GET)
	@ApiOperation(value="Get all available books in the store matching the specified criteria")
	public List<Book> search(@PathVariable("criteria") String criteria){
		return helper.search(criteria);
	}
}
