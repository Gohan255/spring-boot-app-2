package com.example.springbootapp.student.services;

import com.example.springbootapp.student.model.StudentRepository;
import com.example.springbootapp.student.model.Student;
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
