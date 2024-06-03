package com.example.assessment.dao.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assessment.dao.Users;
import java.util.Optional;


public interface UsersRepo extends JpaRepository<Users, Integer>{
    
    Optional<Users> findByUserId(String userId);
    Optional<Users> findByEmail(String email);
    Optional<Users> findByUserIdAndIdNot(String userId, int id);
    Optional<Users> findByEmailAndIdNot(String email, int id);
    Page<Users> findAll(Pageable pageable);
}
