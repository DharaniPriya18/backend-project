package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Guest;
import com.examly.springapp.service.GuestService;

@RestController
@RequestMapping("/api/guests")
public class GuestController {

    @Autowired
    private GuestService service;

    @PostMapping
    public ResponseEntity<Guest> addGuest(@RequestBody Guest guest) {
        Guest saved = service.addGuest(guest);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Guest>> getAllGuests() {
        List<Guest> list = service.getAllGuests();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guest> getGuestById(@PathVariable int id) {
        Guest guest = service.getGuestById(id);
        if (guest == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(guest, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Guest> updateGuest(@PathVariable int id, @RequestBody Guest guest) {
        Guest updated = service.updateGuest(id, guest);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @GetMapping("/phone/{phone}")
    public ResponseEntity<Object> getGuestsByPhone(@PathVariable String phone) {
        List<Guest> guests = service.getGuestsByPhone(phone);
        if (guests.isEmpty()) {
            return new ResponseEntity<>("No guest found with phone: " + phone, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(guests, HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<Guest>> getGuestsByEmail(@PathVariable String email) {
        List<Guest> guests = service.getGuestsByEmail(email);
        return new ResponseEntity<>(guests, HttpStatus.OK);
    }
}
