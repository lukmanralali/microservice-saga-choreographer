package com.ralali.payment.model.rabbitmq;

import com.google.gson.annotations.SerializedName;

public class OrderData extends BaseMQModel{

	@SerializedName("data")
	private OrderCreate data;

	public OrderCreate getOrder() {
		return data;
	}

	public void setData(OrderCreate data) {
		this.data = data;
	}
	
	
}
