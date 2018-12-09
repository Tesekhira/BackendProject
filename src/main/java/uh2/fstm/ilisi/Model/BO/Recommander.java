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
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JsonIgnore
    private Livreur livreurR;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JsonIgnore
    private Client clientR;

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

    public Livreur getLivreurR() {
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
    }
}
