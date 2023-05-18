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
@Table(name = "unsoldplayertb")
@NamedQueries({
    @NamedQuery(name = "Unsoldplayertb.findAll", query = "SELECT u FROM Unsoldplayertb u"),
    @NamedQuery(name = "Unsoldplayertb.findByPlayerId", query = "SELECT u FROM Unsoldplayertb u WHERE u.playerId = :playerId"),
    @NamedQuery(name = "Unsoldplayertb.findByDate", query = "SELECT u FROM Unsoldplayertb u WHERE u.date = :date")})
public class Unsoldplayertb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "playerId")
    private String playerId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "playerId", referencedColumnName = "playerId", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Playermaster playermaster;
    @JoinColumn(name = "tournamentId", referencedColumnName = "tournamentId")
    @ManyToOne(optional = false)
    private Tournamenttb tournamentId;

    public Unsoldplayertb() {
    }

    public Unsoldplayertb(String playerId) {
        this.playerId = playerId;
    }

    public Unsoldplayertb(String playerId, Date date) {
        this.playerId = playerId;
        this.date = date;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Playermaster getPlayermaster() {
        return playermaster;
    }

    public void setPlayermaster(Playermaster playermaster) {
        this.playermaster = playermaster;
    }

    public Tournamenttb getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Tournamenttb tournamentId) {
        this.tournamentId = tournamentId;
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
        if (!(object instanceof Unsoldplayertb)) {
            return false;
        }
        Unsoldplayertb other = (Unsoldplayertb) object;
        if ((this.playerId == null && other.playerId != null) || (this.playerId != null && !this.playerId.equals(other.playerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Unsoldplayertb[ playerId=" + playerId + " ]";
    }
    
}
