package com.java.classrooms.services;

import java.util.List;

import com.java.classrooms.models.TimeTable;
import com.java.classrooms.repositories.TimeTableRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeTableService {

    @Autowired
    private TimeTableRepository timeTableRepository;

    public List<TimeTable> getAll()
    {
        return timeTableRepository.findAll();
    }
    
}
