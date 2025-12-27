package com.examly.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Room;

@Repository
public interface RoomRepo extends JpaRepository<Room,Integer> {
    List<Room> findByRoomNumber(String roomNumber);
    
    @Query("SELECT r FROM Room r WHERE r.roomCategory.categoryName = :categoryName")
    List<Room> findByRoomCategoryCategoryName(@Param("categoryName") String categoryName);
} 
