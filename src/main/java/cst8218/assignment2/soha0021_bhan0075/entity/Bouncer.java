/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cst8218.assignment2.soha0021_bhan0075.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author harka
 */
@Entity
@Table(name = "bouncer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bouncer.findAll", query = "SELECT b FROM Bouncer b"),
    @NamedQuery(name = "Bouncer.findById", query = "SELECT b FROM Bouncer b WHERE b.id = :id"),
    @NamedQuery(name = "Bouncer.findByX", query = "SELECT b FROM Bouncer b WHERE b.x = :x"),
    @NamedQuery(name = "Bouncer.findByY", query = "SELECT b FROM Bouncer b WHERE b.y = :y"),
    @NamedQuery(name = "Bouncer.findBySize", query = "SELECT b FROM Bouncer b WHERE b.size = :size"),
    @NamedQuery(name = "Bouncer.findByCurrentTravel", query = "SELECT b FROM Bouncer b WHERE b.currentTravel = :currentTravel"),
    @NamedQuery(name = "Bouncer.findByMaxTravel", query = "SELECT b FROM Bouncer b WHERE b.maxTravel = :maxTravel"),
    @NamedQuery(name = "Bouncer.findByMvtDirection", query = "SELECT b FROM Bouncer b WHERE b.mvtDirection = :mvtDirection"),
    @NamedQuery(name = "Bouncer.findByDirChangeCount", query = "SELECT b FROM Bouncer b WHERE b.dirChangeCount = :dirChangeCount"),
    @NamedQuery(name = "Bouncer.findByCreatedAt", query = "SELECT b FROM Bouncer b WHERE b.createdAt = :createdAt"),
    @NamedQuery(name = "Bouncer.findByUpdatedAt", query = "SELECT b FROM Bouncer b WHERE b.updatedAt = :updatedAt")})
public class Bouncer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "x")
    private Integer x;
    @Column(name = "y")
    private Integer y;
    @Column(name = "size")
    private Integer size;
    @Column(name = "currentTravel")
    private Integer currentTravel;
    @Column(name = "maxTravel")
    private Integer maxTravel;
    @Column(name = "mvtDirection")
    private Integer mvtDirection;
    @Column(name = "dirChangeCount")
    private Integer dirChangeCount;
    @Column(name = "createdAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updatedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Bouncer() {
    }

    public Bouncer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getCurrentTravel() {
        return currentTravel;
    }

    public void setCurrentTravel(Integer currentTravel) {
        this.currentTravel = currentTravel;
    }

    public Integer getMaxTravel() {
        return maxTravel;
    }

    public void setMaxTravel(Integer maxTravel) {
        this.maxTravel = maxTravel;
    }

    public Integer getMvtDirection() {
        return mvtDirection;
    }

    public void setMvtDirection(Integer mvtDirection) {
        this.mvtDirection = mvtDirection;
    }

    public Integer getDirChangeCount() {
        return dirChangeCount;
    }

    public void setDirChangeCount(Integer dirChangeCount) {
        this.dirChangeCount = dirChangeCount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bouncer)) {
            return false;
        }
        Bouncer other = (Bouncer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cst8218.assignment2.soha0021_bhan0075.entity.Bouncer[ id=" + id + " ]";
    }
    
}
