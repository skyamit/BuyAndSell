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
    public Student getStudent(String email, String password) {
        return studentDao.getStudent(email,password);
    }

    @Override
    public void addStudent(Student student) {
        studentDao.save(student);
    }

    public boolean checkStudent(String email){
        if(studentDao.exists(email)==null)
            return false;
        return true;
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
