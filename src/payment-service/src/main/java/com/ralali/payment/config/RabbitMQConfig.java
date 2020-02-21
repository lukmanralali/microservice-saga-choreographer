package com.ralali.payment.config;

import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	
	private static final boolean IS_DURABLE = false;

	@Value("${rabbitmq.queue.payment.create}")
	String paymentCreateQueue;
	
	@Value("${rabbitmq.queue.payment.failed}")
	String paymentFailedQueue;
	
	@Bean
	public Declarables queueDefinition() {
		Queue paymentCreate = new Queue(paymentCreateQueue, IS_DURABLE);
		Queue paymentFailed = new Queue(paymentFailedQueue, IS_DURABLE);
		return new Declarables(paymentCreate, paymentFailed);
	}
}
