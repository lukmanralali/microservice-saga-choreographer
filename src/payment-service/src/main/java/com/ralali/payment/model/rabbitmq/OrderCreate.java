package com.ralali.payment.model.rabbitmq;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class OrderCreate {

	private Integer id;
	
	@SerializedName("user_id")
	private Integer userId;
	
	@SerializedName("order_serial")
	private String orderSerial;
	
	@SerializedName("shipping_id")
	private Integer shippingId;
	
	@SerializedName("payment_type_id")
	private Integer paymentTypeId;
	
	@SerializedName("payment_detail")
	private List<OrderPaymentDetail> paymentDetail;
	
	@SerializedName("total_amount")
	private Double totalAmount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getOrderSerial() {
		return orderSerial;
	}

	public void setOrderSerial(String orderSerial) {
		this.orderSerial = orderSerial;
	}

	public Integer getShippingId() {
		return shippingId;
	}

	public void setShippingId(Integer shippingId) {
		this.shippingId = shippingId;
	}

	public Integer getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentTypeId(Integer paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public List<OrderPaymentDetail> getPaymentDetail() {
		return paymentDetail;
	}

	public void setPaymentDetail(List<OrderPaymentDetail> paymentDetail) {
		this.paymentDetail = paymentDetail;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

}
