package com.example.springbootapp.teacher;

import com.example.springbootapp.common.Language;
import com.example.springbootapp.teacher.model.Teacher;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> findAll(){
        return teacherRepository.findAll();
    }

    public Teacher save(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    public List<Teacher> findAllByLanguage(Language language) {
        return teacherRepository.findAllByLanguagesContaining(language);
    }

    @PostConstruct
    public void init(){
        teacherRepository.save(Teacher.builder()
                .id(1L)
                .name("Jan")
                .surname("Jan")
                .languages(List.of(Language.JAVA, Language.PHP))
                .build());
        teacherRepository.save(Teacher.builder()
                .id(2L)
                .name("Andrzej")
                .surname("Andrzej")
                .languages(List.of(Language.PHP))
                .build());
    }
}
