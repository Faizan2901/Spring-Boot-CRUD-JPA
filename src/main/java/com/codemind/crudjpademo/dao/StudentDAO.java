package com.codemind.crudjpademo.dao;

import com.codemind.crudjpademo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findByFirstName(String firstName);

    List<Student> findAllStudent();

    void updateStudent(Student student);

    void deleteStudent(Integer id);

    int deleteAll();
}
