package com.payment.store.controller;


import com.payment.store.api.PaymentControllerIFC;
import com.payment.store.bean.Order;
import com.payment.store.bean.Payment;
import com.payment.store.service.PaymentService;
import com.payment.store.service.exceptions.PaymentValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController implements PaymentControllerIFC {
    @Autowired
    PaymentService paymentService;
    public ResponseEntity<?> pay(@RequestBody Order order) {
        try{
            return new ResponseEntity<>(paymentService.pay(order), HttpStatus.CREATED);
        }catch (PaymentValidationException e){
            return new ResponseEntity<>(new PaymentValidationException(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}
