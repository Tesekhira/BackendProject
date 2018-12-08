package uh2.fstm.ilisi.Model.BO;

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
    @ManyToOne
    private Livreur livreur;

    @ManyToOne
    private Client client;

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

    public Livreur getLivreur() {
        return livreur;
    }

    public void setLivreur(Livreur livreur) {
        this.livreur = livreur;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
