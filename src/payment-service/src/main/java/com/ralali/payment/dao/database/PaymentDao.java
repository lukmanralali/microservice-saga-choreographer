package com.ralali.payment.dao.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ralali.payment.model.database.Payment;

@Repository
public interface PaymentDao extends JpaRepository<Payment, Integer>{

	
}
