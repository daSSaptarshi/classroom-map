package com.java.classrooms.models;

import java.util.Map;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
// @NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class TimeTable {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private int courseId;
    private String courseName;
    private String weekDay;
    private String takenBy;
    private String subject;
    private String startTime;
    private String endTime;
    // private int classroomId;
    // @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // @JoinColumn(name = "classroomIdFk", referencedColumnName = "id")
    // @JsonIgnoreProperties("classroomId")
    // private Classroom classroom;

    public TimeTable()
    {
        id = UUID.randomUUID().toString().replaceAll("-", "");
    }

}
