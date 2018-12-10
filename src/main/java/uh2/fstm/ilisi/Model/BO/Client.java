package uh2.fstm.ilisi.Model.BO;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by AbdoWork on 24/11/2018.
 */
@Entity
@PrimaryKeyJoinColumn(name="client_id")
public class Client extends Utilisateur {

    private String adress;

    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy="clientR")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="client_id",referencedColumnName = "client_id")
    private Set<Recommander> recommander=new HashSet<>();


   @OneToMany(cascade = CascadeType.ALL)
   @JoinColumn(name="client_id",referencedColumnName = "client_id")
    private Set<Commande> commandes;


    public Client() {
        this.setType(1);

    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Client(String nom, String prenom, String email, Date date, String password, Set<Recommander> recommander) {
        super(nom, prenom, email, date, password);
        this.recommander = recommander;
    }

    public Set<Recommander> getRecommander() {
        return recommander;
    }

    public void setRecommander(Set<Recommander> recommander) {
        this.recommander = recommander;
    }

    public Set<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Set<Commande> commandes) {
        this.commandes = commandes;
    }
}
