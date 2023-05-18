/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package serverBeans;

import entities.Auctioneermaster;
import javax.ejb.Local;

/**
 *
 * @author Bhatt Jaimin
 */
@Local
public interface auctioneerEJBLocal {
      boolean register(Auctioneermaster auctioneer);
      boolean updateProfile(Auctioneermaster auctioneer);
      Auctioneermaster getAuctioneer(String auctioneerId);
      
}
