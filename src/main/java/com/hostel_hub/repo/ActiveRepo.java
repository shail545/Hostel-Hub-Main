package com.hostel_hub.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hostel_hub.entities.Activite;
import com.hostel_hub.entities.User;



public interface ActiveRepo extends JpaRepository<Activite, Integer>{

    Activite findByUser(User user);
    
} 
