package com.java.classrooms.repositories;

import com.java.classrooms.models.Landmark;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LandmarkReposiory extends JpaRepository<Landmark, String> 
{
    
}
