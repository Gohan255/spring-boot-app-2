package com.example.springbootapp.student.model;


import com.example.springbootapp.common.Language;
import com.example.springbootapp.lesson.model.Lesson;
import com.example.springbootapp.teacher.TeacherRepository;
import com.example.springbootapp.teacher.model.Teacher;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;

    @Enumerated(EnumType.STRING)
    private Language language;

    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacher;
    @OneToMany(mappedBy = "student")
    private List<Lesson> lessons;

}
