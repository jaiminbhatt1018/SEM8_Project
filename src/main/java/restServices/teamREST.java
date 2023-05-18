/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package restServices;

import entities.Teammaster;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import serverBeans.teamEJBLocal;

/**
 * REST Web Service
 *
 * @author Bhatt Jaimin
 */
@Path("team")
@RequestScoped
public class teamREST {

    @EJB teamEJBLocal ejb;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of teamREST
     */
    public teamREST() {
    }

   
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Teammaster> getAllTeams(@PathParam("id") int id) {
       try{
           List<Teammaster> teamlist = ejb.getTeamsByTournament(id);
          return teamlist;
       }catch(Exception ex){
           return null;
       }
       
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addTeam(Teammaster team){
        try{
                ejb.registerTeam(team);
             return Response.ok().status(200).build();
        }catch(Exception ex){
             return Response.ok().status(404).build();
        }
       
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
