package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.Booking;

public interface BookingService {
    Booking addBooking(Booking booking);
    List<Booking> getAllBookings();
    Booking getBookingById(int id);
    Booking updateBooking(int id, Booking booking);
}