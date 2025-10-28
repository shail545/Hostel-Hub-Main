package com.hostel_hub.repo;

import java.util.List;

import com.hostel_hub.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findUserByUserEmail(String email);
    List<User> findUserByRoles(String roles);
    User findById(int id);
    List<User> findUserByHostelNumber(int hostelNumber);
}

