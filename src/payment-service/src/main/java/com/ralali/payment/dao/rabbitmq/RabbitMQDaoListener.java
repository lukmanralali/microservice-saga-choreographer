package com.ralali.payment.dao.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ralali.payment.service.PaymentService;

@Repository
public class RabbitMQDaoListener {

	@Autowired
	private PaymentService paymentService;
	
	@RabbitListener(queues = {"payment-create"})
	public void receivePaymentCreate(String message) {
		paymentService.proccesCreatePayment(message);
	}
	
	@RabbitListener(queues = {"payment-failed"})
	public void receivePaymentFailed(String message) {
		paymentService.proccesFailedPayment(message);
	}
}
