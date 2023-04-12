package com.example.springbootapp.teacher.model;

import com.example.springbootapp.common.Language;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class TeacherDto {

    private Long id;
    private String name;
    private String surname;
    private List<Language> languages;

    public static TeacherDto fromEntity(Teacher teacher){
        return TeacherDto.builder()
                .id(teacher.getId())
                .name(teacher.getName())
                .surname(teacher.getSurname())
                .languages(teacher.getLanguages())
                .build();
    }

}
