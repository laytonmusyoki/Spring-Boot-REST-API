package com.firstSpring.rest_api.repository;

import com.firstSpring.rest_api.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
