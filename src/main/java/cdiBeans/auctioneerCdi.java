/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdiBeans;

import entities.Projectusers;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.Response;
import restClient.commonClient;

/**
 *
 * @author Bhatt Jaimin
 */
@Named(value = "auctioneercdi")
@SessionScoped
public class auctioneerCdi implements Serializable {

    /**
     * Creates a new instance of auctioneerCdi
     */
    public auctioneerCdi() {
    }
  
}
