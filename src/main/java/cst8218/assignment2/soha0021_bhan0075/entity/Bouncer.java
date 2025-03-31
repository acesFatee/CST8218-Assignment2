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
 * @author bhan
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

    /**
     * Default constructor for creating a new Bouncer instance.
     */
    public Bouncer() {
    }

    /**
     * Constructs a new Bouncer instance with the given ID.
     *
     * @param id the unique identifier for this bouncer
     */
    public Bouncer(Integer id) {
        this.id = id;
    }

    /**
     * Gets the ID of the bouncer.
     *
     * @return the ID of the bouncer
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the ID of the bouncer.
     *
     * @param id the ID to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the x-coordinate of the bouncer.
     *
     * @return the x-coordinate
     */
    public Integer getX() {
        return x;
    }

    /**
     * Sets the x-coordinate of the bouncer.
     *
     * @param x the x-coordinate to set
     */
    public void setX(Integer x) {
        this.x = x;
    }

    /**
     * Gets the y-coordinate of the bouncer.
     *
     * @return the y-coordinate
     */
    public Integer getY() {
        return y;
    }

    /**
     * Sets the y-coordinate of the bouncer.
     *
     * @param y the y-coordinate to set
     */
    public void setY(Integer y) {
        this.y = y;
    }

    /**
     * Gets the size of the bouncer.
     *
     * @return the size of the bouncer
     */
    public Integer getSize() {
        return size;
    }

    /**
     * Sets the size of the bouncer.
     *
     * @param size the size to set
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * Gets the current travel distance of the bouncer.
     *
     * @return the current travel distance
     */
    public Integer getCurrentTravel() {
        return currentTravel;
    }

    /**
     * Sets the current travel distance of the bouncer.
     *
     * @param currentTravel the current travel distance to set
     */
    public void setCurrentTravel(Integer currentTravel) {
        this.currentTravel = currentTravel;
    }

    /**
     * Gets the maximum travel distance of the bouncer.
     *
     * @return the maximum travel distance
     */
    public Integer getMaxTravel() {
        return maxTravel;
    }

    /**
     * Sets the maximum travel distance of the bouncer.
     *
     * @param maxTravel the maximum travel distance to set
     */
    public void setMaxTravel(Integer maxTravel) {
        this.maxTravel = maxTravel;
    }

    /**
     * Gets the movement direction of the bouncer.
     *
     * @return the movement direction
     */
    public Integer getMvtDirection() {
        return mvtDirection;
    }

    /**
     * Sets the movement direction of the bouncer.
     *
     * @param mvtDirection the movement direction to set
     */
    public void setMvtDirection(Integer mvtDirection) {
        this.mvtDirection = mvtDirection;
    }

    /**
     * Gets the number of times the direction of the bouncer has changed.
     *
     * @return the direction change count
     */
    public Integer getDirChangeCount() {
        return dirChangeCount;
    }

    /**
     * Sets the number of times the direction of the bouncer has changed.
     *
     * @param dirChangeCount the direction change count to set
     */
    public void setDirChangeCount(Integer dirChangeCount) {
        this.dirChangeCount = dirChangeCount;
    }

    /**
     * Gets the creation timestamp of the bouncer.
     *
     * @return the creation timestamp
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the creation timestamp of the bouncer.
     *
     * @param createdAt the creation timestamp to set
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the last updated timestamp of the bouncer.
     *
     * @return the last updated timestamp
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets the last updated timestamp of the bouncer.
     *
     * @param updatedAt the last updated timestamp to set
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * Computes the hash code for this bouncer object based on its ID.
     *
     * @return a hash code for this bouncer
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compares this bouncer to another object for equality based on ID.
     *
     * @param object the object to compare to
     * @return {@code true} if this bouncer has the same ID as the other object, {@code false} otherwise
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Bouncer)) {
            return false;
        }
        Bouncer other = (Bouncer) object;
        return (this.id != null && this.id.equals(other.id));
    }

    /**
     * Returns a string representation of this bouncer object.
     *
     * @return a string representation of this bouncer
     */
    @Override
    public String toString() {
        return "cst8218.assignment2.soha0021_bhan0075.entity.Bouncer[ id=" + id + " ]";
    }
}