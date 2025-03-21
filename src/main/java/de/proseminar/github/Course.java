package de.proseminar.github;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Course {
    private final String name;
    private final String examDeadline;
    private final List<Student> students;
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

    public Course(String name, String examDeadline) {
        this.name = name;
        this.examDeadline = examDeadline;
        students = new ArrayList<>();
    }

    public boolean signUpStudent(Student student) {
        return students.add(student);
    }

    public boolean registerForExam(Student student, String currentDate) {
        try {
            Date current = DATE_FORMAT.parse(currentDate);
            Date deadline = DATE_FORMAT.parse(examDeadline);
            return students.contains(student) && current.compareTo(deadline) <= 0;
        } catch (ParseException _) {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public String getExamDeadline() {
        return examDeadline;
    }
}
