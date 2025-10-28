package com.hostel_hub.repo;

import com.hostel_hub.entities.Checkout;
import com.hostel_hub.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckoutRepo extends JpaRepository<Checkout,Integer>{
    Checkout findByUser(User user);
}
