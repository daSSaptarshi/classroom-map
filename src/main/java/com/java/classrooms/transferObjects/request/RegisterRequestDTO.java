package com.java.classrooms.transferObjects.request;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@ToString
public class RegisterRequestDTO {
    private int enrollmentYear;
    private String name;
    private String userType;
    private String emailId;
    private String pwd;

    RegisterRequestDTO()
    {
        this.enrollmentYear = new Date().getYear();
        this.userType="volunteer";
    }
}
