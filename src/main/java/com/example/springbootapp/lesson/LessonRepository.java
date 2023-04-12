package com.example.springbootapp.lesson;

import com.example.springbootapp.lesson.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
