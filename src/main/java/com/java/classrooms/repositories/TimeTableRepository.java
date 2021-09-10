package com.java.classrooms.repositories;

import com.java.classrooms.models.TimeTable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeTableRepository extends JpaRepository<TimeTable, String>{
    
}
