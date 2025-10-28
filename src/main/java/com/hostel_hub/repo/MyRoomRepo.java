package com.hostel_hub.repo;

import java.util.List;
import java.util.Optional;

import com.hostel_hub.entities.MyRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hostel_hub.entities.User;



public interface MyRoomRepo extends JpaRepository<MyRoom, Integer>{
    MyRoom findById(int id);
    MyRoom findMyRoomByUser(User user);
    long countByStatus(String status);
    List<MyRoom> findByStatus(String status);
    MyRoom findRoomByRoomNumber(String roomNumber);
    Optional<MyRoom> findByRoomNumber(String roomNumber);
    
}
