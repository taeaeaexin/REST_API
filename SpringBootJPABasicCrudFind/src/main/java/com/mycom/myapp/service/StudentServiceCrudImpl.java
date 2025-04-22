package com.mycom.myapp.service;

import com.mycom.myapp.entity.Student;
import com.mycom.myapp.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceCrudImpl implements StudentServiceCrud {
    private final StudentRepository studentRepository;

    @Override
    public List<Student> listStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> detailStudent(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student insertStudent(Student student) {
        return (Student) studentRepository.save(student);
    }

    @Override
    public Optional<Student> updateStudent(Student student) {
        Optional<Student> existingStudent = studentRepository.findById(student.getId());
        if (existingStudent.isPresent()) {
            return Optional.of(studentRepository.save(student));
        }
        return Optional.empty();
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public long countStudent() {
        return studentRepository.count();
    }

    @Override
    public List<Student> listStudent(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Student> page = studentRepository.findAll(pageable);
        return page.toList();
    }
}