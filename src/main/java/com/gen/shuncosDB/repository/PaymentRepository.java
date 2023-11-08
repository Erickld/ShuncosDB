package com.gen.shuncosDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gen.shuncosDB.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
