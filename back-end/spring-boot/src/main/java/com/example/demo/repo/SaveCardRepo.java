package com.example.demo.repo;

import com.example.demo.entity.SaveCard;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaveCardRepo extends JpaRepository<SaveCard,String> {
}
