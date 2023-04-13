package com.example.springbootapp.teacher;

import com.example.springbootapp.common.Language;
import com.example.springbootapp.teacher.model.Teacher;
import com.example.springbootapp.teacher.model.TeacherDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    public String findAll(Model model){
       model.addAttribute("teachers", teacherService.findAll());
        return "teacher/list";
    }

    @GetMapping("/create")
    public String getcreateForm(Model model){
        model.addAttribute("languages", Language.values());
        return "teacher/form";
    }

    @PostMapping("/create")
    public String createTeacher(Teacher teacher){
        teacherService.save(teacher);
        return "redirect:/teachers";
    }

    @GetMapping(params = "language")
    @ResponseBody
    public List<TeacherDto> findTeachersByLanguage(@RequestParam Language language){
        return teacherService.findAllByLanguage(language).stream().map(TeacherDto::fromEntity).toList();
    }
}
