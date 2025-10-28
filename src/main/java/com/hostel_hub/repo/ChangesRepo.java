package com.hostel_hub.repo;

import com.hostel_hub.entities.Changes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChangesRepo extends JpaRepository<Changes,Integer>{
       
}
