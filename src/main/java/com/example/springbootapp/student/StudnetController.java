package com.example.springbootapp.student;

import com.example.springbootapp.common.Language;
import com.example.springbootapp.student.StudentService;
import com.example.springbootapp.student.model.Student;
import com.example.springbootapp.teacher.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudnetController {

    private final StudentService studentService;
    private final TeacherService teacherService;

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("students", studentService.findAll());
        return "student/students-list";
    }

    @GetMapping("/create")
    public String getStudnetsCreateForm(Model model){
        model.addAttribute("languages", Language.values());
        model.addAttribute("teachers", teacherService.findAll());
        return "student/form";
    }

    @PostMapping("/create")
    public String createStudent(Student student){
        studentService.save(student);
        return "redirect:/students";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id){
        studentService.delete(id);
        return "student/students-list";
    }

}
