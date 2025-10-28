package com.hostel_hub.repo;

import com.hostel_hub.entities.Review;
import com.hostel_hub.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Review, Integer>{
    Review findReviewByUser(User user);
}
