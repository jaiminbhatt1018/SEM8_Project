/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package serverBeans;

import entities.Tournamenttb;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bhatt Jaimin
 */
@Local
public interface tournamentEJBLocal {
    boolean createTournamnet( Tournamenttb tournamnent);
    List<Tournamenttb> getAllTournament();
    Tournamenttb getTournamentById(int id);
}
