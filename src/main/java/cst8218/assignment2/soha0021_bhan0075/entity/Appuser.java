/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cst8218.assignment2.soha0021_bhan0075.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;
import java.io.Serializable;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bhand
 */

@Entity
public class Appuser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userid;
    private String password;
    private String groupname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return "";
    }

    public void setPassword(String password) {
        if (password != null && !password.isEmpty()) {
            this.password = hashPassword(password);
        }
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    private String hashPassword(String password) {
        try {
            Pbkdf2PasswordHash passwordHash = CDI.current().select(Pbkdf2PasswordHash.class).get();
            passwordHash.initialize(new HashMap<>()); 
            return passwordHash.generate(password.toCharArray());
        } catch (Exception e) {
            Logger.getLogger(Appuser.class.getName()).log(Level.SEVERE, "Password hashing failed", e);
            return null;
        }
    }

    public boolean checkPassword(String enteredPassword) {
        if (enteredPassword == null || this.password == null) {
            return false;
        }
        try {
            Pbkdf2PasswordHash passwordHash = CDI.current().select(Pbkdf2PasswordHash.class).get();
            return passwordHash.verify(enteredPassword.toCharArray(), this.password);
        } catch (Exception e) {
            Logger.getLogger(Appuser.class.getName()).log(Level.SEVERE, "Password verification failed", e);
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Appuser)) {
            return false;
        }
        Appuser other = (Appuser) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id))
                && (this.userid != null || other.userid == null) && (this.userid == null || this.userid.equals(other.userid));
    }

    @Override
    public String toString() {
        return "cst8218.assignment2.soha0021_bhan0075.entity.Appuser[ id=" + id + " ]";
    }
    
}
