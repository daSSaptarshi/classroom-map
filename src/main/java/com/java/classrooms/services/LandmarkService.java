package com.java.classrooms.services;

import java.util.List;

import com.java.classrooms.models.Landmark;
import com.java.classrooms.repositories.LandmarkReposiory;
import com.java.classrooms.repositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LandmarkService {
    
    @Autowired
    LandmarkReposiory landmarkReposiory;

    @Autowired
    StudentRepository studentRepository;

    public Landmark createLandmark(Landmark landmark)
    {
        landmark.setStudent(studentRepository.findByEmailId(landmark.getStudent().getEmailId()));
        return landmarkReposiory.save(landmark);
    }

    public Landmark getLandmark(String id)
    {
        return landmarkReposiory.findById(id).get();
    }

    public List<Landmark> getAllLandmarks()
    {
        return landmarkReposiory.findAll();
    }
}
