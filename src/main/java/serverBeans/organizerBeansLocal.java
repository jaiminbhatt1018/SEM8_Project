/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package serverBeans;

import entities.Organizermaster;
import javax.ejb.Local;

/**
 *
 * @author praj4
 */
@Local
public interface organizerBeansLocal {
    
    boolean register(Organizermaster orgenizer);
    Organizermaster getOrganizer(String id);
}
