/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jaxrsproject.dao.impl;

import com.leapfrog.jaxrsproject.dao.EnquiryDAO;
import com.leapfrog.jaxrsproject.entity.Enquiry;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author zak
 */
public class EnquiryDAOImpl implements EnquiryDAO{
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction trans;

    public EnquiryDAOImpl() {
        emf = Persistence.createEntityManagerFactory("JAXRSPU");
        em = emf.createEntityManager();
    }

    @Override
    public void insert(Enquiry enquiry) {
        trans = em.getTransaction();
        if (!trans.isActive()) {
            trans.begin();
        }
        em.persist(enquiry);
        trans.commit();
    }

    @Override
    public void update(Enquiry enquiry) {
        trans = em.getTransaction();
        if (!trans.isActive()) {
            trans.begin();
        }
        em.merge(enquiry);
        trans.commit();
    }

    @Override
    public boolean delete(int id) {
        trans = em.getTransaction();
        if (!trans.isActive()) {
            trans.begin();
        }
        Enquiry enquiry = getById(id);
        boolean success = false;
        if (enquiry != null) {
            em.remove(enquiry);
            success = true;
        }
        trans.commit();
        return success;
    }

    @Override
    public Enquiry getById(int id) {
        return em.find(Enquiry.class, id);
    }

    @Override
    public List<Enquiry> getAll() {
        return em.createQuery("SELECT c FROM Enquiry c").getResultList();
    }
}
