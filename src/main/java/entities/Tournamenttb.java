/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "tournamenttb")
@NamedQueries({
    @NamedQuery(name = "Tournamenttb.findAll", query = "SELECT t FROM Tournamenttb t"),
    @NamedQuery(name = "Tournamenttb.findByTournamentId", query = "SELECT t FROM Tournamenttb t WHERE t.tournamentId = :tournamentId"),
    @NamedQuery(name = "Tournamenttb.findByTournamentName", query = "SELECT t FROM Tournamenttb t WHERE t.tournamentName = :tournamentName"),
    @NamedQuery(name = "Tournamenttb.findByStartingDate", query = "SELECT t FROM Tournamenttb t WHERE t.startingDate = :startingDate")})
public class Tournamenttb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tournamentId")
    private Integer tournamentId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tournamentName")
    private String tournamentName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "startingDate")
    @Temporal(TemporalType.DATE)
    private Date startingDate;
    @JoinColumn(name = "organizerId", referencedColumnName = "organizerId")
    @ManyToOne(optional = false)
    private Organizermaster organizerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tournamentId")
    private List<Unsoldplayertb> unsoldplayertbList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tournamentId")
    private List<Tournamentplayerslist> tournamentplayerslistList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tournamentid")
    private List<Teammaster> teammasterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tornamentId")
    private List<Auctiondetailtb> auctiondetailtbList;

    public Tournamenttb() {
    }

    public Tournamenttb(Integer tournamentId) {
        this.tournamentId = tournamentId;
    }

    public Tournamenttb(Integer tournamentId, String tournamentName, Date startingDate) {
        this.tournamentId = tournamentId;
        this.tournamentName = tournamentName;
        this.startingDate = startingDate;
    }

    public Integer getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Integer tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Organizermaster getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(Organizermaster organizerId) {
        this.organizerId = organizerId;
    }
@JsonbTransient
    public List<Unsoldplayertb> getUnsoldplayertbList() {
        return unsoldplayertbList;
    }

    public void setUnsoldplayertbList(List<Unsoldplayertb> unsoldplayertbList) {
        this.unsoldplayertbList = unsoldplayertbList;
    }
@JsonbTransient
    public List<Tournamentplayerslist> getTournamentplayerslistList() {
        return tournamentplayerslistList;
    }

    public void setTournamentplayerslistList(List<Tournamentplayerslist> tournamentplayerslistList) {
        this.tournamentplayerslistList = tournamentplayerslistList;
    }
@JsonbTransient
    public List<Teammaster> getTeammasterList() {
        return teammasterList;
    }

    public void setTeammasterList(List<Teammaster> teammasterList) {
        this.teammasterList = teammasterList;
    }
@JsonbTransient
    public List<Auctiondetailtb> getAuctiondetailtbList() {
        return auctiondetailtbList;
    }

    public void setAuctiondetailtbList(List<Auctiondetailtb> auctiondetailtbList) {
        this.auctiondetailtbList = auctiondetailtbList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tournamentId != null ? tournamentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tournamenttb)) {
            return false;
        }
        Tournamenttb other = (Tournamenttb) object;
        if ((this.tournamentId == null && other.tournamentId != null) || (this.tournamentId != null && !this.tournamentId.equals(other.tournamentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Tournamenttb[ tournamentId=" + tournamentId + " ]";
    }
    
}
