package com.example.springbootapp.student.controller;

import com.example.springbootapp.student.services.StudentService;
import com.example.springbootapp.student.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudnetController {

    private final StudentService studentService;

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("students", studentService.findAll());
        return "students-list";
    }

    @GetMapping("/create")
    public String getStudnetsCreateForm(){
        return "form";
    }

    @PostMapping("/create")
    public String createStudent(Student student){
        studentService.save(student);
        return "redirect:/students";
    }

    ///asdasdasasd

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id){
        studentService.delete(id);
        return "students-list";
    }

    //dodaje jakis napis


}
