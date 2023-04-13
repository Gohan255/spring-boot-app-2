package com.example.springbootapp.lesson;

import com.example.springbootapp.common.Language;
import com.example.springbootapp.lesson.model.Lesson;
import com.example.springbootapp.student.StudentService;
import com.example.springbootapp.student.model.Student;
import com.example.springbootapp.teacher.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        return "lesson/list";
    }

    @GetMapping("/create")
    public String getLessonCreateForm(Model model){
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("teachers", teacherService.findAll());
        return "lesson/form";
    }

    @PostMapping( "/create")
    public String createLesson(Lesson lesson, @RequestParam("teacherId") Long teacherId, @RequestParam("studentId") Long studentId){
        lessonService.save(lesson, teacherId, studentId);
        return "redirect:/lessons";
    }

}
