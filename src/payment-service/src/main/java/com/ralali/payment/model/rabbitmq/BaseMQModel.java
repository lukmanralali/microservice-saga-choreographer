package com.ralali.payment.model.rabbitmq;

import com.google.gson.annotations.SerializedName;

public class BaseMQModel {
	@SerializedName("transaction_number")
	private String transactionNumber;

	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	
}
