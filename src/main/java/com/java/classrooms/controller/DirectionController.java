package com.java.classrooms.controller;

import com.java.classrooms.models.Direction;
import com.java.classrooms.services.DirectionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/direction")
public class DirectionController {

    @Autowired
    DirectionService directionService;

    @PostMapping("/add")
    public Direction addDirection(@RequestBody Direction direction)
    {
        return directionService.addDirection(direction);
    }
 
    @GetMapping("/getById/{id}")
    public Direction getById(@PathVariable String id) {
        return directionService.getDirection(id);
    }

    @GetMapping("/getByClassId/{id}")
    public ResponseEntity<Direction> getByClassId(@PathVariable int id) {
        if(directionService.getByClassId(id) == null)
            return new ResponseEntity<>(directionService.getByClassId(id), HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(directionService.getByClassId(id), HttpStatus.OK);
    }
    
    
}
