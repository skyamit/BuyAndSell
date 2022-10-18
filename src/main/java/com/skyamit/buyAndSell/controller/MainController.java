package com.skyamit.buyAndSell.controller;

import com.skyamit.buyAndSell.model.Student;
import com.skyamit.buyAndSell.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    StudentServiceImpl studentServiceImpl;

    @GetMapping("/")
    public String home(Model model,HttpSession session){

        if(session.getAttribute("student") != null)
            return "redirect:/user";

        return "home";
    }

    @GetMapping("/register")
    public String registerNow(Model model,@RequestParam("value") Optional<String> value,HttpSession session){

        if(session.getAttribute("student") != null)
            return "redirect:/user";

        if(value.isPresent()){
            model.addAttribute("value",value.get());
        }
        return "register";
    }

    @GetMapping(path="/login")
    public String loginNow(Model model, @RequestParam("wrongCredentials") Optional<String> wrong,HttpSession session){

        if(session.getAttribute("student") != null)
            return "redirect:/user";

        if(wrong.isPresent()){
            model.addAttribute("wrongCredentials",wrong.get());
        }
        return "login";
    }

    @PostMapping("/registerUser")
    public String registerUser(@PathParam("name") String name,
                               @PathParam("gender") String gender,
                               @PathParam("email") String email,
                               @PathParam("password") String password,
                               HttpSession session,
                               Model model){

        if(session.getAttribute("student") != null)
            return "redirect:/user";

        if(studentServiceImpl.checkStudent(email)){
            return "redirect:/register?value=Account already exists";
        }
        Student student = new Student(name, gender,email,password);
        studentServiceImpl.addStudent(student);
        return "redirect:/register?value=Registration successful";
    }

    @GetMapping("/user")
    public String userHome(Model model, HttpSession session){
        if(session.getAttribute("student") == null)
            return "redirect:/login";

        Student  student = (Student)session.getAttribute("student");
        model.addAttribute("student",student);
        return "user";
    }
    @PostMapping("/loginUser")
    public String loginUser(@PathParam("email") String email, @PathParam("password") String password, Model model,HttpSession session){
        Student student = studentServiceImpl.getStudent(email,password);
        if(student==null){
            return "redirect:/login?wrongCredentials=Incorrect Email or Password";
        }
        session.setAttribute("student",student);
        return "redirect:/user";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }
}
