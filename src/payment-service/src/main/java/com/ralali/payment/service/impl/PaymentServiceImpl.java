package com.ralali.payment.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.ralali.payment.dao.database.PaymentDao;
import com.ralali.payment.dao.database.PaymentTypeDao;
import com.ralali.payment.dao.rabbitmq.RabbitMQDao;
import com.ralali.payment.model.database.Payment;
import com.ralali.payment.model.database.PaymentDetail;
import com.ralali.payment.model.database.PaymentType;
import com.ralali.payment.model.database.constant.PaymentResumeStatus;
import com.ralali.payment.model.rabbitmq.BaseMQModel;
import com.ralali.payment.model.rabbitmq.OrderData;
import com.ralali.payment.model.rabbitmq.ServiceData;
import com.ralali.payment.model.rabbitmq.ServiceStatus;
import com.ralali.payment.service.PaymentService;

@Service
@Transactional(readOnly = true)
public class PaymentServiceImpl implements PaymentService{

	@Autowired PaymentTypeDao paymentTypeDao;
	@Autowired PaymentDao paymentDao;
	@Autowired RabbitMQDao rabbitMQDao;
	
	@Override
	public List<PaymentType> getAllPaymentType() {
		return paymentTypeDao.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public void proccesCreatePayment(String message) {
		OrderData orderData;
		ServiceData serviceData = new ServiceData();
		try {
			orderData = new Gson().fromJson(message, OrderData.class);
			serviceData.setTransactionNumber(orderData.getTransactionNumber());
			
			Payment payment = new Payment();
			payment.setCreatedAt(new Date());
			payment.setTransactionID(orderData.getTransactionNumber());
			payment.setUpdatedAt(new Date());
			
			List<PaymentDetail> paymentDetails = new ArrayList<PaymentDetail>();
			payment.setPaymentDetails(paymentDetails);
			payment.setPaymentResumeStatus(PaymentResumeStatus.WAITING);
			payment.setUserId(orderData.getOrder().getUserId());

			paymentDao.save(payment);
		
			serviceData.setData(new ServiceStatus("payment-service", true));
			rabbitMQDao.sendByTopic("", "transaction-update", new Gson().toJson(serviceData));
		} catch (Exception e) {
			serviceData.setData(new ServiceStatus("payment-service", false));
			rabbitMQDao.sendByTopic("", "transaction-update", new Gson().toJson(serviceData));
		}
	}

	@Override
	@Transactional(readOnly = false)
	public void proccesFailedPayment(String message) {
		BaseMQModel baseOrder = new Gson().fromJson(message, BaseMQModel.class);
		System.out.println("received message failed: ");
		System.out.println(new Gson().toJson(baseOrder));
	}

}
