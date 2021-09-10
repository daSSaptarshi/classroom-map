package com.java.classrooms.transferObjects.response;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@ToString
public class UserResponseDTO {
    private String userId;
    private int enrollmentYear;
    private String name;
    private String userType;
    private String emailId;
    private String pwd;
    private String message;
    private boolean isLoggedIn;

    public UserResponseDTO()
    {
        // this.enrollmentYear = new Date().getYear();
        // this.userType="volunteer";
        this.isLoggedIn=false;
    }
}
