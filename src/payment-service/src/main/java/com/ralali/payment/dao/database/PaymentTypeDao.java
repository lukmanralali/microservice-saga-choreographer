package com.ralali.payment.dao.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ralali.payment.model.database.PaymentType;

@Repository
public interface PaymentTypeDao extends JpaRepository<PaymentType, Integer>{

	List<PaymentType> findAll();
}
