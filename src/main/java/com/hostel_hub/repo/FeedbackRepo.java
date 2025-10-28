package com.hostel_hub.repo;

import com.hostel_hub.entities.Feedback;
import com.hostel_hub.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FeedbackRepo extends JpaRepository<Feedback, Integer>{
    Feedback findByUser(User user);
}
