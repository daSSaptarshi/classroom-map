package com.java.classrooms.transferObjects.response;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@Getter
@Setter
@ToString
@Component
public class LoginResponseDTO {
    private String message;
    private int id;
    private String studentName;
    private String studentEmail;
}
