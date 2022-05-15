package com.example.demo.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldCheckWhenStudentEmailExists() {
        //Given
        String email = "auz@gmnail.com";
        Student student = new Student(
                "Auz",
                email,
                Gender.FEMALE
        );
        underTest.save(student);

        //when
        boolean exists = underTest.selectExistsEmail(email);

        //then
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$" + student + "$$$$$$$$$$$$$$$$$$$$$$$$$$");
        assertThat(exists).isTrue();
    }

    @Test
    void itShouldCheckWhenStudentEmailDoesNotExists() {
        //Given
        String email = "auz@gmnail.com";

        //when
        boolean exists = underTest.selectExistsEmail(email);

        //then
        assertThat(exists).isFalse();
    }

    @Test
    @Disabled
    void checkIfStudentEmailExist() {
        //given


    }
}