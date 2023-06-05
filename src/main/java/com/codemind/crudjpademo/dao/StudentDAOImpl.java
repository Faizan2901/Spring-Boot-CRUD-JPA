package com.codemind.crudjpademo.dao;

import com.codemind.crudjpademo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findByFirstName(String firstName) {
        TypedQuery<Student> myQuery=entityManager.createQuery("FROM Student WHERE firstName=:myData",Student.class);
        myQuery.setParameter("myData",firstName);
        Student student=myQuery.getSingleResult();
        return student;
    }

    @Override
    public List<Student> findAllStudent() {
        TypedQuery<Student> myQuery=entityManager.createQuery("FROM Student ORDER BY firstName",Student.class);
        List<Student> students=myQuery.getResultList();
        return students;
    }


    @Override
    @Transactional
    public void updateStudent(Student student) {
            entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudent(Integer id) {
        Student student=entityManager.find(Student.class,id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        return entityManager.createQuery("DELETE FROM Student",Student.class).executeUpdate();
    }


}
