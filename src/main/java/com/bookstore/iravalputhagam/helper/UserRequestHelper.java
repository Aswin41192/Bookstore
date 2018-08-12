package com.bookstore.iravalputhagam.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bookstore.iravalputhagam.constants.AppConstants;
import com.bookstore.iravalputhagam.model.UserRequest;
import com.bookstore.iravalputhagam.repository.UserRequestRepository;
import com.bookstore.iravalputhagam.utility.EmailUtility;

@Component
public class UserRequestHelper {

	@Autowired
	private UserRequestRepository repository;
	
	@Autowired
	private EmailUtility emailUtility;
	
	public UserRequest save(UserRequest request) {
		return repository.save(request);
	}

	public void sendEmail(UserRequest request) throws Exception {
		StringBuilder builder=new StringBuilder();
		builder.append("Name:"+request.getName()+AppConstants.LINE_BREAK);
		builder.append("EMail:"+request.getEmail()+AppConstants.LINE_BREAK);
		builder.append("Phone:"+request.getMobile()+AppConstants.LINE_BREAK);
		builder.append("Option:"+request.getOption()+AppConstants.LINE_BREAK);
		builder.append("Book:"+request.getBook()+AppConstants.LINE_BREAK);
		builder.append("Author:"+request.getAuthor()+AppConstants.LINE_BREAK);
		emailUtility.sendEmail(AppConstants.SELF, AppConstants.USER_REQUEST, builder.toString());
	}
}
