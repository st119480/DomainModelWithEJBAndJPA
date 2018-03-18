package com.bazaar.domain;

import org.apache.commons.codec.binary.Base64;

import javax.persistence.*;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@Entity
@Table(name = "USERS")
public class User implements Serializable {
    public static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger("User");

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long userId;
    private String firstName;
    private String lastName;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birthDate;
    private String password;
    private String username;
    private String email;

    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    public User(String firstName, String lastName, String username,
                String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        if (password != null) {
            setPassword(password);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName.toUpperCase();
    }

    public String getLastName() {
        return lastName;
    }

    protected void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setPassword(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes("UTF-8"));
            byte[] digest = md.digest();
            byte[] encodedPassword = Base64.encodeBase64(digest);
            this.password = new String(encodedPassword);
        } catch (NoSuchAlgorithmException e) {
            logger.log(Level.SEVERE, "Password creation failed", e);
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            logger.log(Level.SEVERE, "Password creation failed", e);
            throw new RuntimeException(e);
        }
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}