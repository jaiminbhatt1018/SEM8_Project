/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package restServices;

import entities.Organizermaster;
import entities.Teamownermaster;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import serverBeans.organizerBeansLocal;
import serverBeans.teamOwnerEJB;
import serverBeans.teamOwnerEJBLocal;

/**
 * REST Web Service
 *
 * @author Bhatt Jaimin
 */
@Path("organizer")
@RequestScoped
public class OrganizerREST {
    @EJB organizerBeansLocal ejb;
    @EJB teamOwnerEJBLocal ownerEjb ;
    public OrganizerREST() {
    }

   
    @POST
    @Path("/addOrganizer")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response OrgenizerRegistration(Organizermaster organizer) {
        try{
            ejb.register(organizer);
            return Response.status(200).build();
        }catch(Exception ex){
           return Response.status(404).build();
        }
        
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrgenizer(@PathParam("id") String organizerID ) {
        try{
           Organizermaster org = ejb.getOrganizer(organizerID);
           return Response.status(200).entity(org).build();
           
        }catch(Exception ex){
            return Response.status(404).build();
        }
    }
    
    @GET
    @Path("/getOwners")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOwners(){
         try{
             List<Teamownermaster> owners  = ownerEjb.getOwnerlist();
           return Response.status(200).entity(owners).build();
           
        }catch(Exception ex){
            return Response.status(404).build();
        }
    }
}
