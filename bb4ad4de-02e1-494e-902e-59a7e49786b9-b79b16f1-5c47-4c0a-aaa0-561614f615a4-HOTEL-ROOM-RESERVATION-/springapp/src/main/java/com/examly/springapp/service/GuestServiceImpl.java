package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Guest;
import com.examly.springapp.repository.GuestRepo;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestRepo repo;

    @Override
    public Guest addGuest(Guest guest) {
        return repo.save(guest);
    }

    @Override
    public List<Guest> getAllGuests() {
        return repo.findAll();
    }

    @Override
    public Guest getGuestById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Guest updateGuest(int id, Guest guest) {
        Guest existing = repo.findById(id).orElse(null);
        if (existing == null) return null;
        
        existing.setName(guest.getName());
        existing.setPhone(guest.getPhone());
        existing.setEmail(guest.getEmail());
        return repo.save(existing);
    }

    @Override
    public List<Guest> getGuestsByPhone(String phone) {
        return repo.findByPhone(phone);
    }

    @Override
    public List<Guest> getGuestsByEmail(String email) {
        return repo.findByEmail(email);
    }
}