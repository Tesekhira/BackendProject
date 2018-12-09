package uh2.fstm.ilisi.Model.BO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by AbdoWork on 24/11/2018.
 */
@Entity
public class Commande implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;


    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
            ,mappedBy="cmd")
    private Set<LigneCommande> lignes;
    private double Total;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JsonIgnore
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JsonIgnore
    private Livreur livreur;

    private String titre;
    private Date date;

    public Commande() {
        lignes=new HashSet<>();
        date=new Date();
    }

    public Commande(Set<LigneCommande> lignes, double total) {
        this.lignes = lignes;
        Total = total;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Collection<LigneCommande> getLignes() {
        return lignes;
    }

    public void setLignes(Set<LigneCommande> lignes) {
        this.lignes = lignes;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        Total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Livreur getLivreur() {
        return livreur;
    }

    public void setLivreur(Livreur livreur) {
        this.livreur = livreur;
    }
}
