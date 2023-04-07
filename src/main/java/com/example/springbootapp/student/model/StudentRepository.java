package com.example.springbootapp.student.model;


import com.example.springbootapp.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

/*
    private static final List<Student> students = new ArrayList<>();

*/

  /*  public List<Student> findAll(){
        return students;
    }

    public void save(Student student){
        students.add(student);
    }
    @PostConstruct
    public void init(){
        Student student = Student.builder()
                .id(1)
                .name("Jan")
                .surname("Konieczny")
                .build();
        Student student1 = Student.builder()
                .id(2)
                .name("Andrzej")
                .surname("Waligora")
                .build();
        students.add(student);
        students.add(student1);
    }*/

}
