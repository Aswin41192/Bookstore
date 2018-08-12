package com.bookstore.iravalputhagam.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
@Document(collection="books")
public class Book {

	@Id
	@ApiModelProperty(value="Primary Key")
	private String id;
	@ApiModelProperty(value="Name of the Book")
	private String name;
	@ApiModelProperty(value="Author of the Book")
	private String author;
	@ApiModelProperty(hidden=true)
	private String path;
	@ApiModelProperty(value="Price of the Book")
	private double price;
	@ApiModelProperty(value="Genere of the Book")
	private String genere;
	@ApiModelProperty(value="Is the book available in the store")
	private boolean available;


	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}


	public Book() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", path=" + path + ", price=" + price
				+ ", genere=" + genere + ", available=" + available + "]";
	}

}
