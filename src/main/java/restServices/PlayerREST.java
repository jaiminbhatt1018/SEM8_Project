/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package restServices;

import entities.Battingtypemaster;
import entities.Bowlingtypemaster;
import entities.Playermaster;
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
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import serverBeans.battingTypeEJBLocal;
import serverBeans.bowlingTypeEJBLocal;
import serverBeans.playerEjbLocal;

/**
 * REST Web Service
 *
 * @author Bhatt Jaimin
 */
@Path("player")
@RequestScoped
public class PlayerREST {

    @Context
    private UriInfo context;
    @EJB playerEjbLocal ejb;
    @EJB battingTypeEJBLocal batejb;
    @EJB bowlingTypeEJBLocal ballejb;
    
    /**
     * Creates a new instance of PlayerREST
     */
    public PlayerREST() {
    }

    @GET
    @Path("battingTypes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Battingtypemaster> getBattingTypes() {
       return batejb.getAllBattingTypes();
    }
    @GET
    @Path("bowlingTypes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bowlingtypemaster> getBowlingTypes() {
       return ballejb.getAllBowlingTypes();
    }
    
    @GET
    @Path("players")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Playermaster> getPlayers() {
       return ejb.getAllPlayers();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlayer(@PathParam("id") String playerid) {
       Playermaster p = ejb.getPlayerByID(playerid);
       return Response.status(200).entity(p).build();
    }

 
    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPlayer(Playermaster player) {
        ejb.register(player);
    }
    
    @PUT
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updtaePlayer(Playermaster player) {
        ejb.update(player);
    }
    
    @DELETE
    @Path("delete/{id}")
    public Response deletePlayer(@PathParam("id") String playerid) {
        ejb.delete(playerid);
         return Response.status(200).build();
    }
}
