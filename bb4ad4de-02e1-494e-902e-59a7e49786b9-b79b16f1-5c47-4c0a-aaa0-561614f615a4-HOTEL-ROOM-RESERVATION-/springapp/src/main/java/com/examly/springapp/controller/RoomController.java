package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Room;
import com.examly.springapp.service.RoomService;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomService service;

    @PostMapping
    public ResponseEntity<Room> addRoom(@RequestBody Room room) {
        Room saved = service.addRoom(room);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> list = service.getAllRooms();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable int id) {
        Room room = service.getRoomById(id);
        if (room == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable int id, @RequestBody Room room) {
        Room updated = service.updateRoom(id, room);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @GetMapping("/number/{roomNumber}")
    public ResponseEntity<Object> getRoomByNumber(@PathVariable String roomNumber) {
        List<Room> rooms = service.getRoomsByNumber(roomNumber);
        if (rooms.isEmpty()) {
            return new ResponseEntity<>("No room found with number: " + roomNumber, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/category/{categoryName}")
    public ResponseEntity<List<Room>> getRoomsByCategoryName(@PathVariable String categoryName) {
        List<Room> rooms = service.getRoomsByCategoryName(categoryName);
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }
}
