package com.example.springbootapp.student;

import com.example.springbootapp.student.model.Student;
import com.example.springbootapp.teacher.TeacherRepository;
import com.example.springbootapp.teacher.model.Teacher;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Student save(Student student, Long teacherId){
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new EntityNotFoundException("Message"));
        student.setTeacher(teacher);
        return studentRepository.save(student);
    }

    public List<Student> findAllByTeacherId(Long teacherId){
        return studentRepository.findAllByTeacherId(teacherId);
    }

    public void delete(Long id){
        studentRepository.deleteById(id);
    }


}
