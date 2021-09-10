package com.java.classrooms.repositories;

import com.java.classrooms.models.Student;
import com.java.classrooms.transferObjects.response.UserResponseDTO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String>{

    public Student findByEmailId(String emailId);
    
}
