package com.java.classrooms.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.java.classrooms.models.Classroom;
import com.java.classrooms.models.Direction;
import com.java.classrooms.models.Step;
import com.java.classrooms.repositories.ClassroomRepository;
import com.java.classrooms.repositories.DirectionRepository;
import com.java.classrooms.repositories.LandmarkReposiory;
import com.java.classrooms.repositories.StepRepository;
import com.java.classrooms.repositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class DirectionService {
    
    @Autowired
    private DirectionRepository directionRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private LandmarkReposiory landmarkReposiory;

    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private StepRepository stepRepository;

    Direction direction;

    @Transactional
    public Direction addDirection(Direction directionParam)
    {
        this.direction = directionParam;
        ArrayList<Step> listOfSteps = new ArrayList<>();
        direction
            .setStudent(
                studentRepository
                    .findByEmailId(
                        direction
                            .getStudent()
                            .getEmailId()
                    )
            );
        
        direction.setClassroom(
            classroomRepository.findById(
                direction.getClassroom().getId()
            ).get()
        );

        // log.info(direction.toString());
            
        for(Step step: direction.getSteps())
        {
            if(step.isItLandmark())
            {
                step.setLandmark(
                    landmarkReposiory.findById(
                        step.getLandmark().getId()
                    ).get()
                );
            }
            listOfSteps.add(step);
        }
        direction.setSteps(listOfSteps);

        if(directionRepository.existsByClassroom_Id(direction.getClassroom().getId()))
        {
            // System.out.println("****************************************************************");
            // Direction existingDirection = directionRepository.findByClassroom_Id(direction.getClassroom().getId());
            //                                     // .findAll()
            //                                     // .stream()
            //                                     // .filter(item -> !item.getId().equals(this.direction.getId()))
            //                                     // .collect(Collectors.toList());
            // for(Step step : existingDirection.getSteps())
            //     stepRepository.delete(step.getId());
            // for (Step step : direction.getSteps()) 
            // {
            //     step.setStepDirection(direction);
            //     stepRepository.save(step);
            // }

            this.direction = directionRepository.findByClassroom_Id(direction.getClassroom().getId());
   
        }
        else
        {
            this.direction = directionRepository.saveAndFlush(direction);
        }
        return direction;
        // return direction;
    }

    public Direction getDirection(String id)
    {
        return directionRepository.findById(id).get();
    }

    public Direction getByClassId(int id)
    {
        return directionRepository.findByClassroom_Id(id);
    }

    
}
