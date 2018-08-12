package com.bookstore.iravalputhagam.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
@Document(collection="orders")
public class UserDetails {
	@ApiModelProperty("Name of the user")
	private String name;
	@ApiModelProperty("Email address of the user")
	private String email;
	@ApiModelProperty("Address of the user")
	private String address;
	@ApiModelProperty(value="Phone number of the user",example="9840118761")
	private long phone;
	
	public UserDetails() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "UserDetails [name=" + name + ", email=" + email + ", address=" + address + ", phone=" + phone + "]";
	}
	
}
