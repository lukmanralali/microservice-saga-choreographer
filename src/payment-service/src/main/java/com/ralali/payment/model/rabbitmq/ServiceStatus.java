package com.ralali.payment.model.rabbitmq;

import com.google.gson.annotations.SerializedName;

public class ServiceStatus {

	
	public ServiceStatus(String serviceName, Boolean status) {
		this.serviceName = serviceName;
		this.status = status;
	}
	@SerializedName("service_name")
	private String serviceName;
	private Boolean status;
	
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
}
