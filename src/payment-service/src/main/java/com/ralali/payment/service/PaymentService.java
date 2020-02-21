package com.ralali.payment.service;

import java.util.List;

import com.ralali.payment.model.database.PaymentType;

public interface PaymentService {

	public List<PaymentType> getAllPaymentType(); 
	public void proccesCreatePayment(String message);
	public void proccesFailedPayment(String message);
}
