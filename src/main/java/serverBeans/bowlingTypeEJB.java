/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package serverBeans;

import entities.Bowlingtypemaster;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Bhatt Jaimin
 */
@Stateless
public class bowlingTypeEJB implements bowlingTypeEJBLocal {
  @PersistenceContext(unitName = "jpapu")
    EntityManager em;
    @Override
    public List<Bowlingtypemaster> getAllBowlingTypes() {
  
        return em.createNamedQuery("Bowlingtypemaster.findAll").getResultList();
 
    }

 
}
