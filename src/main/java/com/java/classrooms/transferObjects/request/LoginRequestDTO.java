package com.java.classrooms.transferObjects.request;

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
public class LoginRequestDTO {
    private String emailId;
    private String pwd;
}
