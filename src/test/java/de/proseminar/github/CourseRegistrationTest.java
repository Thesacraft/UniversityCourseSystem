package de.proseminar.github;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseRegistrationTest {
    private Course course;
    private Student student;

    @BeforeEach
    public void setUp() {
        course = new Course("Proseminar: Fortgeschrittene Programmierkonzepte", 12_38953, "28.03.2025");
        student = new Student("Max", 500000);
    }

    @Test
    void testSignUp() {
        assertTrue(course.signUpStudent(student), "Student should be able to signUp for the course.");
    }

    @Test
    void testExamRegistrationBeforeDeadline() {
        course.signUpStudent(student);
        assertTrue(course.registerForExam(student, "17.03.2025"),
                "Student should be able to register for the exam before the deadline.");
    }

    @Test
    void testExamRegistrationAfterDeadline() {
        course.signUpStudent(student);
        assertFalse(course.registerForExam(student, "07.04.2025"),
                "Student should not be able to register for the exam after the deadline.");
    }
}
