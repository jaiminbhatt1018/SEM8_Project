/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author praj4
 */
@Entity
@Table(name = "teammaster")
@NamedQueries({
    @NamedQuery(name = "Teammaster.findAll", query = "SELECT t FROM Teammaster t"),
    @NamedQuery(name = "Teammaster.findByTeamId", query = "SELECT t FROM Teammaster t WHERE t.teamId = :teamId"),
    @NamedQuery(name = "Teammaster.findByTeamName", query = "SELECT t FROM Teammaster t WHERE t.teamName = :teamName"),
    @NamedQuery(name = "Teammaster.findByTotalPurse", query = "SELECT t FROM Teammaster t WHERE t.totalPurse = :totalPurse")})
public class Teammaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "teamId")
    private Integer teamId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "teamName")
    private String teamName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalPurse")
    private long totalPurse;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "teamLogo")
    private byte[] teamLogo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teamId")
    private List<Soldplayertb> soldplayertbList;
    @JoinColumn(name = "tournamentid", referencedColumnName = "tournamentId")
    @ManyToOne(optional = false)
    private Tournamenttb tournamentid;
    @JoinColumn(name = "ownerId", referencedColumnName = "ownerId")
    @ManyToOne(optional = false)
    private Teamownermaster ownerId;

    public Teammaster() {
    }

    public Teammaster(Integer teamId) {
        this.teamId = teamId;
    }

    public Teammaster(Integer teamId, String teamName, long totalPurse, byte[] teamLogo) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.totalPurse = totalPurse;
        this.teamLogo = teamLogo;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public long getTotalPurse() {
        return totalPurse;
    }

    public void setTotalPurse(long totalPurse) {
        this.totalPurse = totalPurse;
    }

    public byte[] getTeamLogo() {
        return teamLogo;
    }

    public void setTeamLogo(byte[] teamLogo) {
        this.teamLogo = teamLogo;
    }
@JsonbTransient
    public List<Soldplayertb> getSoldplayertbList() {
        return soldplayertbList;
    }

    public void setSoldplayertbList(List<Soldplayertb> soldplayertbList) {
        this.soldplayertbList = soldplayertbList;
    }

    public Tournamenttb getTournamentid() {
        return tournamentid;
    }

    public void setTournamentid(Tournamenttb tournamentid) {
        this.tournamentid = tournamentid;
    }

    public Teamownermaster getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Teamownermaster ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teamId != null ? teamId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teammaster)) {
            return false;
        }
        Teammaster other = (Teammaster) object;
        if ((this.teamId == null && other.teamId != null) || (this.teamId != null && !this.teamId.equals(other.teamId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Teammaster[ teamId=" + teamId + " ]";
    }
    
}
