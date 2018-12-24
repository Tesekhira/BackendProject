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
    /**
     * 0 : pas encore recommander
     * 1 : up
     * -1 : down
     */
    private int etat;

    @Column(name="livreur_id")
    private long livreur_id;

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

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

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
