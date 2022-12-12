package com.oashsing.tutorialspringdatajpa.repository;

import com.oashsing.tutorialspringdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#appendix.query.method.subject
    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameContaining(String firstName);

    public List<Student> findByGuardianName(String firstName);

    // There's a time when creating method name is not enough, you have to create JPQL query
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
    // Search : "JPQL"
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    // JPQL
    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);

    // There are few queries that even JPQL can't solve, here we use "NativeQuery"
    @Query(
            value = "SELECT * FROM tbl_student s WHERE s.email_address= ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);

    // Native Named Param
    @Query(
            value = "SELECT * FROM tbl_student s WHERE s.email_address= :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

    // To make this method modify value in database, we use @Modify
    // Since this is modifying the data, so transaction is going on, so we need to use @Transactional annotation
    // Transaction should be used at Service layer.
    @Transactional
    @Modifying
    @Query(
            value = "update tbl_student set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName, String emailId);

}
