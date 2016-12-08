/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jaxrsproject.dao;

import com.leapfrog.jaxrsproject.entity.Course;
import java.util.List;

/**
 *
 * @author zak
 */
public interface CourseDAO {

    void insert(Course course);

    void update(Course course);

    boolean delete(int id);

    Course getById(int id);

    List<Course> getAll();
}
