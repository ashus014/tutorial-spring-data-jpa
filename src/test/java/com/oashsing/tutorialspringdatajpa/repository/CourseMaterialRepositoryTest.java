package com.oashsing.tutorialspringdatajpa.repository;

import com.oashsing.tutorialspringdatajpa.entity.Course;
import com.oashsing.tutorialspringdatajpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {

    private CourseMaterialRepository repository;

    @Autowired
    public CourseMaterialRepositoryTest(CourseMaterialRepository repository) {
        this.repository = repository;
    }

    @Test
    public void saveCourseMaterial() {

        Course course = Course.builder()
                .title("ASP.NET")
                .credit(6)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.javatpoint.com")
                .course(course)
                .build();

        repository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials() {
        List<CourseMaterial> courseMaterials = repository.findAll();
        System.out.println(courseMaterials);
    }
}