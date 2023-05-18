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
@Table(name = "teamownermaster")
@NamedQueries({
    @NamedQuery(name = "Teamownermaster.findAll", query = "SELECT t FROM Teamownermaster t"),
    @NamedQuery(name = "Teamownermaster.findByOwnerId", query = "SELECT t FROM Teamownermaster t WHERE t.ownerId = :ownerId"),
    @NamedQuery(name = "Teamownermaster.findByMobileNumber", query = "SELECT t FROM Teamownermaster t WHERE t.mobileNumber = :mobileNumber"),
    @NamedQuery(name = "Teamownermaster.findByName", query = "SELECT t FROM Teamownermaster t WHERE t.name = :name")})
public class Teamownermaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ownerId")
    private String ownerId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mobileNumber")
    private long mobileNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerId")
    private List<Teammaster> teammasterList;

    public Teamownermaster() {
    }

    public Teamownermaster(String ownerId) {
        this.ownerId = ownerId;
    }

    public Teamownermaster(String ownerId, long mobileNumber, String name) {
        this.ownerId = ownerId;
        this.mobileNumber = mobileNumber;
        this.name = name;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
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
    public List<Teammaster> getTeammasterList() {
        return teammasterList;
    }

    public void setTeammasterList(List<Teammaster> teammasterList) {
        this.teammasterList = teammasterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ownerId != null ? ownerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teamownermaster)) {
            return false;
        }
        Teamownermaster other = (Teamownermaster) object;
        if ((this.ownerId == null && other.ownerId != null) || (this.ownerId != null && !this.ownerId.equals(other.ownerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Teamownermaster[ ownerId=" + ownerId + " ]";
    }
    
}
