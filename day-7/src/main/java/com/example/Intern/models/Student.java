package com.example.Intern.models;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
public class Student {
    private int studentId;
    private String name;
    private String course;
    private int courseId;

    public Student(int i, String pavithra, String ai, int i1) {
    }
}