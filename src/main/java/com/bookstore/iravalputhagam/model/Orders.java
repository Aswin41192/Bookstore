package com.bookstore.iravalputhagam.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
@Document(collection = "orders")
public class Orders {

	@Id
	@ApiModelProperty(hidden = true)
	private String id;
	@ApiModelProperty("Details of the user who ordered the book")
	private UserDetails userDetails;
	@ApiModelProperty("List of Books purchased")
	private List<Book> items;
	@ApiModelProperty(hidden = true)
	private Date createdDate;

	public Orders() {
		this.items = new ArrayList<>();
		this.createdDate = new Date();
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public List<Book> getItems() {
		return items;
	}

	public void setItems(List<Book> items) {
		this.items = items;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", userDetails=" + userDetails + ", items=" + items + ", createdDate=" + createdDate
				+ "]";
	}

}
