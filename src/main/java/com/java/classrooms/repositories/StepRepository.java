package com.java.classrooms.repositories;

import com.java.classrooms.models.Step;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public interface StepRepository extends JpaRepository<Step, String>{

    @Modifying
    @Query(value = "DELETE FROM step WHERE id = ?1",nativeQuery = true)
    public void delete(String stepId);

    
}
