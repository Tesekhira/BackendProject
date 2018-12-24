package uh2.fstm.ilisi.Model.BO;


import javax.persistence.*;

@Entity
public class Signale {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="livreur_id")
    private long livreur_id;

    @Column(name="client_id")
    private long client_id;

    private boolean etat_signale;
    public Signale() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isEtat_signale() {
        return etat_signale;
    }

    public void setEtat_signale(boolean etat_signale) {
        this.etat_signale = etat_signale;
    }
}
