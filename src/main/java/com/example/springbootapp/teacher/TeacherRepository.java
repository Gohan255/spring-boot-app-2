package com.example.springbootapp.teacher;

import com.example.springbootapp.common.Language;
import com.example.springbootapp.teacher.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findAllByLanguagesContaining(Language language);
}
