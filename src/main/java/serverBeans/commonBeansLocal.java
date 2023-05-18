/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package serverBeans;

import entities.Projectgroups;
import entities.Projectusers;
import javax.ejb.Local;

/**
 *
 * @author praj4
 */
@Local
public interface commonBeansLocal {
        String checkLogin(Projectusers user);
        Projectgroups getUserGroup(String userid); 
}
