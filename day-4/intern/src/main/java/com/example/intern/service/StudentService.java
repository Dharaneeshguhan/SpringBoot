package com.example.intern.service;
import com.example.intern.models.Student;
import com.example.intern.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public String postMethod() {
        return "Post method buzzed successfully";
    }

    public String getWelcomeMessage() {
        return "Get method buzzed successfully";
    }

    public String putMethod() {
        return "Put method called successfully";
    }

    public String deleteMethod() {
        return "Delete method called successfully";
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public void addStudent(Student student) {
        studentRepo.save(student);
    }
}

