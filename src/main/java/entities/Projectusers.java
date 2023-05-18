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
@Table(name = "projectusers")
@NamedQueries({
    @NamedQuery(name = "Projectusers.findAll", query = "SELECT p FROM Projectusers p"),
    @NamedQuery(name = "Projectusers.findByUserId", query = "SELECT p FROM Projectusers p WHERE p.userId = :userId"),
    @NamedQuery(name = "Projectusers.findByPassword", query = "SELECT p FROM Projectusers p WHERE p.password = :password")})
public class Projectusers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "userId")
    private String userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Projectgroups> projectgroupsList;

    public Projectusers() {
    }

    public Projectusers(String userId) {
        this.userId = userId;
    }

    public Projectusers(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
@JsonbTransient
    public List<Projectgroups> getProjectgroupsList() {
        return projectgroupsList;
    }

    public void setProjectgroupsList(List<Projectgroups> projectgroupsList) {
        this.projectgroupsList = projectgroupsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projectusers)) {
            return false;
        }
        Projectusers other = (Projectusers) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Projectusers[ userId=" + userId + " ]";
    }
    
}
