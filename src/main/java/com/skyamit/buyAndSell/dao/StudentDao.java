package com.skyamit.buyAndSell.dao;

import com.skyamit.buyAndSell.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student,Long> {

}
