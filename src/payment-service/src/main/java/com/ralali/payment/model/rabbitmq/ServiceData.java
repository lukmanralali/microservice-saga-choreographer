package com.ralali.payment.model.rabbitmq;

import com.google.gson.annotations.SerializedName;

public class ServiceData extends BaseMQModel{

	@SerializedName("data")
	private ServiceStatus data;

	public ServiceStatus getData() {
		return data;
	}

	public void setData(ServiceStatus data) {
		this.data = data;
	}
	
	
}
