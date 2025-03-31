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
 * The Appuser class represents a user entity for authentication and group management.
 * It provides methods for handling user credentials, password hashing, and verification.
 * This class is typically used for managing user login functionality and ensuring secure password storage.
 * 
 * @author bhand
 */
@Entity
public class Appuser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Unique identifier for the user in the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The username of the user.
     */
    private String userid;

    /**
     * The hashed password of the user. The actual password is never stored in plain text.
     */
    private String password;

    /**
     * The group name that the user belongs to (e.g., "admin" or "user").
     */
    private String groupname;

    /**
     * Retrieves the unique identifier of the user.
     * 
     * @return the user's ID.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the user.
     * 
     * @param id the unique ID to be set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retrieves the username of the user.
     * 
     * @return the user's username.
     */
    public String getUserid() {
        return userid;
    }

    /**
     * Sets the username for the user.
     * 
     * @param userid the username to be set.
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * Retrieves the password for the user. This is always returned as an empty string to avoid exposure of the raw password.
     * 
     * @return an empty string since the raw password should never be accessed directly.
     */
    public String getPassword() {
        return "";
    }

    /**
     * Sets the password for the user. The password is hashed before being stored.
     * 
     * @param password the password to be set. It will be hashed for security.
     */
    public void setPassword(String password) {
        if (password != null && !password.isEmpty()) {
            this.password = hashPassword(password);
        }
    }

    /**
     * Retrieves the group name the user belongs to (e.g., "admin" or "user").
     * 
     * @return the group name.
     */
    public String getGroupname() {
        return groupname;
    }

    /**
     * Sets the group name for the user (e.g., "admin" or "user").
     * 
     * @param groupname the group name to be set.
     */
    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    /**
     * Hashes the provided password using the PBKDF2 algorithm for secure storage.
     * 
     * @param password the password to be hashed.
     * @return the hashed password or null if hashing fails.
     */
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

    /**
     * Verifies the entered password against the stored hashed password.
     * 
     * @param enteredPassword the password to be verified.
     * @return true if the entered password matches the stored password, false otherwise.
     */
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

    /**
     * Computes a hash code for the Appuser object based on the user ID and username.
     * 
     * @return the hash code for the Appuser object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    /**
     * Compares this Appuser object to another object for equality.
     * The comparison is based on the user's ID and username.
     * 
     * @param object the object to compare with.
     * @return true if the objects are considered equal, false otherwise.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Appuser)) {
            return false;
        }
        Appuser other = (Appuser) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id))
                && (this.userid != null || other.userid == null) && (this.userid == null || this.userid.equals(other.userid));
    }

    /**
     * Returns a string representation of the Appuser object, including the user ID.
     * 
     * @return a string representation of the Appuser object.
     */
    @Override
    public String toString() {
        return "cst8218.assignment2.soha0021_bhan0075.entity.Appuser[ id=" + id + " ]";
    }

}
