/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package serverBeans;

import entities.Teammaster;
import entities.Teamownermaster;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bhatt Jaimin
 */
@Local
public interface teamEJBLocal {
       boolean registerTeam(Teammaster team);
       List<Teammaster> getTeamsByTournament(int tournamnetid);
       Teammaster getTeamByid(int tournamnetid,int teamid);
       Teamownermaster getOwnerDetais(String ownerid,int tournamentid);
       
       
       
}
