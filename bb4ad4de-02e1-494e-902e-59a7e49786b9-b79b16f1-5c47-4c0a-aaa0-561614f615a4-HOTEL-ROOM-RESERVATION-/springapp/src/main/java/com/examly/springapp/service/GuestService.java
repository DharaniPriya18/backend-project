package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.Guest;

public interface GuestService {
    Guest addGuest(Guest guest);
    List<Guest> getAllGuests();
    Guest getGuestById(int id);
    Guest updateGuest(int id, Guest guest);
    List<Guest> getGuestsByPhone(String phone);
    List<Guest> getGuestsByEmail(String email);
}