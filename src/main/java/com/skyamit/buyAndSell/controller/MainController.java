package com.skyamit.buyAndSell.controller;

import com.skyamit.buyAndSell.model.Student;
import com.skyamit.buyAndSell.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.websocket.server.PathParam;

@Controller
public class MainController {

    @Autowired
    StudentServiceImpl studentServiceImpl;

    @GetMapping("/")
    public String home(Model model){
        return "home";
    }

    @GetMapping("/register")
    public String registerNow(){
        return "register";
    }

    @GetMapping("/login")
    public String loginNow(){
        return "login";
    }

    @PostMapping("/registerStudent")
    public String registerStudent(@PathParam("firstName") String firstName, @PathParam("lastName") String lastName,
                                   @PathParam("gender") String gender, @PathParam("email") String email,@PathParam("password") String password ){

        Student student = new Student(firstName,lastName,gender,email,password);
        studentServiceImpl.addStudent(student);
        return "redirect:/register";
    }
}
