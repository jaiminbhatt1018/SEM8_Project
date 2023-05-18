/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package serverBeans;

import entities.Teammaster;
import entities.Teamownermaster;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Bhatt Jaimin
 */
@Stateless
public class teamEJB implements teamEJBLocal {
  @PersistenceContext(unitName = "jpapu")
    EntityManager em ;
    @Override
    public boolean registerTeam(Teammaster team) {
        try{
            em.persist(team);
            return true;
        }catch(Exception ex){
            return false;
        }
    }

   

    @Override
    public List<Teammaster> getTeamsByTournament(int tournamnetid) {
       try{
            return (List<Teammaster>) em.find(Teammaster.class, tournamnetid);
        }catch(Exception ex){
            return null;
        }
    }

    @Override
    public Teammaster getTeamByid(int tournamnetid, int teamid) {
       try{
            return  em.find(Teammaster.class, teamid);
        }catch(Exception ex){
            return null;
        }
    }

    @Override
    public Teamownermaster getOwnerDetais(String ownerid, int tournamentid) {
        try{
            return  (Teamownermaster) em.createNamedQuery("Teammaster.findTeamOwner").setParameter("ownerId", ownerid).getSingleResult();
        }catch(Exception ex){
            return null;
        }
    }


   
}
