package com.java.classrooms.config;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.classrooms.models.Classroom;
import com.java.classrooms.models.TimeTable;
import com.java.classrooms.repositories.ClassroomRepository;
import com.java.classrooms.repositories.TimeTableRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CommandLineAppStartupRunner implements CommandLineRunner {

    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private TimeTableRepository timeTableRepository;

    @Override
    public void run(String...args) throws Exception 
    {
        // new JdbcTemplate().execute("UPDATE `hibernate_sequence` SET `next_val`=1 WHERE 1");;

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        List<Classroom> listOfClassroom = mapper.readValue (
            "[{\"id\":1,\"name\":\"Room101\"},{\"id\":2,\"name\":\"Room102\"},{\"id\":3,\"name\":\"Room103\"},{\"id\":4,\"name\":\"Room104\"},{\"id\":5,\"name\":\"Room105\"},{\"id\":6,\"name\":\"Room106\"},{\"id\":7,\"name\":\"Room107\"},{\"id\":8,\"name\":\"Room108\"},{\"id\":9,\"name\":\"Room109\"},{\"id\":10,\"name\":\"Room110\"},{\"id\":11,\"name\":\"Room111\"}]", 
            new TypeReference<List<Classroom>>(){});
            if(classroomRepository.count()<1)
            {
                for(Classroom classroom: listOfClassroom)
                    System.out.println(classroomRepository.save(classroom));
            }



        List<TimeTable> listOfTimeTables = mapper.readValue(
            "[{\"groupName\":\"group A\",\"weekNumber\":20,\"classType\":\"Online\",\"courseId\":1,\"courseName\":\"MSCS\",\"endTime\":\"5:00 PM\",\"startTime\":\"6:30 PM\",\"subject\":\"EDM9784M-2\",\"takenBy\":\"Nikolaos Fotou\",\"weekDay\":\"Tuesday\"},{\"groupName\":\"group A\",\"weekNumber\":20,\"classType\":\"Online\",\"courseId\":1,\"courseName\":\"MSCS\",\"endTime\":\"5:00 PM\",\"startTime\":\"6:30 PM\",\"subject\":\"EDM9172M-2\",\"takenBy\":\"Joss Winn\",\"weekDay\":\"Wednesday\"},{\"groupName\":\"group A\",\"weekNumber\":22,\"classType\":\"Online\",\"courseId\":1,\"courseName\":\"MSCS\",\"endTime\":\"5:00 PM\",\"startTime\":\"6:30 PM\",\"subject\":\"EDM9784M-2\",\"takenBy\":\"Nikolaos Fotou\",\"weekDay\":\"Tuesday\"},{\"groupName\":\"group A\",\"weekNumber\":22,\"classType\":\"Online\",\"courseId\":1,\"courseName\":\"MSCS\",\"endTime\":\"5:00 PM\",\"startTime\":\"6:30 PM\",\"subject\":\"EDM9172M-2\",\"takenBy\":\"Joss Winn\",\"weekDay\":\"Wednesday\"},{\"groupName\":\"group A\",\"weekNumber\":23,\"classType\":\"Online\",\"courseId\":1,\"courseName\":\"MSCS\",\"endTime\":\"5:00 PM\",\"startTime\":\"6:30 PM\",\"subject\":\"EDM9784M-2\",\"takenBy\":\"Nikolaos Fotou\",\"weekDay\":\"Tuesday\"},{\"groupName\":\"group A\",\"weekNumber\":23,\"classType\":\"Online\",\"courseId\":1,\"courseName\":\"MSCS\",\"endTime\":\"5:00 PM\",\"startTime\":\"6:30 PM\",\"subject\":\"EDM9172M-2\",\"takenBy\":\"Joss Winn\",\"weekDay\":\"Wednesday\"},{\"groupName\":\"group A\",\"weekNumber\":24,\"classType\":\"Online\",\"courseId\":1,\"courseName\":\"MSCS\",\"endTime\":\"5:00 PM\",\"startTime\":\"6:30 PM\",\"subject\":\"EDM9784M-2\",\"takenBy\":\"Nikolaos Fotou\",\"weekDay\":\"Tuesday\"},{\"groupName\":\"group A\",\"weekNumber\":24,\"classType\":\"Online\",\"courseId\":1,\"courseName\":\"MSCS\",\"endTime\":\"5:00 PM\",\"startTime\":\"6:30 PM\",\"subject\":\"EDM9172M-2\",\"takenBy\":\"Joss Winn\",\"weekDay\":\"Wednesday\"},{\"groupName\":\"group A\",\"weekNumber\":21,\"classType\":\"Online\",\"courseId\":1,\"courseName\":\"MSCS\",\"endTime\":\"5:00 PM\",\"startTime\":\"6:30 PM\",\"subject\":\"EDM9784M-2\",\"takenBy\":\"Nikolaos Fotou\",\"weekDay\":\"Tuesday\"},{\"groupName\":\"group A\",\"weekNumber\":21,\"classType\":\"Online\",\"courseId\":1,\"courseName\":\"MSCS\",\"endTime\":\"5:00 PM\",\"startTime\":\"6:30 PM\",\"subject\":\"EDM9172M-2\",\"takenBy\":\"Joss Winn\",\"weekDay\":\"Wednesday\"},{\"groupName\":\"group A\",\"weekNumber\":27,\"classType\":\"Online\",\"courseId\":1,\"courseName\":\"MSCS\",\"endTime\":\"4:30 PM\",\"startTime\":\"6:30 PM\",\"subject\":\"EDM9784M-2\",\"takenBy\":\"Nikolaos Fotou\",\"weekDay\":\"Tuesday\"},{\"groupName\":\"group A\",\"weekNumber\":27,\"classType\":\"Online\",\"courseId\":1,\"courseName\":\"MSCS\",\"endTime\":\"5:00 PM\",\"startTime\":\"6:30 PM\",\"subject\":\"EDM9172M-2\",\"takenBy\":\"Joss Winn\",\"weekDay\":\"Wednesday\"}]",
            new TypeReference<List<TimeTable>>(){});
        
            if(timeTableRepository.count() < 1)
            {
                for(TimeTable timeTable: listOfTimeTables)
                    System.out.println(timeTableRepository.save(timeTable));
            }
            // timeTableRepository.findAll().forEach(item -> System.out.println(item.toString()));
            // timeTableRepository.findAll().forEach(item -> log.info(item.toString()));
        // listOfTimeTables.forEach(item -> System.out.println(item.toString()));
    }
}