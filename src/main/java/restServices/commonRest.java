/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebServiceNoOp.java to edit this template
 */
package restServices;

import entities.Projectgroups;
import entities.Projectusers;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import serverBeans.commonBeansLocal;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import jwt.JwtAuthService;
import serverBeans.commonBeans;

/**
 *
 * @author praj4
 */

@RequestScoped
@Path("common")
public class commonRest {
@EJB commonBeansLocal cb;
JwtAuthService jwt = new JwtAuthService();
   public commonRest(){
       
   }
    @POST
   @Path("checkLogin")
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.TEXT_PLAIN)
   public Response checkLogin(Projectusers user){
      
            String str = cb.checkLogin(user);
            if (!str.equals("false")) {
                String token = jwt.generateJwtToken(user.getUserId(), str);

                return Response.ok().entity(str).header("authorization", token).build();
            } else {
                return Response.status(404).build();
            }
        
   }
   
   @GET
   @Path("auth")
   @Produces(MediaType.APPLICATION_JSON)
   public Response authenticateReq(@Context HttpHeaders header){
        String authtoken = header.getRequestHeader("Authorization").get(0).split(" ")[1];
            if (jwt.validateJwtToken(authtoken)) {
                String role = jwt.extractRole(authtoken);
                Projectusers user = new Projectusers();
                user.setUserId(jwt.extractUsername(authtoken));
                
                Projectgroups g1= new Projectgroups();
                g1.setGroupName(role);
                g1.setUserId(user);
                return Response.ok().entity(g1).build();
            } else {
                return Response.status(404).build();
            }
   }
   
    @GET
   @Produces(MediaType.TEXT_HTML)
   @Path("home")
   public String goHome(){
       return "Hey from home";
   }
   
   
    
}
