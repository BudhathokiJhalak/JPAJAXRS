/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jaxrsproject.dao;

import com.leapfrog.jaxrsproject.entity.Enquiry;
import java.util.List;

/**
 *
 * @author zak
 */
public interface EnquiryDAO {
    void insert(Enquiry enquiry);

    void update(Enquiry enquiry);

    boolean delete(int id);

    Enquiry getById(int id);

    List<Enquiry> getAll();
}
