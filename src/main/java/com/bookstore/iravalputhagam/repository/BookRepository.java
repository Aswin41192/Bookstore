package com.bookstore.iravalputhagam.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bookstore.iravalputhagam.model.Book;

public interface BookRepository extends MongoRepository<Book, String>{

	public List<Book> findByAvailable(boolean available);

	public List<Book> findByAvailableAndAuthor(boolean available, String author);

	@Query("{$or:[{'name':{$regex:?0}},{'author':{$regex:?0}},{'genere':{$regex:?0}}]}")
	public List<Book> search(String criteria);

	public List<Book> findByAvailableOrderByName(boolean b);

}
