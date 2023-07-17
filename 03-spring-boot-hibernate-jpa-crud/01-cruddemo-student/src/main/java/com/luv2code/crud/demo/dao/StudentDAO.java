package com.luv2code.crud.demo.dao;

import com.luv2code.crud.demo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByLastName(String toSearch);

    void update(Student student);

    void delete(int id);

}
