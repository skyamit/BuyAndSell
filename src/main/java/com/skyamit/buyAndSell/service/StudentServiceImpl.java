package com.skyamit.buyAndSell.service;

import com.skyamit.buyAndSell.dao.StudentDao;
import com.skyamit.buyAndSell.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao studentDao;

    @Override
    public void addStudent(Student student) {
        System.out.println(student);
        studentDao.save(student);
    }

    @Override
    public void deleteStudent(Student student) {
        studentDao.delete(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.save(student);
    }
}
