package com.example.springbootapp.lesson;

import com.example.springbootapp.lesson.model.Lesson;
import com.example.springbootapp.student.StudentRepository;
import com.example.springbootapp.student.model.Student;
import com.example.springbootapp.teacher.TeacherRepository;
import com.example.springbootapp.teacher.model.Teacher;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonService {
    private final LessonRepository lessonRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    public Lesson save(Lesson lesson, Long teacherId, Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("message"));
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new EntityNotFoundException("message"));
        lesson.setStudent(student);
        lesson.setTeacher(teacher);
        return lessonRepository.save(lesson);
    }
}
