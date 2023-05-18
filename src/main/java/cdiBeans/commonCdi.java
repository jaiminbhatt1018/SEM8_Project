package cdiBeans;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */

import entities.Projectusers;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import javax.ws.rs.core.Response;
import restClient.commonClient;

/**
 *
 * @author Bhatt Jaimin
 */
@Named(value = "commoncdi")
@SessionScoped
public class commonCdi implements Serializable {

    public commonCdi() {
    }
       commonClient cc = new commonClient() ;
    private String username ;
    private String password;
    Response rs ;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public String checkLogin(){
         Projectusers user = new Projectusers();
        user.setPassword(this.password);
        user.setUserId(this.username);
        String s1;
        try {
       FacesContext facesContext = FacesContext.getCurrentInstance();
       HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false); 
       
         rs = cc.checkLogin(user);
         if (rs.getHeaderString("authorization")!=null){
             HttpSession ses= (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
             ses.setAttribute("authToken", rs.getHeaderString("authorization"));
         }
        if(rs.getStatus()==200){
            
            s1 = rs.readEntity(String.class);
           // s1= rs.readEntity();
            if(s1.equals("player")){
                
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/ps8/player/home.xhtml");
                    // return "player/home.xhtml";
              
            }else if(s1.equals("organizer")){
                      FacesContext.getCurrentInstance().getExternalContext().redirect("/ps8/organizer/home.xhtml");

             //   return "organizer/home.xhtml";
            }else if(s1.equals("auctioneer")){
                 FacesContext.getCurrentInstance().getExternalContext().redirect("/ps8/auctioneer/home.xhtml");

              //  return "auctioneer/home.xhtml";
            }else if(s1.equals("owner")){
                 FacesContext.getCurrentInstance().getExternalContext().redirect("/ps8/teamowner/home.xhtml");
              //  return "teamowner/home.xhtml";
            }else{
                return "";
               // return "login.xhtml";
            }
                
        }else
        {
            return "";
        //  return "login.xhtml";
        }
      } catch (IOException ex) {
                    Logger.getLogger(commonCdi.class.getName()).log(Level.SEVERE, null, ex);
         }
        return "";
      
    }
    
}
