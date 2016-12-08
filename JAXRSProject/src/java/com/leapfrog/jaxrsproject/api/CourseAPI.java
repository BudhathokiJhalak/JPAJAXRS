/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jaxrsproject.api;

import com.leapfrog.jaxrsproject.dao.CourseDAO;
import com.leapfrog.jaxrsproject.dao.impl.CourseDAOImpl;
import com.leapfrog.jaxrsproject.entity.Course;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author zak
 */
@Path(value = "/course")
public class CourseAPI {

    private CourseDAO courseDAO = new CourseDAOImpl();

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Course> index() {
        return courseDAO.getAll();
    }

    @Path(value = "/{id}")
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Course index(@PathParam("id") int id) {
        return courseDAO.getById(id);
    }

    @Path(value = "/save")
    @POST
    @Consumes(value = MediaType.APPLICATION_FORM_URLENCODED)
    public String save(@FormParam("name") String name, @FormParam("fees") int fees, @FormParam("duration") int duration, @FormParam("durationType") String durationType, @FormParam("status") boolean status) {
        Course course = new Course();
        course.setCourseName(name);
        course.setFees(fees);
        course.setDuration(duration);
        course.setDurationType(durationType);
        course.setStatus(status);
        courseDAO.insert(course);
        return "success";
    }
}
