/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package serverBeans;

import entities.Tournamenttb;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Bhatt Jaimin
 */
@Stateless
public class tournamentEJB implements tournamentEJBLocal {
  @PersistenceContext(unitName = "jpapu")
    EntityManager em;
    @Override
    public boolean createTournamnet(Tournamenttb tournamnent) {
    try{
        em.persist(tournamnent);
        return true;
    }catch(Exception ex){
        return false;
    }
    }

    @Override
    public List<Tournamenttb> getAllTournament() {
    try{
        return (List<Tournamenttb>) em.createNamedQuery("Tournamenttb.findAll").getResultList();
    }catch(Exception ex){
     return null;   
    }
    }

    @Override
    public Tournamenttb getTournamentById(int id) {
     try{
        return em.find(Tournamenttb.class, id);
    }catch(Exception ex){
        return null;
    }
    }

      
}
