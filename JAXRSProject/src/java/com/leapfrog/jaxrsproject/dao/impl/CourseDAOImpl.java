/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jaxrsproject.dao.impl;

import com.leapfrog.jaxrsproject.dao.CourseDAO;
import com.leapfrog.jaxrsproject.entity.Course;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author zak
 */
public class CourseDAOImpl implements CourseDAO {

    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction trans;

    public CourseDAOImpl() {
        emf = Persistence.createEntityManagerFactory("JAXRSPU");
        em = emf.createEntityManager();
    }

    @Override
    public void insert(Course course) {
        trans = em.getTransaction();
        if (!trans.isActive()) {
            trans.begin();
        }
        em.persist(course);
        trans.commit();
    }

    @Override
    public void update(Course course) {
        trans = em.getTransaction();
        if (!trans.isActive()) {
            trans.begin();
        }
        em.merge(course);
        trans.commit();
    }

    @Override
    public boolean delete(int id) {
        trans = em.getTransaction();
        if (!trans.isActive()) {
            trans.begin();
        }
        Course course = getById(id);
        boolean success = false;
        if (course != null) {
            em.remove(course);
            success = true;
        }
        trans.commit();
        return success;
    }

    @Override
    public Course getById(int id) {
        return em.find(Course.class, id);
    }

    @Override
    public List<Course> getAll() {
        return em.createQuery("SELECT c FROM Course c").getResultList();
    }

}
