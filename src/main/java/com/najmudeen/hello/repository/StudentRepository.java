package com.najmudeen.hello.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.najmudeen.hello.entity.Students;

@Repository
public interface StudentRepository extends JpaRepository<Students, String> {
    
}