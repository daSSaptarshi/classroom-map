package com.java.classrooms.repositories;

import java.util.List;

import com.java.classrooms.models.Direction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectionRepository extends JpaRepository<Direction, String>{
    
    // @Query(value = "select count(class_room_id_fk) from direction gourp by class_room_id_fk", nativeQuery = true)
    public boolean existsByClassroom_Id(int id);

    public Direction findByClassroom_Id(int id);

    @Modifying
    @Query(value = "DELETE FROM direction WHERE id = ?1",nativeQuery = true)
    public void delete(String id);

}
