/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package restServices;

import entities.Tournamenttb;
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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import serverBeans.tournamentEJB;
import serverBeans.tournamentEJBLocal;

/**
 * REST Web Service
 *
 * @author Bhatt Jaimin
 */
@Path("tournament")
@RequestScoped
public class TournamentREST {

    @Context
    private UriInfo context;
  @EJB tournamentEJBLocal ejb;
    /**
     * Creates a new instance of TournamentREST
     */
    public TournamentREST() {
    }

  
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tournamenttb> getAllTournaments() {
       return ejb.getAllTournament();
    }
    
    @POST
    @Path("/addTournament")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addTournament(Tournamenttb tournament) {
        try{
            ejb.createTournamnet(tournament);
            return Response.status(200).build();
        }catch(Exception ex){
           return Response.status(404).build();
        }
        
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
