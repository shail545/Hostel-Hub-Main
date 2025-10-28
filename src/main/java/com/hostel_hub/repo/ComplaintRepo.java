package com.hostel_hub.repo;

import com.hostel_hub.entities.Complaint;
import com.hostel_hub.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepo extends JpaRepository<Complaint,Integer>{
    Complaint findComplaintByUser(User user);
    Complaint findComplaintById(int id);
}
