/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package serverBeans;

import entities.Projectgroups;
import entities.Projectusers;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author praj4
 */
@Stateless
public class commonBeans implements commonBeansLocal {
 @PersistenceContext(unitName = "jpapu")
     EntityManager em;
    @Override
    public String checkLogin(Projectusers user) {

        try{
            Projectusers u1 = em.find(Projectusers.class, user.getUserId());
            if(u1.getPassword().equals(user.getPassword())){
                Query q1 = em.createNamedQuery("Projectgroups.findByUserId").setParameter("userId", user);
                Projectgroups g1 = (Projectgroups) q1.getSingleResult();
                String gname= g1.getGroupName();
                return gname;
            }else
            {
                return "false";
            }
        }catch(Exception e){
            return "false";
        }
    
    }
  
    @Override
    public Projectgroups getUserGroup(String userid) {
      try{
          return em.find(Projectgroups.class, userid);
      }catch(Exception ex){
          return null;
      }
    }
}
