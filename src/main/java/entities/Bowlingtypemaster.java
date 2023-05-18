/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author praj4
 */
@Entity
@Table(name = "bowlingtypemaster")
@NamedQueries({
    @NamedQuery(name = "Bowlingtypemaster.findAll", query = "SELECT b FROM Bowlingtypemaster b"),
    @NamedQuery(name = "Bowlingtypemaster.findByBowlingTypeId", query = "SELECT b FROM Bowlingtypemaster b WHERE b.bowlingTypeId = :bowlingTypeId"),
    @NamedQuery(name = "Bowlingtypemaster.findByType", query = "SELECT b FROM Bowlingtypemaster b WHERE b.type = :type")})
public class Bowlingtypemaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bowlingTypeId")
    private Integer bowlingTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "type")
    private String type;

    public Bowlingtypemaster() {
    }

    public Bowlingtypemaster(Integer bowlingTypeId) {
        this.bowlingTypeId = bowlingTypeId;
    }

    public Bowlingtypemaster(Integer bowlingTypeId, String type) {
        this.bowlingTypeId = bowlingTypeId;
        this.type = type;
    }

    public Integer getBowlingTypeId() {
        return bowlingTypeId;
    }

    public void setBowlingTypeId(Integer bowlingTypeId) {
        this.bowlingTypeId = bowlingTypeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bowlingTypeId != null ? bowlingTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bowlingtypemaster)) {
            return false;
        }
        Bowlingtypemaster other = (Bowlingtypemaster) object;
        if ((this.bowlingTypeId == null && other.bowlingTypeId != null) || (this.bowlingTypeId != null && !this.bowlingTypeId.equals(other.bowlingTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Bowlingtypemaster[ bowlingTypeId=" + bowlingTypeId + " ]";
    }
    
}
