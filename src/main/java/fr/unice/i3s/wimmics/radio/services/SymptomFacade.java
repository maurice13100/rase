/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.i3s.wimmics.radio.services;

import fr.unice.i3s.wimmics.radio.controllers.SymptomController;
import fr.unice.i3s.wimmics.radio.model.Symptom;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author maurice
 */
@Path("/symptom")
public class SymptomFacade extends SymptomController {

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Symptom entity) {
        try {
            entity.setId(System.currentTimeMillis());
            super.create(entity);
        } catch (Exception ex) {
            Logger.getLogger(SymptomController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(Symptom entity) {
        try {
            super.edit(entity);
        } catch (Exception ex) {
            Logger.getLogger(SymptomController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        try {
            super.remove(super.find(id));
        } catch (Exception ex) {
            Logger.getLogger(SymptomController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json", "application/rdf+xml"})
    public Symptom find(@PathParam("id") Long id) {
        try {
            return super.find(id);
        } catch (Exception ex) {
            Logger.getLogger(SymptomController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @GET
    // @Path("{id}")
    @Produces({"application/rdf+xml"})
    @Path("rdf/{id}")
    public Symptom findMe(@PathParam("id") Long id) {
        try {
            return super.find(id);
        } catch (Exception ex) {
            Logger.getLogger(SymptomController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
   

    @GET
    @Override
    @Produces({"application/xml", "application/json", "application/rdf+xml"})
    public List<Symptom> findAll() {
        try {
            return super.findAll();
        } catch (Exception ex) {
            Logger.getLogger(SymptomController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json", "application/rdf+xml"})
    public List<Symptom> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        try {
            return super.findRange(new int[]{from, to});
        } catch (Exception ex) {
            Logger.getLogger(SymptomController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SymptomController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @GET
    @Path("byDisease/{id}")
    @Produces({"application/xml", "application/json", "application/rdf+xml"})
    public Collection<Symptom> getbyDisease(@PathParam("id") String idDisease) {
        Collection<Symptom> symptoms = super.findByDisease(idDisease);
        return symptoms;
    }

}
