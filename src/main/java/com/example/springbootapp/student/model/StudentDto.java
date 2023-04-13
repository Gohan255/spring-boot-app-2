package com.example.springbootapp.student.model;

import com.example.springbootapp.teacher.model.Teacher;
import com.example.springbootapp.teacher.model.TeacherDto;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StudentDto {

    private Long id;
    private String name;
    private String surname;


    public static StudentDto fromEntity(Student student){
        return StudentDto.builder()
                .id(student.getId())
                .name(student.getName())
                .surname(student.getSurname())
                .build();
    }
}
