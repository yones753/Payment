package com.payment.store.service;

import com.payment.store.bean.Order;
import com.payment.store.bean.Payment;
import com.payment.store.repository.OrderRepo;
import com.payment.store.repository.PaymentRepo;
import com.payment.store.service.exceptions.PaymentValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PaymentService {

    @Autowired
    PaymentRepo paymentRepo;
    @Autowired
    OrderRepo orderRepo;

    public Payment pay(Order order) throws PaymentValidationException {
        try{
            Payment newPayment = new Payment();
            if(order.getPrice() < 0){
                throw new PaymentValidationException("Price Not valid!");
            }
            Order newOrder = orderRepo.save(order);
            newPayment.setTotalAmount(order.getPrice());
            newPayment.setOrderList(List.of(newOrder));
            return paymentRepo.save(newPayment);
        }catch (Exception e){
            throw new PaymentValidationException("Something wrong try again");
        }
    }
}
