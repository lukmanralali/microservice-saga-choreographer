package com.ralali.payment.dao.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RabbitMQDao {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendByTopic(String exchange, String routingKey, String message) {
		rabbitTemplate.convertAndSend(exchange, routingKey, message);
	}
}
