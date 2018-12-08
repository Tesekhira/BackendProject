package uh2.fstm.ilisi.Model.BO;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by AbdoWork on 24/11/2018.
 */
@Entity
@PrimaryKeyJoinColumn(name="id")
public class Client extends Utilisateur {

    private String adress;

    @OneToMany(mappedBy = "client")
    private Set<Recommander> recommander=new HashSet<>();

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
}
