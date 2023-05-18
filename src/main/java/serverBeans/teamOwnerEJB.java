/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package serverBeans;

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
public class teamOwnerEJB implements teamOwnerEJBLocal {
      @PersistenceContext(unitName = "jpapu")
  EntityManager em;
    @Override
    public boolean register(Teamownermaster owner) {
        try{
        em.persist(owner);
        return true;
    }catch(Exception ex){
        return false;
    }
    }

    @Override
    public List<Teamownermaster> getOwnerlist() {
     return em.createNamedQuery("Teamownermaster.findAll").getResultList();
    }

 
}
