package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Room;
import com.examly.springapp.repository.RoomRepo;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepo repo;

    @Override
    public Room addRoom(Room room) {
        return repo.save(room);
    }

    @Override
    public List<Room> getAllRooms() {
        return repo.findAll();
    }

    @Override
    public Room getRoomById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Room updateRoom(int id, Room room) {
        Room existing = repo.findById(id).orElse(null);
        if (existing == null) return null;
        
        existing.setRoomNumber(room.getRoomNumber());
        existing.setPricePerNight(room.getPricePerNight());
        existing.setAvailable(room.isAvailable());
        existing.setRoomCategory(room.getRoomCategory());
        return repo.save(existing);
    }

    @Override
    public List<Room> getRoomsByNumber(String roomNumber) {
        return repo.findByRoomNumber(roomNumber);
    }

    @Override
    public List<Room> getRoomsByCategoryName(String categoryName) {
       return repo.findByRoomCategoryCategoryName(categoryName);
    }
}