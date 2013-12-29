/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.i3s.wimmics.radio.services;

import fr.unice.i3s.wimmics.radio.controllers.AbstractFacade;
import fr.unice.i3s.wimmics.radio.model.Category;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Amosse
 */
@Stateless
@Path("category")
public class CategoryFacade extends AbstractFacade<Category> {

    public CategoryFacade() {
        super(Category.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Category entity) {
        try {
            super.create(entity);


        } catch (Exception ex) {
            Logger.getLogger(CategoryFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(Category entity) {
        try {

            System.out.print("PUT utilisé");
            super.edit(entity);
            System.out.print("ID:" + String.valueOf(entity.getId()));


        } catch (Exception ex) {
            Logger.getLogger(CategoryFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        try {
            super.remove(super.find(id));
        } catch (Exception ex) {
            Logger.getLogger(CategoryFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Category find(@PathParam("id") Long id) {
        try {
            return super.find(id);

        } catch (Exception ex) {
            Logger.getLogger(CategoryFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Category> findAll() {
        try {
            return super.findAll();
        } catch (Exception ex) {
            Logger.getLogger(CategoryFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Category> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        try {
            return super.findRange(new int[]{from, to});
        } catch (Exception ex) {
            Logger.getLogger(CategoryFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        try {
            return String.valueOf(super.count());
        } catch (Exception ex) {
            Logger.getLogger(CategoryFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
