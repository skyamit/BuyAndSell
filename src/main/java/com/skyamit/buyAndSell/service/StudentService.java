package com.skyamit.buyAndSell.service;

import com.skyamit.buyAndSell.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    void addStudent(Student student);

    void deleteStudent(Student student);

    void updateStudent(Student student);
}