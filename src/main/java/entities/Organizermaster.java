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
@Table(name = "organizermaster")
@NamedQueries({
    @NamedQuery(name = "Organizermaster.findAll", query = "SELECT o FROM Organizermaster o"),
    @NamedQuery(name = "Organizermaster.findByOrganizerId", query = "SELECT o FROM Organizermaster o WHERE o.organizerId = :organizerId"),
    @NamedQuery(name = "Organizermaster.findByMobileNumber", query = "SELECT o FROM Organizermaster o WHERE o.mobileNumber = :mobileNumber"),
    @NamedQuery(name = "Organizermaster.findByName", query = "SELECT o FROM Organizermaster o WHERE o.name = :name"),
    @NamedQuery(name = "Organizermaster.findByCity", query = "SELECT o FROM Organizermaster o WHERE o.city = :city")})
public class Organizermaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "organizerId")
    private String organizerId;
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
    @Size(min = 1, max = 255)
    @Column(name = "city")
    private String city;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organizerId")
    private List<Tournamenttb> tournamenttbList;

    public Organizermaster() {
    }

    public Organizermaster(String organizerId) {
        this.organizerId = organizerId;
    }

    public Organizermaster(String organizerId, long mobileNumber, String name, String city) {
        this.organizerId = organizerId;
        this.mobileNumber = mobileNumber;
        this.name = name;
        this.city = city;
    }

    public String getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(String organizerId) {
        this.organizerId = organizerId;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
@JsonbTransient
    public List<Tournamenttb> getTournamenttbList() {
        return tournamenttbList;
    }

    public void setTournamenttbList(List<Tournamenttb> tournamenttbList) {
        this.tournamenttbList = tournamenttbList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (organizerId != null ? organizerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Organizermaster)) {
            return false;
        }
        Organizermaster other = (Organizermaster) object;
        if ((this.organizerId == null && other.organizerId != null) || (this.organizerId != null && !this.organizerId.equals(other.organizerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Organizermaster[ organizerId=" + organizerId + " ]";
    }
    
}
