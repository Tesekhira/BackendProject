package uh2.fstm.ilisi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uh2.fstm.ilisi.Model.BO.Livreur;
import uh2.fstm.ilisi.Model.BO.Utilisateur;
import uh2.fstm.ilisi.Model.DAO.LivreurDAO;

import java.util.List;

/**
 * Created by TesekhiraEnligne on 11/25/18.
 */
@Service
public class LivreurService {
    @Autowired
    private LivreurDAO livreurDao;

    public List<Livreur> Retreive(){
        return (List<Livreur>) livreurDao.findAll();
    }

    public void Insertion(Livreur sup)
    {
        livreurDao.save(sup);
    }

    public void Supprimer(Long id)
    {
        livreurDao.deleteById(id);
    }

    public Livreur Modifier(Livreur sup)
    {
        return livreurDao.save(sup);
    }
    public Livreur RetreiveLivreur(Utilisateur client) {
        return (Livreur) livreurDao.findByemail(client.getEmail());
    }
    public Livreur RetreiveLivreur(long id) {
        return (Livreur) livreurDao.findById(id);
    }

}
