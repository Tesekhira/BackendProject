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
    @Column(name="cmd_id",nullable = false)
    private long id;



    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="cmd_id",referencedColumnName = "cmd_id")
    private Set<LigneCommande> lignes;

    private double Total;


    @Column(name="client_id")
    private long client_id;



    @Column(name="livreur_id")
    private long livreur_id;

    private String titre;
    private Date date;
    /****
     * type_cmd = 1: commande express
     * type_cmd = 0: commande normale
     */
    private int type_cmd;
    /***
     * etat_cmd = 0: commande envoyée au livreur
     * etat_cmd = 1: commande accéptée par le livreur
     * etat_cmd = 2: commande encours de livraison
     * etat_cmd = 3: commande livrée par le livreur
     * etat_cmd = 4: commande annuler
     */
    private int etat_cmd;

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


    public long getClient_id() {
        return client_id;
    }

    public void setClient_id(long client_id) {
        this.client_id = client_id;
    }

    public long getLivreur_id() {
        return livreur_id;
    }

    public void setLivreur_id(long livreur_id) {
        this.livreur_id = livreur_id;
    }

    public int getType_cmd() {
        return type_cmd;
    }

    public void setType_cmd(int type_cmd) {
        this.type_cmd = type_cmd;
    }

    public int getEtat_cmd() {
        return etat_cmd;
    }

    public void setEtat_cmd(int etat_cmd) {
        this.etat_cmd = etat_cmd;
    }
}
