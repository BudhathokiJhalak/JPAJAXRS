/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jaxrsproject.api;

import com.leapfrog.jaxrsproject.dao.EnquiryDAO;
import com.leapfrog.jaxrsproject.dao.impl.EnquiryDAOImpl;
import com.leapfrog.jaxrsproject.entity.Enquiry;
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
@Path(value = "/enquiry")
public class EnquiryAPI {

    private EnquiryDAO enquiryDAO = new EnquiryDAOImpl();

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Enquiry> index() {
        return enquiryDAO.getAll();
    }

    @Path(value = "/{id}")
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Enquiry index(@PathParam("id") int id) {
        return enquiryDAO.getById(id);
    }

    @Path(value = "/save")
    @POST
    
    public String save(Enquiry enquiry) {
        enquiry.setIsRead(false);
        enquiry.setStatus(true);
        enquiryDAO.insert(enquiry);
        return "success";
    }
}
