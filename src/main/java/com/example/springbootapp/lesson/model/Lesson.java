package com.example.springbootapp.lesson.model;

import com.example.springbootapp.student.model.Student;
import com.example.springbootapp.teacher.model.Teacher;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime term;
    @ManyToOne
    private Teacher teacher;
    @ManyToOne
    private Student student;
}
