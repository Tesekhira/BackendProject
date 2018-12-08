package uh2.fstm.ilisi.Model.BO;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by AbdoWork on 24/11/2018.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private Date date;
    private String email;
    private String password;
    private int type;
    @Transient
    private String token;
    public Utilisateur() {
    }

    public Utilisateur(String nom, String prenom, String email, Date date, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.date = date;
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
