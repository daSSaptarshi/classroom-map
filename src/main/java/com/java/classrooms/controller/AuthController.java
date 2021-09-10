package com.java.classrooms.controller;

import java.sql.SQLIntegrityConstraintViolationException;

import com.java.classrooms.models.Student;
import com.java.classrooms.repositories.StudentRepository;
import com.java.classrooms.transferObjects.request.LoginRequestDTO;
import com.java.classrooms.transferObjects.request.RegisterRequestDTO;
import com.java.classrooms.transferObjects.response.UserResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/login")
    public UserResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        try {
            Student student = studentRepository.findByEmailId(loginRequestDTO.getEmailId());
            if(student == null)
                throw new NullPointerException();
            if (student.getPwd().equals(loginRequestDTO.getPwd())) {
                userResponseDTO.setEmailId(student.getEmailId());
                userResponseDTO.setName(student.getName());
                userResponseDTO.setEnrollmentYear(student.getEnrollmentYear());
                userResponseDTO.setUserType(student.getUserType());
                userResponseDTO.setUserId(student.getId());
                userResponseDTO.setLoggedIn(true);
                userResponseDTO.setMessage("Logged In Successfully");
            } else {
                userResponseDTO.setLoggedIn(false);
                userResponseDTO.setMessage("Credential does not match");
            }
        } catch (NullPointerException e) {
            userResponseDTO.setLoggedIn(false);
            userResponseDTO.setMessage("No user present with this email");
        } catch (Exception e) {
            e.printStackTrace();
            userResponseDTO.setLoggedIn(false);
            userResponseDTO.setMessage("Internal server error");
        }
        return userResponseDTO;
    }

    @PostMapping("/register")
    public UserResponseDTO register(@RequestBody RegisterRequestDTO registerRequestDTO) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        log.info(registerRequestDTO.toString());
        try {
            Student student = studentRepository.findByEmailId(registerRequestDTO.getEmailId());
            if (student != null) {
                throw new SQLIntegrityConstraintViolationException();
            } else {
                student = new Student();
            }
            student.setEmailId(registerRequestDTO.getEmailId());
            student.setName(registerRequestDTO.getName());
            student.setEnrollmentYear(registerRequestDTO.getEnrollmentYear());
            student.setUserType(registerRequestDTO.getUserType());
            student.setPwd(registerRequestDTO.getPwd());

            studentRepository.save(student);

            userResponseDTO.setEmailId(registerRequestDTO.getEmailId());
            userResponseDTO.setName(registerRequestDTO.getName());
            userResponseDTO.setEnrollmentYear(registerRequestDTO.getEnrollmentYear());
            userResponseDTO.setUserType(registerRequestDTO.getUserType());
            userResponseDTO.setUserId(student.getId());
            userResponseDTO.setLoggedIn(true);
            userResponseDTO.setMessage("Logged In Successfully");
        } catch (SQLIntegrityConstraintViolationException e) {
            userResponseDTO.setLoggedIn(false);
            userResponseDTO.setMessage("Email already present");
        } catch (NullPointerException e) {
            userResponseDTO.setLoggedIn(false);
            userResponseDTO.setMessage("No user present with this email");
        } catch (Exception e) {
            userResponseDTO.setLoggedIn(false);
            userResponseDTO.setMessage("Internal server error");
        }
        return userResponseDTO;
    }

}
