package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Booking;
import com.examly.springapp.repository.BookingRepo;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepo repo;

    @Override
    public Booking addBooking(Booking booking) {
        return repo.save(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return repo.findAll();
    }

    @Override
    public Booking getBookingById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Booking updateBooking(int id, Booking booking) {
        Booking existing = repo.findById(id).orElse(null);
        if (existing == null) return null;
        
        existing.setRoom(booking.getRoom());
        existing.setGuest(booking.getGuest());
        existing.setCheckInDate(booking.getCheckInDate());
        existing.setCheckOutDate(booking.getCheckOutDate());
        return repo.save(existing);
    }
}