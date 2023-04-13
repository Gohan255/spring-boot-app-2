package com.example.springbootapp.student;

import com.example.springbootapp.common.Language;
import com.example.springbootapp.student.model.Student;
import com.example.springbootapp.student.model.StudentDto;
import com.example.springbootapp.teacher.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    private final TeacherService teacherService;

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("students", studentService.findAll());
        return "student/list";
    }

    @GetMapping("/create")
    public String getStudnetsCreateForm(Model model){
        model.addAttribute("languages", Language.values());
        model.addAttribute("teachers", teacherService.findAll());
        return "student/form";
    }

    @PostMapping("/create")
    public String createStudent(Student student, @RequestParam("teacherId") Long teacherId){
        studentService.save(student, teacherId);
        return "redirect:/students";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id){
        studentService.delete(id);
        return "student/list";
    }

    @GetMapping(params = "teacherId")
    @ResponseBody
    public List<StudentDto> findAllByTeacherId(@RequestParam Long teacherId){
        return studentService.findAllByTeacherId(teacherId).stream().map(StudentDto::fromEntity).toList();
    }

}
