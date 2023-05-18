/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package serverBeans;

import entities.Battingtypemaster;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Bhatt Jaimin
 */
@Stateless
public class battingTypeEJB implements battingTypeEJBLocal {
  @PersistenceContext(unitName = "jpapu")
    EntityManager em;
    @Override
    public List<Battingtypemaster> getAllBattingTypes() {
     
            List<Battingtypemaster> bat=em.createNamedQuery("Battingtypemaster.findAll").getResultList();
            return bat;
       
    }

 
}
