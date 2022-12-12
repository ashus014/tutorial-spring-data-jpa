package com.oashsing.tutorialspringdatajpa.repository;

import com.oashsing.tutorialspringdatajpa.entity.Guardian;
import com.oashsing.tutorialspringdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    private StudentRepository studentRepository;

    @Autowired
    public StudentRepositoryTest(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("email@email.com")
                .firstName("Test")
                .lastName("Student")
                //.guardianName("Parent")
                //.guardianEmail("parent@email.com")
                //.guardianMobile("123")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .email("parent@email.com")
                .mobile("123")
                .name("Parent")
                .build();

        Student student = Student.builder()
                .firstName("Test2")
                .emailId("email2@email.com")
                .lastName("Student")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> studentList = studentRepository.findByFirstName("Test2");
        System.out.println(studentList);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> studentList = studentRepository.findByFirstNameContaining("2");
        System.out.println(studentList);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> studentList = studentRepository.findByGuardianName("Parent");
        System.out.println(studentList);
    }

    @Test
    public void getStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("email@email.com");
        System.out.println(student);
    }

    @Test
    public void getStudentFirstNameByEmailAddress() {
        String studentName = studentRepository.getStudentFirstNameByEmailAddress("email2@email.com");
        System.out.println(studentName);
    }

    @Test
    public void getStudentByEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("email@email.com");
        System.out.println(student);
    }

    @Test
    public  void getStudentByEmailAddressNativeNamedParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("email2@email.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentNameByEmailId() {
        studentRepository.updateStudentNameByEmailId("Updated Test", "email@email.com");
    }

}