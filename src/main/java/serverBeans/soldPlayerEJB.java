/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package serverBeans;

import entities.Playermaster;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Bhatt Jaimin
 */
@Stateless
public class soldPlayerEJB implements soldPlayerEJBLocal {
  @PersistenceContext(unitName = "jpapu")
    EntityManager em;
    @Override
    public List<Playermaster> getAllSoldPlayers() {
        List<Playermaster> soldPlayerList;
        try{
            soldPlayerList = em.createNamedQuery("playermaster.findSoldPlayers").getResultList();
            return soldPlayerList;
        }catch(Exception ex){
        return null;
        }
    }

    @Override
    public List<Playermaster> getSoldPlayersByTeam(int teamid) {
        List<Playermaster> soldPlayerList;
        try{
            soldPlayerList = em.createNamedQuery("playermaster.findSoldPlayersByTeam").setParameter("teamId", teamid).getResultList();
            return soldPlayerList;
        }catch(Exception ex){
        return null;
        }
    }
    
    

 
}
