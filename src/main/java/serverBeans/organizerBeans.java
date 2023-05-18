/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package serverBeans;

import entities.Organizermaster;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author praj4
 */
@Stateless

           
public class organizerBeans implements organizerBeansLocal {
    
    @PersistenceContext(unitName = "jpapu")
    EntityManager em;

    public organizerBeans() {
    }
   
    @Override
    public boolean register(Organizermaster orgenizer) {
       try {
           em.persist(orgenizer);
           return true;
       }catch(Exception ex){
           return false;
       }
    }

    @Override
    public Organizermaster getOrganizer(String id) {
        try{
            return em.find(Organizermaster.class, id);
        }catch(Exception ex){
            return null;
        }
    }
}
