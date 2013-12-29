/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.i3s.wimmics.radio.services;

import fr.unice.i3s.wimmics.radio.controllers.AbstractFacade;
import fr.unice.i3s.wimmics.radio.model.DiseaseSymptom;
import fr.unice.i3s.wimmics.radio.controllers.DiseaseSymptomController;
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
@Path("/diseasesymptom")
public class DiseaseSymptomFacade extends DiseaseSymptomController {



    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(DiseaseSymptom entity) {
        try {

            //entity.getDisease().setId(System.currentTimeMillis());
           // entity.getSymptom().setId(System.currentTimeMillis() + 1);
            super.create(entity);

        } catch (Exception ex) {
            Logger.getLogger(DiseaseSymptomFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(DiseaseSymptom entity) {
        try {

            System.out.print("PUT utilisé");
            super.edit(entity);
            System.out.print("ID:" + String.valueOf(entity.getId()));

        } catch (Exception ex) {
            Logger.getLogger(DiseaseSymptomFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        try {
            super.remove(super.find(id));
        } catch (Exception ex) {
            Logger.getLogger(DiseaseSymptomFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public DiseaseSymptom find(@PathParam("id") Long id) {
        try {
            return super.find(id);

        } catch (Exception ex) {
            Logger.getLogger(DiseaseSymptomFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<DiseaseSymptom> findAll() {
        try {
            return super.findAll();
        } catch (Exception ex) {
            Logger.getLogger(DiseaseSymptomFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<DiseaseSymptom> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        try {
            return super.findRange(new int[]{from, to});
        } catch (Exception ex) {
            Logger.getLogger(DiseaseSymptomFacade.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DiseaseSymptomFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @GET
    @Path("byDisease/{id}")
    @Produces({"application/xml", "application/json", "application/rdf+xml"})
    public Collection<DiseaseSymptom> getbyDisease(@PathParam("id") Long idDisease) {
        Collection<DiseaseSymptom> symptoms = super.findByDisease(idDisease);
        System.out.print("countTEST"+symptoms.size());
        return symptoms;
    }
}
