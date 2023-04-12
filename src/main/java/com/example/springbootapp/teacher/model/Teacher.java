package com.example.springbootapp.teacher.model;


import com.example.springbootapp.common.Language;
import com.example.springbootapp.lesson.model.Lesson;
import com.example.springbootapp.student.model.Student;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "teacher_language", joinColumns = @JoinColumn(name = "teacher_id"))
    @Column(name = "language")
    private List<Language> languages;

    @OneToMany(mappedBy = "teacher")
    private List<Student> students;

    @OneToMany(mappedBy = "teacher")
    private List<Lesson> lessons;

}
