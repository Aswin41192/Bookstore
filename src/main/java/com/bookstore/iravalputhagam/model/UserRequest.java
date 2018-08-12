package com.bookstore.iravalputhagam.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
@Document(collection="user_requests")
public class UserRequest {

	@Id
	@ApiModelProperty("Primary Key")
	private String id;
	@ApiModelProperty("Name of the user")
	private String name;
	@ApiModelProperty("Name of the book")
	private String book;
	@ApiModelProperty("Author of the book")
	private String author;
	@ApiModelProperty("Email address of the user")
	private String email;
	@ApiModelProperty(hidden=true)
	private Date createdDate;
	@ApiModelProperty(value="Mobile number of the User",allowableValues="10 digit number",example="9840118761")
	private Long mobile;
	@ApiModelProperty(value="Request for Buying/Lending the book",allowableValues="Buy/Lend")
	private String option;
	
	public UserRequest() {
		this.createdDate=new Date();
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

	

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}



	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	@Override
	public String toString() {
		return "UserRequest [id=" + id + ", name=" + name + ", bookName=" + book + ", author=" + author + ", email="
				+ email + ", createdDate=" + createdDate + ", phone=" + mobile + ", option=" + option + "]";
	}
	
	
}
