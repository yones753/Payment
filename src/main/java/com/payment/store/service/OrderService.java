package com.payment.store.service;


import com.payment.store.bean.Order;
import com.payment.store.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    public Order createOrder(Order order){
        return orderRepo.save(order);
    }
}
