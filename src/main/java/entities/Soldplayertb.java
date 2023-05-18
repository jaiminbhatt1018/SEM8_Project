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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author praj4
 */
@Entity
@Table(name = "soldplayertb")
@NamedQueries({
    @NamedQuery(name = "Soldplayertb.findAll", query = "SELECT s FROM Soldplayertb s"),
    @NamedQuery(name = "Soldplayertb.findByPlayerId", query = "SELECT s FROM Soldplayertb s WHERE s.playerId = :playerId"),
    @NamedQuery(name = "Soldplayertb.findBySoldAmount", query = "SELECT s FROM Soldplayertb s WHERE s.soldAmount = :soldAmount"),
    @NamedQuery(name = "Soldplayertb.findByDate", query = "SELECT s FROM Soldplayertb s WHERE s.date = :date")})
public class Soldplayertb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "playerId")
    private String playerId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "soldAmount")
    private long soldAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "teamId", referencedColumnName = "teamId")
    @ManyToOne(optional = false)
    private Teammaster teamId;
    @JoinColumn(name = "playerId", referencedColumnName = "playerId", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Playermaster playermaster;

    public Soldplayertb() {
    }

    public Soldplayertb(String playerId) {
        this.playerId = playerId;
    }

    public Soldplayertb(String playerId, long soldAmount, Date date) {
        this.playerId = playerId;
        this.soldAmount = soldAmount;
        this.date = date;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public long getSoldAmount() {
        return soldAmount;
    }

    public void setSoldAmount(long soldAmount) {
        this.soldAmount = soldAmount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Teammaster getTeamId() {
        return teamId;
    }

    public void setTeamId(Teammaster teamId) {
        this.teamId = teamId;
    }

    public Playermaster getPlayermaster() {
        return playermaster;
    }

    public void setPlayermaster(Playermaster playermaster) {
        this.playermaster = playermaster;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (playerId != null ? playerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Soldplayertb)) {
            return false;
        }
        Soldplayertb other = (Soldplayertb) object;
        if ((this.playerId == null && other.playerId != null) || (this.playerId != null && !this.playerId.equals(other.playerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Soldplayertb[ playerId=" + playerId + " ]";
    }
    
}
