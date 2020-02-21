package com.ralali.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ralali.payment.dao.rabbitmq.RabbitMQDao;

@SpringBootApplication
public class PaymentApplication implements CommandLineRunner{

	@Autowired
	RabbitMQDao mqDao;
	
	public static void main(String[] args) {
		SpringApplication.run(PaymentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		mqDao.sendByTopic(exchange, routingKey, message);
//		mqDao.sendByTopic("", "payment-create", "test message");
//		System.out.println("running");
	}



}
