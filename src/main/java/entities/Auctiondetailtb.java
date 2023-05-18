/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author praj4
 */
@Entity
@Table(name = "auctiondetailtb")
@NamedQueries({
    @NamedQuery(name = "Auctiondetailtb.findAll", query = "SELECT a FROM Auctiondetailtb a"),
    @NamedQuery(name = "Auctiondetailtb.findByAuctionId", query = "SELECT a FROM Auctiondetailtb a WHERE a.auctionId = :auctionId"),
    @NamedQuery(name = "Auctiondetailtb.findByDate", query = "SELECT a FROM Auctiondetailtb a WHERE a.date = :date"),
    @NamedQuery(name = "Auctiondetailtb.findByEachPlayerBasePrice", query = "SELECT a FROM Auctiondetailtb a WHERE a.eachPlayerBasePrice = :eachPlayerBasePrice"),
    @NamedQuery(name = "Auctiondetailtb.findByBidIncrementAmount", query = "SELECT a FROM Auctiondetailtb a WHERE a.bidIncrementAmount = :bidIncrementAmount"),
    @NamedQuery(name = "Auctiondetailtb.findByTotalPurse", query = "SELECT a FROM Auctiondetailtb a WHERE a.totalPurse = :totalPurse"),
    @NamedQuery(name = "Auctiondetailtb.findByMinPlayer", query = "SELECT a FROM Auctiondetailtb a WHERE a.minPlayer = :minPlayer")})
public class Auctiondetailtb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "auctionId")
    private Integer auctionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eachPlayerBasePrice")
    private long eachPlayerBasePrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bidIncrementAmount")
    private int bidIncrementAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalPurse")
    private long totalPurse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "minPlayer")
    private int minPlayer;
    @JoinColumn(name = "auctioneerId", referencedColumnName = "auctioneerId")
    @ManyToOne(optional = false)
    private Auctioneermaster auctioneerId;
    @JoinColumn(name = "tornamentId", referencedColumnName = "tournamentId")
    @ManyToOne(optional = false)
    private Tournamenttb tornamentId;

    public Auctiondetailtb() {
    }

    public Auctiondetailtb(Integer auctionId) {
        this.auctionId = auctionId;
    }

    public Auctiondetailtb(Integer auctionId, Date date, long eachPlayerBasePrice, int bidIncrementAmount, long totalPurse, int minPlayer) {
        this.auctionId = auctionId;
        this.date = date;
        this.eachPlayerBasePrice = eachPlayerBasePrice;
        this.bidIncrementAmount = bidIncrementAmount;
        this.totalPurse = totalPurse;
        this.minPlayer = minPlayer;
    }

    public Integer getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Integer auctionId) {
        this.auctionId = auctionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getEachPlayerBasePrice() {
        return eachPlayerBasePrice;
    }

    public void setEachPlayerBasePrice(long eachPlayerBasePrice) {
        this.eachPlayerBasePrice = eachPlayerBasePrice;
    }

    public int getBidIncrementAmount() {
        return bidIncrementAmount;
    }

    public void setBidIncrementAmount(int bidIncrementAmount) {
        this.bidIncrementAmount = bidIncrementAmount;
    }

    public long getTotalPurse() {
        return totalPurse;
    }

    public void setTotalPurse(long totalPurse) {
        this.totalPurse = totalPurse;
    }

    public int getMinPlayer() {
        return minPlayer;
    }

    public void setMinPlayer(int minPlayer) {
        this.minPlayer = minPlayer;
    }

    
    public Auctioneermaster getAuctioneerId() {
        return auctioneerId;
    }

    public void setAuctioneerId(Auctioneermaster auctioneerId) {
        this.auctioneerId = auctioneerId;
    }

    public Tournamenttb getTornamentId() {
        return tornamentId;
    }

    public void setTornamentId(Tournamenttb tornamentId) {
        this.tornamentId = tornamentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (auctionId != null ? auctionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auctiondetailtb)) {
            return false;
        }
        Auctiondetailtb other = (Auctiondetailtb) object;
        if ((this.auctionId == null && other.auctionId != null) || (this.auctionId != null && !this.auctionId.equals(other.auctionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Auctiondetailtb[ auctionId=" + auctionId + " ]";
    }
    
}
