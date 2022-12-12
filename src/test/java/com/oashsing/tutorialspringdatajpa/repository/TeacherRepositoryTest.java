package com.oashsing.tutorialspringdatajpa.repository;

import com.oashsing.tutorialspringdatajpa.entity.Course;
import com.oashsing.tutorialspringdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    private TeacherRepository repository;

    @Autowired
    public TeacherRepositoryTest(TeacherRepository repository) {
        this.repository = repository;
    }

    @Test
    public void saveTeacher() {

        Course courseDBA = Course.builder()
                .title("DBA")
                .credit(5)
                .build();

        Course courseReact = Course.builder()
                .title("React")
                .credit(9)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("TeacherFirst")
                .lastName("TeacherLast")
//                .courses(List.of(courseDBA, courseReact))
                .build();

        repository.save(teacher);
    }
}