/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package serverBeans;

import entities.Playermaster;
import entities.Unsoldplayertb;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bhatt Jaimin
 */
@Local
public interface unsoldPlayerEJBLocal {
    boolean addPlayerToUnsoldList(Unsoldplayertb player);
    List<Playermaster> ShowUnsoldPlayers(int tournamnetid);
    
}
