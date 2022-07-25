package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.StudentNotFoundException;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        student.setId(null);
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        return studentRepository.findById(id)
                .orElseThrow(StudentNotFoundException::new);
    }
    public Student editStudent(Student student) {
        Student oldStudent = findStudent(student.getId());
        oldStudent.setName(student.getName());
        oldStudent.setAge(student.getAge());
        return studentRepository.save(oldStudent);
    }

    public Student deleteStudent(long id) {
        Student student = findStudent(id);
        studentRepository.deleteById(id);
        return student;
    }
}
