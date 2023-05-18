/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package serverBeans;

import entities.Playermaster;
import entities.Unsoldplayertb;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Bhatt Jaimin
 */
@Stateless
public class unsoldPlayerEJB implements unsoldPlayerEJBLocal {
  @PersistenceContext(unitName = "jpapu")
    EntityManager em;
    @Override
    public boolean addPlayerToUnsoldList(Unsoldplayertb player) {
        try{
            em.persist(player);
            return true;
        }catch(Exception ex){
            return false;
        }
    }

    @Override
    public List<Playermaster> ShowUnsoldPlayers(int tournamnetid) {
        try{
            return em.createNamedQuery("Unsoldplayertb.findByTournamentId").setParameter("tournamentId", tournamnetid).getResultList();
        }catch(Exception ex){
            return null;
        }
    }

}
