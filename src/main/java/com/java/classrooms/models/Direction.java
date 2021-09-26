package com.java.classrooms.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@Entity
public class Direction
{
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private int likes;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "addedByFk", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_direction_student"))
    private Student student;
    // @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "classRoomIdFk", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_direction_classroom"))
    private Classroom classroom;
    @OneToMany(targetEntity = Step.class, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "directionIdFk", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_direction_step"))
    private List<Step> steps;

    public Direction()
    {
        this.id = UUID.randomUUID().toString().replaceAll("-", "");
    }

    public void addLike()
    {
        this.likes += 1;
    }

    public void addStep(Step step)
    {
        this.steps.add(step);
    }
    
}
