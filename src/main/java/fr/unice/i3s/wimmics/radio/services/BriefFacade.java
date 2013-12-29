/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.i3s.wimmics.radio.services;

import fr.unice.i3s.wimmics.radio.controllers.AbstractFacade;
import fr.unice.i3s.wimmics.radio.controllers.BriefController;
import fr.unice.i3s.wimmics.radio.model.Brief;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
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
@Path("brief")
public class BriefFacade extends BriefController {

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Brief entity) {
        
        try {

//            entity.setId(System.currentTimeMillis());
//            super.create(entity);
            System.out.print("ici"+ entity.toString());

        } catch (Exception ex) {
            Logger.getLogger(BriefFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(Brief entity) {
        try {

            System.out.print("PUT utilisé");
            super.edit(entity);
            System.out.print("ID:" + String.valueOf(entity.getId()));

        } catch (Exception ex) {
            Logger.getLogger(BriefFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        try {
            super.remove(super.find(id));
        } catch (Exception ex) {
            Logger.getLogger(BriefFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Brief find(@PathParam("id") Long id) {
        try {
            return super.find(id);

        } catch (Exception ex) {
            Logger.getLogger(BriefFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Brief> findAll() {
        try {
            return super.findAll();
        } catch (Exception ex) {
            Logger.getLogger(BriefFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @GET
    @Path("{from}/{to}/{disease}")
    @Produces({"application/xml", "application/json"})
    public List<Brief> findByDate(@PathParam("from") String from, @PathParam("to") String to, @PathParam("disease") Long disease) {
        try {
            System.out.println("test" + from + " " + to + " " + disease);
            return super.findByDateDisease(from,to,disease);
        } catch (Exception ex) {
            Logger.getLogger(BriefFacade.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(BriefFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
