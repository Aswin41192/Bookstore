package com.bookstore.iravalputhagam.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bookstore.iravalputhagam.model.UserRequest;

public interface UserRequestRepository extends MongoRepository<UserRequest,String> {

}
