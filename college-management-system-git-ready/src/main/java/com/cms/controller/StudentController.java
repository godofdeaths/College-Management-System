package com.cms.controller;

import com.cms.model.Student;
import com.cms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    private boolean auth(HttpSession session){ return session.getAttribute("user")!=null; }

    @GetMapping("/")
    public String list(Model model, HttpSession session){
        if(!auth(session)) return "redirect:/login";
        model.addAttribute("students", studentRepository.findAll());
        return "students/list";
    }

    @GetMapping("/add")
    public String addForm(Model model, HttpSession session){
        if(!auth(session)) return "redirect:/login";
        model.addAttribute("student", new Student());
        return "students/add";
    }

    @PostMapping("/add")
    public String add(Student student){
        studentRepository.save(student);
        return "redirect:/students/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model, HttpSession session){
        if(!auth(session)) return "redirect:/login";
        Optional<Student> s = studentRepository.findById(id);
        if(s.isPresent()){
            model.addAttribute("student", s.get());
            return "students/edit";
        }
        return "redirect:/students/";
    }

    @PostMapping("/update")
    public String update(Student student){
        studentRepository.save(student);
        return "redirect:/students/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        studentRepository.deleteById(id);
        return "redirect:/students/";
    }
}
