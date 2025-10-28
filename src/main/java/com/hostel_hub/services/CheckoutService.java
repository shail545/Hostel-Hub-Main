package com.hostel_hub.services;

import java.util.ArrayList;
import java.util.List;

import com.hostel_hub.entities.Checkout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostel_hub.repo.CheckoutRepo;
import com.hostel_hub.repo.UserRepo;

@Service
public class CheckoutService {
    
    @Autowired
    private CheckoutRepo checkoutRepo;

    @Autowired
    private UserRepo userRepo;

    public List<Checkout> getpendingCheckoutList(){
        List<Checkout> list = checkoutRepo.findAll();
        List<Checkout> checkouts = new ArrayList<>();
        for(Checkout checkout: list){
            if(checkout.getStatus().equalsIgnoreCase("pending")){
                checkouts.add(checkout);
            }
        }
        return checkouts;
    }

}
