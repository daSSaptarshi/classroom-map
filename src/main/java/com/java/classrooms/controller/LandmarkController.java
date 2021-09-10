package com.java.classrooms.controller;

import java.util.List;

import com.java.classrooms.models.Landmark;
import com.java.classrooms.services.LandmarkService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/landmark")
public class LandmarkController {
    
    @Autowired
    LandmarkService landmarkService;

    @GetMapping("/getOne/{id}")
    public Landmark getLandmark(@PathVariable String id)
    {
        return landmarkService.getLandmark(id);
    }

    @GetMapping("/getAll")
    public List<Landmark> getAllLandmarks()
    {
        return landmarkService.getAllLandmarks();
    }

    @PostMapping("/create")
    public Landmark createLandmark(@RequestBody Landmark landmark)
    {
        // System.out.println(landmark.toString());
        return landmarkService.createLandmark(landmark);
    }
}
