package com.oashsing.tutorialspringdatajpa.repository;

import com.oashsing.tutorialspringdatajpa.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
