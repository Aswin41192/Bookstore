package com.bookstore.iravalputhagam.services;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.iravalputhagam.helper.OrderHelper;
import com.bookstore.iravalputhagam.model.Orders;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Api("Manages the orders placed by the user")
public class OrderService {
	
	@Autowired
	private OrderHelper orderHelper;
	
	@RequestMapping(value="/createOrder",method=RequestMethod.POST)
	@ApiOperation(value="Created an order")
	public int createOrder(@RequestBody Orders orders) throws Exception  {
			int result=-1;
			Orders savedDocument=orderHelper.save(orders);
			System.out.println("Saved!!!"+savedDocument);
			System.out.println("From DB:"+orderHelper.findById(savedDocument));
			if(savedDocument!=null) {
				orderHelper.updateBookAvailability(orders);
				orderHelper.sendEmail(orders);
				result=1;
			}
			return result;
	}
	
	@ApiOperation("Get all the orders")
	@RequestMapping(value="/getAllOrders",produces=MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.GET)
	public List<Orders> getAllOrders(){
		return orderHelper.getAllOrders();
	}
	
}
