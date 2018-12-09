package uh2.fstm.ilisi.Model.BO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by AbdoWork on 24/11/2018.
 */
@Entity
public class LigneCommande implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JsonIgnore
    private Commande cmd;

    private String nom_prod;
    private double prix_prod;
    private double quantite;
    private double sub_total;

    public LigneCommande() {
        cmd=new Commande();
    }

    public LigneCommande(Commande cmd, String nom_prod, double prix_prod, double quantite, double sub_total) {
        this.cmd = cmd;
        this.nom_prod = nom_prod;
        this.prix_prod = prix_prod;
        this.quantite = quantite;
        this.sub_total = sub_total;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Commande getCmd() {
        return cmd;
    }

    public void setCmd(Commande cmd) {
        this.cmd = cmd;
    }

    public String getNom_prod() {
        return nom_prod;
    }

    public void setNom_prod(String nom_prod) {
        this.nom_prod = nom_prod;
    }

    public double getPrix_prod() {
        return prix_prod;
    }

    public void setPrix_prod(double prix_prod) {
        this.prix_prod = prix_prod;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public double getSub_total() {
        return sub_total;
    }

    public void setSub_total(double sub_total) {
        this.sub_total = sub_total;
    }
}
