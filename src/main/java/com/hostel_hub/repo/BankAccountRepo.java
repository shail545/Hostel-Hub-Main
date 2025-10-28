package com.hostel_hub.repo;

import java.util.List;

import com.hostel_hub.entities.BankAccount;
import com.hostel_hub.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BankAccountRepo extends JpaRepository<BankAccount, Integer>{
    List<BankAccount> findByUser(User user);
    BankAccount findByCardNumber(String cardNumber);
}
