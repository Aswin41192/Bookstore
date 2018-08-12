package com.bookstore.iravalputhagam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.iravalputhagam.helper.UserRequestHelper;
import com.bookstore.iravalputhagam.model.UserRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/user/request")
@CrossOrigin
@Api("Manages the user requests")
class UserRequestService {
	
	@Autowired
	private UserRequestHelper  helper;
	
	@RequestMapping(method=RequestMethod.POST)
	@ApiOperation("Saves the request created by the user")
	public int saveUserRequest(@RequestBody UserRequest userRequest) throws Exception {
		int result=-1;
		UserRequest savedRequest= helper.save(userRequest);
		if(savedRequest!=null) {
			helper.sendEmail(savedRequest);
			result=1;
		}
		return result;
	}

}
