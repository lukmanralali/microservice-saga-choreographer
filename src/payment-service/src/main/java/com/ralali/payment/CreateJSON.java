package com.ralali.payment;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.ralali.payment.model.rabbitmq.OrderCreate;
import com.ralali.payment.model.rabbitmq.OrderData;
import com.ralali.payment.model.rabbitmq.OrderPaymentDetail;

public class CreateJSON {

	
	public static void main(String[] args) {
		System.out.println("helo");
		
		OrderData data = new OrderData();
		data.setTransactionNumber("be54df54-53a6-11ea-8d77-2e728ce88125");
		
		OrderCreate create = new OrderCreate();
		create.setId(1);
		create.setOrderSerial("1234/ORD/01/01/2020");
		create.setPaymentTypeId(1);
		create.setShippingId(12);
		create.setTotalAmount(Double.valueOf("1000000"));
		create.setUserId(1);
		
		OrderPaymentDetail opd1 = new OrderPaymentDetail();
		opd1.setAmount(Double.valueOf("600000"));
		opd1.setId(1);
		OrderPaymentDetail opd2 = new OrderPaymentDetail();
		opd2.setAmount(Double.valueOf("400000"));
		opd2.setId(2);
		List<OrderPaymentDetail> orderPaymentDetails = new ArrayList<OrderPaymentDetail>();
		orderPaymentDetails.add(opd1);
		orderPaymentDetails.add(opd2);
		create.setPaymentDetail(orderPaymentDetails);
		
		data.setData(create);
		
		System.out.println(new Gson().toJson(data));
		
		
	}
}
