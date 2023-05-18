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
import javax.persistence.Id;
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
@Table(name = "auctioneermaster")
@NamedQueries({
    @NamedQuery(name = "Auctioneermaster.findAll", query = "SELECT a FROM Auctioneermaster a"),
    @NamedQuery(name = "Auctioneermaster.findByAuctioneerId", query = "SELECT a FROM Auctioneermaster a WHERE a.auctioneerId = :auctioneerId"),
    @NamedQuery(name = "Auctioneermaster.findByMobileNumber", query = "SELECT a FROM Auctioneermaster a WHERE a.mobileNumber = :mobileNumber"),
    @NamedQuery(name = "Auctioneermaster.findByName", query = "SELECT a FROM Auctioneermaster a WHERE a.name = :name")})
public class Auctioneermaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "auctioneerId")
    private String auctioneerId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mobileNumber")
    private long mobileNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "auctioneerId")
    private List<Auctiondetailtb> auctiondetailtbList;

    public Auctioneermaster() {
    }

    public Auctioneermaster(String auctioneerId) {
        this.auctioneerId = auctioneerId;
    }

    public Auctioneermaster(String auctioneerId, long mobileNumber, String name) {
        this.auctioneerId = auctioneerId;
        this.mobileNumber = mobileNumber;
        this.name = name;
    }

    public String getAuctioneerId() {
        return auctioneerId;
    }

    public void setAuctioneerId(String auctioneerId) {
        this.auctioneerId = auctioneerId;
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
        hash += (auctioneerId != null ? auctioneerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auctioneermaster)) {
            return false;
        }
        Auctioneermaster other = (Auctioneermaster) object;
        if ((this.auctioneerId == null && other.auctioneerId != null) || (this.auctioneerId != null && !this.auctioneerId.equals(other.auctioneerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Auctioneermaster[ auctioneerId=" + auctioneerId + " ]";
    }
    
}
