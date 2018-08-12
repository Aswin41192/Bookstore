package com.bookstore.iravalputhagam.helper;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bookstore.iravalputhagam.constants.AppConstants;
import com.bookstore.iravalputhagam.constants.AppConstants.ORDER_HEADERS;
import com.bookstore.iravalputhagam.model.Orders;
import com.bookstore.iravalputhagam.model.UserDetails;
import com.bookstore.iravalputhagam.repository.BookRepository;
import com.bookstore.iravalputhagam.repository.OrderRepository;
import com.bookstore.iravalputhagam.utility.EmailUtility;

@Component
public class OrderHelper {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private EmailUtility emailUtility;

	float total = 0;

	public Orders save(Orders document) {
		return orderRepository.save(document);
	}

	public Optional<Orders> findById(Orders document) {
		return orderRepository.findById(document.getId());
	}

	public void sendEmail(Orders orders) throws Exception {
		emailUtility.sendEmail(orders.getUserDetails().getEmail(),AppConstants.ORDER_CONFIRMATION, getMailTextForUser(orders));
		emailUtility.sendEmail(AppConstants.SELF, AppConstants.ORDER_NOTIFICATION, getMailTextForAdmin(orders));
	}
	
	private float getTotal(Orders items) {
		total=0;
		items.getItems().forEach(item -> {
			total += item.getPrice();
		});
		return total;
	}
	
	private void populateMessage(Orders items, StringBuilder buffer) {
		buffer.append("Amount to be paid is Rs:" + total + "\n");
		buffer.append("<p><b>Books purchased </b></p>");
		buffer.append("<table style='border:2px solid black;border-collapse: collapse;width:90%'>");
		buffer.append("<tr>");
		for(ORDER_HEADERS column:AppConstants.ORDER_HEADERS.values()) {
			buffer.append("<th style='border: 2px solid black;padding:10px'>"+column+"</th>");
		}
		buffer.append("</tr>");
		items.getItems().forEach(item -> {
			buffer.append("<tr>");
			buffer.append(AppConstants.TABLE_DATA_START + item.getName() + AppConstants.TABLE_DATA_END);
			buffer.append(AppConstants.TABLE_DATA_START + item.getAuthor() + AppConstants.TABLE_DATA_END);
			buffer.append(AppConstants.TABLE_DATA_START+ item.getPrice() + AppConstants.TABLE_DATA_END);
			buffer.append("</tr>");
		});
		buffer.append("</table>");
	}

	private String getMailTextForUser(Orders items) {
		StringBuilder builder = new StringBuilder();
		builder.append("Thank you!!, this the acknowledgement for your order.");
		total=getTotal(items);
		populateMessage(items, builder);
		builder.append("Our executive will call you soon!!! Have a nice day \n");
		return builder.toString();
	}

	

	private String getMailTextForAdmin(Orders items) {
		StringBuilder buffer = new StringBuilder();
		UserDetails userDetails=items.getUserDetails();
		buffer.append("Name:"+userDetails.getName()+AppConstants.LINE_BREAK);
		buffer.append("Email:"+userDetails.getEmail()+AppConstants.LINE_BREAK);
		buffer.append("Address:"+userDetails.getAddress()+AppConstants.LINE_BREAK);
		buffer.append("Mobile:"+userDetails.getPhone()+AppConstants.LINE_BREAK);
		total=getTotal(items);
		populateMessage(items, buffer);
		return buffer.toString();
	}
	
	public void updateBookAvailability(Orders orders) {
		orders.getItems().forEach(book -> {
			book.setAvailable(false);
			bookRepository.save(book);
		});

	}

	public List<Orders> getAllOrders() {
		return (List<Orders>) orderRepository.findAll();
	}
}
