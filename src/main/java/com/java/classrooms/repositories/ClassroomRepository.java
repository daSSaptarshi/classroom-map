package com.java.classrooms.repositories;

import java.util.List;

import com.java.classrooms.models.Classroom;
import com.java.classrooms.transferObjects.response.ClassroomResponse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Integer>{

    @Query(value = "SELECT c.id AS id, c.name AS name, d.id AS directionId FROM classroom AS c LEFT OUTER JOIN direction AS d ON c.id = d.class_room_id_fk ", nativeQuery = true)
    public List<ClassroomResponse> findClassrooms();
    
}
