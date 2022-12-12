package com.oashsing.tutorialspringdatajpa.repository;

import com.oashsing.tutorialspringdatajpa.entity.Course;
import com.oashsing.tutorialspringdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

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

    @Test
    public void saveCourseWithTeacher() {

        Teacher teacher
                = Teacher.builder()
                .firstName("Teacher2")
                .lastName("SirName2")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

        List<Course> courses = courseRepository.findAll(secondPageWithTwoRecords)
                .getContent();

        System.out.println(courses);
    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle = PageRequest.of(0,2, Sort.by("title"));
        Pageable sortByCreditDesc = PageRequest.of(0,2, Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc = PageRequest.of(0,2, Sort.by("title").descending().and(Sort.by("credit").descending()));

        List<Course> courses = courseRepository.findAll(sortByTitle)
                .getContent();
        System.out.println(courses);

    }

    @Test
    public void printFindBtTitleContaining() {
        Pageable firstPageTenRecords = PageRequest.of(0, 10);

        List<Course> courses = courseRepository.findByTitleContaining("D", firstPageTenRecords).getContent();
        System.out.println(courses);
    }
}