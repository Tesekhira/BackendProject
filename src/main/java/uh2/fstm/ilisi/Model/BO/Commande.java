package uh2.fstm.ilisi.Model.BO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
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

    @OneToMany(mappedBy = "cmd")
    private Set<LigneCommande> lignes;
    private double Total;

    public Commande() {
        lignes=new HashSet<>();
    }

    public Commande(Set<LigneCommande> lignes, double total) {
        this.lignes = lignes;
        Total = total;
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
}
