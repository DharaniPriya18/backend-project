package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Payment;
import com.examly.springapp.repository.PaymentRepo;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepo repo;

    @Override
    public Payment addPayment(Payment payment) {
        return repo.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return repo.findAll();
    }

    @Override
    public Payment getPaymentById(String id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Payment updatePayment(String id, Payment payment) {
        Payment existing = repo.findById(id).orElse(null);
        if (existing == null) return null;
        
        existing.setAmount(payment.getAmount());
        existing.setPaymentMethod(payment.getPaymentMethod());
        existing.setBookingId(payment.getBookingId());
        return repo.save(existing);
    }
}