package com.java.classrooms.models;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@Entity
public class Landmark {

    @Id
    private String id;
    private String name;
    private String image;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "studentIdFk", referencedColumnName = "id")
    private Student student;
    @JsonIgnore
    @OneToMany(mappedBy = "landmark")
    private List<Step> step;


    public Landmark()
    {
        this.id = UUID.randomUUID().toString().replaceAll("-", "");
    }
    
}
