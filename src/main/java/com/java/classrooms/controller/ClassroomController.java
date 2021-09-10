package com.java.classrooms.controller;

import java.util.List;

import com.java.classrooms.models.Classroom;
import com.java.classrooms.repositories.ClassroomRepository;
import com.java.classrooms.transferObjects.response.ClassroomResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/classroom")
public class ClassroomController 
{
    @Autowired
    ClassroomRepository classroomRepository;

    @GetMapping(value="/getDirection/{id}")
    public Classroom getMethodName(@PathVariable int id) {
        return classroomRepository.findById(id).get();
    }

    @GetMapping("/getAll")
    public List<ClassroomResponse> getAll()
    {
        return classroomRepository.findClassrooms();
    }
    
}
