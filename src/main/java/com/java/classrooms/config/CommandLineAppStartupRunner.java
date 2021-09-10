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
            "[{\"courseId\":123,\"courseName\":\"CS101\",\"weekDay\":\"Monday\",\"takenBy\":\"Andrew Symon\",\"subject\":\"Data Science\",\"startTime\":\"11:00\",\"endTime\":\"12:00\",\"classroom\":{\"id\":2}},{\"courseId\":124,\"courseName\":\"CS101\",\"weekDay\":\"Monday\",\"takenBy\":\"Andrew Symon\",\"subject\":\"Math\",\"startTime\":\"12:00\",\"endTime\":\"13:00\",\"classroom\":{\"id\":2}},{\"courseId\":125,\"courseName\":\"CS101\",\"weekDay\":\"Monday\",\"takenBy\":\"Andrew Symon\",\"subject\":\"Networking\",\"startTime\":\"13:00\",\"endTime\":\"14:00\",\"classroom\":{\"id\":3}},{\"courseId\":126,\"courseName\":\"CS101\",\"weekDay\":\"Tuesday\",\"takenBy\":\"Andrew Symon\",\"subject\":\"Computer Graphics\",\"startTime\":\"11:00\",\"endTime\":\"12:00\",\"classroom\":{\"id\":4}},{\"courseId\":127,\"courseName\":\"CS101\",\"weekDay\":\"Tuesday\",\"takenBy\":\"Andrew Symon\",\"subject\":\"Digital\",\"startTime\":\"12:00\",\"endTime\":\"13:00\",\"classroom\":{\"id\":5}},{\"courseId\":128,\"courseName\":\"CS101\",\"weekDay\":\"Tuesday\",\"takenBy\":\"Andrew Symon\",\"subject\":\"Math\",\"startTime\":\"13:00\",\"endTime\":\"14:00\",\"classroom\":{\"id\":2}},{\"courseId\":129,\"courseName\":\"CS101\",\"weekDay\":\"Wednesday\",\"takenBy\":\"Andrew Symon\",\"subject\":\"Entrepreneurship\",\"startTime\":\"11:00\",\"endTime\":\"12:00\",\"classroom\":{\"id\":6}},{\"courseId\":130,\"courseName\":\"CS101\",\"weekDay\":\"Wednesday\",\"takenBy\":\"Andrew Symon\",\"subject\":\"Data Science\",\"startTime\":\"12:00\",\"endTime\":\"13:00\",\"classroom\":{\"id\":1}},{\"courseId\":131,\"courseName\":\"CS101\",\"weekDay\":\"Wednesday\",\"takenBy\":\"Andrew Symon\",\"subject\":\"Networking\",\"startTime\":\"13:00\",\"endTime\":\"14:00\",\"classroom\":{\"id\":3}},{\"courseId\":132,\"courseName\":\"CS101\",\"weekDay\":\"Thursday\",\"takenBy\":\"Andrew Symon\",\"subject\":\"Math\",\"startTime\":\"11:00\",\"endTime\":\"12:00\",\"classroom\":{\"id\":2}},{\"courseId\":133,\"courseName\":\"CS101\",\"weekDay\":\"Thursday\",\"takenBy\":\"Andrew Symon\",\"subject\":\"Circuit\",\"startTime\":\"12:00\",\"endTime\":\"13:00\",\"classroom\":{\"id\":7}},{\"courseId\":134,\"courseName\":\"CS101\",\"weekDay\":\"Thursday\",\"takenBy\":\"Andrew Symon\",\"subject\":\"Computer Graphics\",\"startTime\":\"13:00\",\"endTime\":\"14:00\",\"classroom\":{\"id\":4}},{\"courseId\":135,\"courseName\":\"CS101\",\"weekDay\":\"Friday\",\"takenBy\":\"Andrew Symon\",\"subject\":\"Digital\",\"startTime\":\"11:00\",\"endTime\":\"12:00\",\"classroom\":{\"id\":5}},{\"courseId\":136,\"courseName\":\"CS101\",\"weekDay\":\"Friday\",\"takenBy\":\"Andrew Symon\",\"subject\":\"Circuit\",\"startTime\":\"12:00\",\"endTime\":\"13:00\",\"classroom\":{\"id\":7}},{\"courseId\":137,\"courseName\":\"CS101\",\"weekDay\":\"Friday\",\"takenBy\":\"Andrew Symon\",\"subject\":\"Networking\",\"startTime\":\"13:00\",\"endTime\":\"14:00\",\"classroom\":{\"id\":3}},{\"courseId\":138,\"courseName\":\"ME101\",\"weekDay\":\"Monday\",\"takenBy\":\"Drew Matt\",\"subject\":\"Material Science\",\"startTime\":\"11:00\",\"endTime\":\"12:00\",\"classroom\":{\"id\":8}},{\"courseId\":139,\"courseName\":\"ME101\",\"weekDay\":\"Monday\",\"takenBy\":\"Drew Matt\",\"subject\":\"Strength of Materials\",\"startTime\":\"12:00\",\"endTime\":\"13:00\",\"classroom\":{\"id\":9}},{\"courseId\":140,\"courseName\":\"ME101\",\"weekDay\":\"Monday\",\"takenBy\":\"Drew Matt\",\"subject\":\"Thermodynamics\",\"startTime\":\"13:00\",\"endTime\":\"14:00\",\"classroom\":{\"id\":10}},{\"courseId\":141,\"courseName\":\"ME101\",\"weekDay\":\"Tuesday\",\"takenBy\":\"Drew Matt\",\"subject\":\"Aerodynamics\",\"startTime\":\"11:00\",\"endTime\":\"12:00\",\"classroom\":{\"id\":11}},{\"courseId\":142,\"courseName\":\"ME101\",\"weekDay\":\"Tuesday\",\"takenBy\":\"Drew Matt\",\"subject\":\"Material Science\",\"startTime\":\"12:00\",\"endTime\":\"13:00\",\"classroom\":{\"id\":8}},{\"courseId\":143,\"courseName\":\"ME101\",\"weekDay\":\"Tuesday\",\"takenBy\":\"Drew Matt\",\"subject\":\"Strength of Materials\",\"startTime\":\"13:00\",\"endTime\":\"14:00\",\"classroom\":{\"id\":9}},{\"courseId\":144,\"courseName\":\"ME101\",\"weekDay\":\"Wednesday\",\"takenBy\":\"Drew Matt\",\"subject\":\"Material Science\",\"startTime\":\"11:00\",\"endTime\":\"12:00\",\"classroom\":{\"id\":8}},{\"courseId\":145,\"courseName\":\"ME101\",\"weekDay\":\"Wednesday\",\"takenBy\":\"Drew Matt\",\"subject\":\"Strength of Materials\",\"startTime\":\"12:00\",\"endTime\":\"13:00\",\"classroom\":{\"id\":9}},{\"courseId\":146,\"courseName\":\"ME101\",\"weekDay\":\"Wednesday\",\"takenBy\":\"Drew Matt\",\"subject\":\"Thermodynamics\",\"startTime\":\"13:00\",\"endTime\":\"14:00\",\"classroom\":{\"id\":10}},{\"courseId\":147,\"courseName\":\"ME101\",\"weekDay\":\"Thursday\",\"takenBy\":\"Drew Matt\",\"subject\":\"Strength of Materials\",\"startTime\":\"11:00\",\"endTime\":\"12:00\",\"classroom\":{\"id\":9}},{\"courseId\":148,\"courseName\":\"ME101\",\"weekDay\":\"Thursday\",\"takenBy\":\"Drew Matt\",\"subject\":\"Thermodynamics\",\"startTime\":\"12:00\",\"endTime\":\"13:00\",\"classroom\":{\"id\":10}},{\"courseId\":149,\"courseName\":\"ME101\",\"weekDay\":\"Thursday\",\"takenBy\":\"Drew Matt\",\"subject\":\"Aerodynamics\",\"startTime\":\"13:00\",\"endTime\":\"14:00\",\"classroom\":{\"id\":11}},{\"courseId\":150,\"courseName\":\"ME101\",\"weekDay\":\"Friday\",\"takenBy\":\"Drew Matt\",\"subject\":\"Material Science\",\"startTime\":\"11:00\",\"endTime\":\"12:00\",\"classroom\":{\"id\":8}},{\"courseId\":151,\"courseName\":\"ME101\",\"weekDay\":\"Friday\",\"takenBy\":\"Drew Matt\",\"subject\":\"Strength of Materials\",\"startTime\":\"12:00\",\"endTime\":\"13:00\",\"classroom\":{\"id\":9}},{\"courseId\":152,\"courseName\":\"ME101\",\"weekDay\":\"Friday\",\"takenBy\":\"Drew Matt\",\"subject\":\"Strength of Materials\",\"startTime\":\"13:00\",\"endTime\":\"14:00\",\"classroom\":{\"id\":9}}]",
            new TypeReference<List<TimeTable>>(){});
        
            if(timeTableRepository.count() < 1)
            {
                timeTableRepository.saveAll(listOfTimeTables);
            }
            // timeTableRepository.findAll().forEach(item -> System.out.println(item.toString()));
            // timeTableRepository.findAll().forEach(item -> log.info(item.toString()));
        // listOfTimeTables.forEach(item -> System.out.println(item.toString()));
    }
}