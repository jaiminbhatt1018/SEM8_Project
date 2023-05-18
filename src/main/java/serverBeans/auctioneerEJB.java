/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package serverBeans;

import entities.Auctioneermaster;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Bhatt Jaimin
 */
@Stateless
public class auctioneerEJB implements auctioneerEJBLocal {
  @PersistenceContext(unitName = "jpapu")
    EntityManager em;
    @Override
    public boolean register(Auctioneermaster auctioneer) {
     try{
        em.persist(auctioneer);
        return true;
    }catch(Exception ex){
        return false;
    }
    }

    @Override
    public boolean updateProfile(Auctioneermaster auctioneer) {
       try{
        em.merge(auctioneer);
        return true;
    }catch(Exception ex){
        return false;
    }
    }

    @Override
    public Auctioneermaster getAuctioneer(String auctioneerId) {
         try{
             Auctioneermaster auctioneer;
             auctioneer = em.find(Auctioneermaster.class, auctioneerId);
             return auctioneer;
    }catch(Exception ex){
        return null;
    }
    }

 
}
