/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package serverBeans;

import entities.Playermaster;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bhatt Jaimin
 */
@Local
public interface playerEjbLocal {
     boolean register(Playermaster player);
     List<Playermaster> getAllPlayers();
     public Playermaster getPlayerByID(String id);
     boolean update(Playermaster player);
     boolean delete(String id);
}
