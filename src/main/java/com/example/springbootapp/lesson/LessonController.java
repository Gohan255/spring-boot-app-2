package com.example.springbootapp.lesson;

import com.example.springbootapp.student.StudentService;
import com.example.springbootapp.teacher.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/lessons")
public class LessonController {

    private final LessonService lessonService;
    private final TeacherService teacherService;
    private final StudentService studentService;

    @GetMapping
    public String getAllLessons(Model model){
        model.addAttribute("lessons", lessonService.findAll());
        return "lesson/lessons-list";
    }



}
