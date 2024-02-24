package com.payment.store.repository;

import com.payment.store.bean.Order;
import com.payment.store.bean.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepo extends JpaRepository<Payment,Integer> {

}
