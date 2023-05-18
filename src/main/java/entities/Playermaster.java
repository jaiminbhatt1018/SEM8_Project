/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author praj4
 */
@Entity
@Table(name = "playermaster")
@NamedQueries({
    @NamedQuery(name = "Playermaster.findAll", query = "SELECT p FROM Playermaster p"),
    @NamedQuery(name = "Playermaster.findByPlayerId", query = "SELECT p FROM Playermaster p WHERE p.playerId = :playerId"),
    @NamedQuery(name = "Playermaster.findByMobileNumber", query = "SELECT p FROM Playermaster p WHERE p.mobileNumber = :mobileNumber"),
    @NamedQuery(name = "Playermaster.findByName", query = "SELECT p FROM Playermaster p WHERE p.name = :name"),
    @NamedQuery(name = "Playermaster.findByBowlingType", query = "SELECT p FROM Playermaster p WHERE p.bowlingType = :bowlingType"),
    @NamedQuery(name = "Playermaster.findByBattingType", query = "SELECT p FROM Playermaster p WHERE p.battingType = :battingType"),
    @NamedQuery(name = "Playermaster.findByBattingPosition", query = "SELECT p FROM Playermaster p WHERE p.battingPosition = :battingPosition"),
    @NamedQuery(name = "Playermaster.findByAge", query = "SELECT p FROM Playermaster p WHERE p.age = :age"),
    @NamedQuery(name = "Playermaster.findByIsWicketkeeper", query = "SELECT p FROM Playermaster p WHERE p.isWicketkeeper = :isWicketkeeper")})
public class Playermaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "playerId")
    private String playerId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mobileNumber")
    private long mobileNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "photo")
    private byte[] photo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "bowlingType")
    private String bowlingType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "battingType")
    private String battingType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "battingPosition")
    private String battingPosition;
    @Basic(optional = false)
    @NotNull
    @Column(name = "age")
    private int age;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isWicketkeeper")
    private boolean isWicketkeeper;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "playermaster")
    private Unsoldplayertb unsoldplayertb;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "playermaster")
    private Tournamentplayerslist tournamentplayerslist;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "playermaster")
    private Soldplayertb soldplayertb;
    public Playermaster() {
    }



    public Playermaster(String playerId) {
        this.playerId = playerId;
    }

    public Playermaster(String playerId, long mobileNumber, String name, byte[] photo, String bowlingType, String battingType, String battingPosition, int age, boolean isWicketkeeper) {
        this.playerId = playerId;
        this.mobileNumber = mobileNumber;
        this.name = name;
        this.photo = photo;
        this.bowlingType = bowlingType;
        this.battingType = battingType;
        this.battingPosition = battingPosition;
        this.age = age;
        this.isWicketkeeper = isWicketkeeper;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getBowlingType() {
        return bowlingType;
    }

    public void setBowlingType(String bowlingType) {
        this.bowlingType = bowlingType;
    }

    public String getBattingType() {
        return battingType;
    }

    public void setBattingType(String battingType) {
        this.battingType = battingType;
    }

    public String getBattingPosition() {
        return battingPosition;
    }

    public void setBattingPosition(String battingPosition) {
        this.battingPosition = battingPosition;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getIsWicketkeeper() {
        return isWicketkeeper;
    }

    public void setIsWicketkeeper(boolean isWicketkeeper) {
        this.isWicketkeeper = isWicketkeeper;
    }

    public Unsoldplayertb getUnsoldplayertb() {
        return unsoldplayertb;
    }

    public void setUnsoldplayertb(Unsoldplayertb unsoldplayertb) {
        this.unsoldplayertb = unsoldplayertb;
    }

    public Tournamentplayerslist getTournamentplayerslist() {
        return tournamentplayerslist;
    }

    public void setTournamentplayerslist(Tournamentplayerslist tournamentplayerslist) {
        this.tournamentplayerslist = tournamentplayerslist;
    }

    public Soldplayertb getSoldplayertb() {
        return soldplayertb;
    }

    public void setSoldplayertb(Soldplayertb soldplayertb) {
        this.soldplayertb = soldplayertb;
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
        if (!(object instanceof Playermaster)) {
            return false;
        }
        Playermaster other = (Playermaster) object;
        if ((this.playerId == null && other.playerId != null) || (this.playerId != null && !this.playerId.equals(other.playerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Playermaster[ playerId=" + playerId + " ]";
    }
    
}
