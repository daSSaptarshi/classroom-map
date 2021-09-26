package com.java.classrooms.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Classroom 
{
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @JsonProperty("name")
    @Column(name = "name")
    private String name;
    @Transient
    private String directionId;
    // @JsonIgnore
    // @OneToOne(mappedBy = "classroom", orphanRemoval = true)
    // private Direction classroomDirection;
    // @OneToOne(mappedBy = "classroom", orphanRemoval = true)  
    // private TimeTable timeTable;
}
