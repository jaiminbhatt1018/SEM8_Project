
package serverBeans;

import entities.Playermaster;
import entities.Projectgroups;
import entities.Projectusers;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Bhatt Jaimin
 */
@Stateless
public class playerEJB implements playerEjbLocal {
  @PersistenceContext(unitName = "jpapu")
    EntityManager em;
    @Override
    public boolean register(Playermaster player) {
    try{
        String[] arrOfStr = player.getPlayerId().split(":",1);
        player.setPlayerId(arrOfStr[0]);
        
        em.persist(player);
        
        Projectusers u1= new Projectusers();
        u1.setPassword(arrOfStr[1]);
        u1.setUserId(player.getPlayerId());
        em.persist(u1);
       
        Projectgroups g1= new Projectgroups();
        g1.setGroupName("player");
        g1.setUserId(u1);
        em.persist(g1);
        return true;
    }catch(Exception ex){
        return false;
    }
    }

    @Override
    public List<Playermaster> getAllPlayers() {
       return em.createNamedQuery("Playermaster.findAll").getResultList();
    }

    @Override
    public boolean update(Playermaster player) {
        try{
            em.merge(player);
            return true;
        }catch(Exception ex){
            return false;
        }
        
    }

    @Override
    public boolean delete(String id) {
        try{
            Playermaster player = getPlayerByID(id);
            em.remove(player);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
    @Override
    public Playermaster getPlayerByID(String id){
      return  em.find(Playermaster.class, id);
    }

   
}
