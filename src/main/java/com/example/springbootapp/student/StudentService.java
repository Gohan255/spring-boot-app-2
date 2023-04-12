package com.example.springbootapp.student;

import com.example.springbootapp.common.Language;
import com.example.springbootapp.student.model.Student;
import com.example.springbootapp.teacher.model.Teacher;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Student save(Student student){
        return studentRepository.save(student);
    }

    public void delete(Long id){
        studentRepository.deleteById(id);
    }


}
