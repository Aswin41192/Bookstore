package com.bookstore.iravalputhagam.constants;
public interface AppConstants {
	
	enum ORDER_HEADERS{
		NAME,
		AUTHOR,
		PRICE
	};
	
	String TABLE_DATA_START="<td style='border:2px solid black;text-align: left;'>";
	String TABLE_DATA_END="</td>";
	String LINE_BREAK="<br/>";
	String ORDER_CONFIRMATION="Order Confirmation";
	String ORDER_NOTIFICATION="Order Arrived!";
	String USER_REQUEST="User Request Arrived!";
	String SELF="iravalputhagam@gmail.com";
	String SWAGGER_API_TITLE="Iravalputhagam";
	String SWAGGER_API_DESCRIPTION="This api allows to order a book online";
	String SWAGGER_API_VERSION="1.0";
	String SWAGGER_API_SERVICE_URL="http://localhost:8080/bookstore/";
	String SWAGGER_API_CONTACT_NAME="Aswin Sankaranarayanan";
	String SWAGGER_API_CONTACT_EMAIL="aswins41192@gmail.com";
	
	

}
