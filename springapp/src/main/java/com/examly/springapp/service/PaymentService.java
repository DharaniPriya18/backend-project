package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.Payment;

public interface PaymentService {
    Payment addPayment(Payment payment);
    List<Payment> getAllPayments();
    Payment getPaymentById(String id);
    Payment updatePayment(String id, Payment payment);
}