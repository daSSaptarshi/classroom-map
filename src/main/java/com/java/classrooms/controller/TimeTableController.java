package com.java.classrooms.controller;

import java.util.List;

import com.java.classrooms.models.TimeTable;
import com.java.classrooms.services.TimeTableService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/timetable")
public class TimeTableController {
    
    @Autowired
    private TimeTableService timeTableService;

    @GetMapping("/getAll")
    public List<TimeTable> getAll()
    {
        return timeTableService.getAll();
    }
}
