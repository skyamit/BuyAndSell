package com.skyamit.buyAndSell.dao;

import com.skyamit.buyAndSell.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentDao extends JpaRepository<Student,Long> {

    @Query(value = "select * from student where email=:email and password=:password", nativeQuery = true)
    Student getStudent(String email, String password);

}
