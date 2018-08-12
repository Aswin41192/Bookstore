package com.bookstore.iravalputhagam.repository;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.iravalputhagam.model.Orders;

public interface OrderRepository extends CrudRepository<Orders, String> {

}
