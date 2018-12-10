package uh2.fstm.ilisi.Model.BO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by TesekhiraEnligne on 11/24/18.
 */
@Entity
public class Recommander {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private boolean etat;
   // @ManyToOne(fetch = FetchType.LAZY,optional = false)
    //@JsonIgnore
    //private Livreur livreurR;

    @Column(name="livreur_id")
    private long livreur_id;
    //@ManyToOne(fetch = FetchType.LAZY,optional = false)
    //@JsonIgnore
    //private Client clientR;
    @Column(name="client_id")
    private long client_id;
    public Recommander() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

   /* public Livreur getLivreurR() {
        return livreurR;
    }

    public void setLivreurR(Livreur livreur) {
        this.livreurR = livreur;
    }

    public Client getClientR() {
        return clientR;
    }

    public void setClientR(Client client) {
        this.clientR = client;
    }*/

    public long getLivreur_id() {
        return livreur_id;
    }

    public void setLivreur_id(long livreur_id) {
        this.livreur_id = livreur_id;
    }

    public long getClient_id() {
        return client_id;
    }

    public void setClient_id(long client_id) {
        this.client_id = client_id;
    }
}
