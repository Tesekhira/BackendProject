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
public class Livreur extends Utilisateur {



    @OneToMany(mappedBy = "livreur")
    private Set<Recommander> recommandation=new HashSet<>();
    private String path_img;

    public Livreur() {
        this.setType(2);
    }

    public Livreur(String nom, String prenom, String email, Date date, String password, String path_img, Set<Recommander> recommandation) {
        super(nom, prenom, email, date, password);
        this.path_img = path_img;
        this.recommandation = recommandation;
    }

    public Livreur(String path_img,Set<Recommander> recommandation) {
        this.path_img = path_img;
        this.recommandation = recommandation;
    }

    public String getPath_img() {
        return path_img;
    }

    public void setPath_img(String path_img) {
        this.path_img = path_img;
    }

    public Set<Recommander> getRecommandation() {
        return recommandation;
    }

    public void setRecommandation(Set<Recommander> recommandation) {
        this.recommandation = recommandation;
    }

}
