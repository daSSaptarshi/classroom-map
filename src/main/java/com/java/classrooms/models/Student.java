package com.java.classrooms.models;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Student {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private int enrollmentYear;
    private String name;
    private String userType;
    @Column(unique = true)
    private String emailId;
    private String pwd;
    // @JsonIgnore
    // @OneToMany(mappedBy = "student")
    // private List<Direction> direction;


    public Student()
    {
        id = UUID.randomUUID().toString().replaceAll("-", "");
    }
    
}
