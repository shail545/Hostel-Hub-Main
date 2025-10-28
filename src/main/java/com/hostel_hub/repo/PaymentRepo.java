package com.hostel_hub.repo;

import java.util.List;

import com.hostel_hub.entities.Payment;
import com.hostel_hub.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PaymentRepo extends JpaRepository<Payment,Integer>{

    // List<Payment> findByUser(int i);
    List<Payment> findByUser(User user);
    
}
