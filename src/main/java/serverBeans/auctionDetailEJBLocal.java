/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package serverBeans;

import entities.Auctiondetailtb;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bhatt Jaimin
 */
@Local
public interface auctionDetailEJBLocal {
     boolean createAuction(Auctiondetailtb auction);
     boolean editAuction(Auctiondetailtb auction);
     List<Auctiondetailtb> Auctionlist();
     Auctiondetailtb getAuctionDetail(int id); 
}
