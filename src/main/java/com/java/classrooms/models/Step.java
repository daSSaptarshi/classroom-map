package com.java.classrooms.models;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@Entity
public class Step 
{
    @Id
    private String id;
    private String instructions;
    @JsonProperty("isLandmark")
    @JsonAlias("isLandmark")
    @Column(name = "isLandmark")
    private boolean itLandmark;
    // @ManyToOne(cascade = CascadeType.REMOVE , fetch = FetchType.EAGER)
    // @JoinColumn(name = "directionIdFk", referencedColumnName = "id")
    // @JsonIgnore
    // private Direction stepDirection;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "landmarkIdFk", referencedColumnName = "id")
    private Landmark landmark;

    public Step()
    {
        this.id = UUID.randomUUID().toString().replaceAll("-", "");
    }


    
}
