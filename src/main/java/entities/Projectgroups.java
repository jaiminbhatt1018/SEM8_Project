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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "projectgroups")
@NamedQueries({
    @NamedQuery(name = "Projectgroups.findAll", query = "SELECT p FROM Projectgroups p"),
    @NamedQuery(name="Projectgroups.findByUserId", query=" SELECT p FROM Projectgroups p WHERE p.userId = :userId"),
    @NamedQuery(name = "Projectgroups.findByGroupName", query = "SELECT p FROM Projectgroups p WHERE p.groupName = :groupName"),
    @NamedQuery(name = "Projectgroups.findByGroupId", query = "SELECT p FROM Projectgroups p WHERE p.groupId = :groupId")})
public class Projectgroups implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "groupName")
    private String groupName;
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Basic(optional = false)
    @Column(name = "groupId")
    private Integer groupId;
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private Projectusers userId;

    public Projectgroups() {
    }

    public Projectgroups(Integer groupId) {
        this.groupId = groupId;
    }

    public Projectgroups(Integer groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Projectusers getUserId() {
        return userId;
    }

    public void setUserId(Projectusers userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupId != null ? groupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projectgroups)) {
            return false;
        }
        Projectgroups other = (Projectgroups) object;
        if ((this.groupId == null && other.groupId != null) || (this.groupId != null && !this.groupId.equals(other.groupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Projectgroups[ groupId=" + groupId + " ]";
    }
    
}
