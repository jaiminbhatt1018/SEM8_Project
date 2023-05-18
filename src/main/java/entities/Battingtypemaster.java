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
@Table(name = "battingtypemaster")
@NamedQueries({
    @NamedQuery(name = "Battingtypemaster.findAll", query = "SELECT b FROM Battingtypemaster b"),
    @NamedQuery(name = "Battingtypemaster.findByBattingTypeId", query = "SELECT b FROM Battingtypemaster b WHERE b.battingTypeId = :battingTypeId"),
    @NamedQuery(name = "Battingtypemaster.findByType", query = "SELECT b FROM Battingtypemaster b WHERE b.type = :type")})
public class Battingtypemaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "battingTypeId")
    private Integer battingTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "type")
    private String type;

    public Battingtypemaster() {
    }

    public Battingtypemaster(Integer battingTypeId) {
        this.battingTypeId = battingTypeId;
    }

    public Battingtypemaster(Integer battingTypeId, String type) {
        this.battingTypeId = battingTypeId;
        this.type = type;
    }

    public Integer getBattingTypeId() {
        return battingTypeId;
    }

    public void setBattingTypeId(Integer battingTypeId) {
        this.battingTypeId = battingTypeId;
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
        hash += (battingTypeId != null ? battingTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Battingtypemaster)) {
            return false;
        }
        Battingtypemaster other = (Battingtypemaster) object;
        if ((this.battingTypeId == null && other.battingTypeId != null) || (this.battingTypeId != null && !this.battingTypeId.equals(other.battingTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Battingtypemaster[ battingTypeId=" + battingTypeId + " ]";
    }
    
}
