package com.oashsing.tutorialspringdatajpa.repository;

import com.oashsing.tutorialspringdatajpa.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    private CourseRepository courseRepository;

    @Autowired
    public CourseRepositoryTest(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Test
    public void printCourses() {
        List<Course> courses = courseRepository.findAll();
        System.out.println(courses);
    }
}