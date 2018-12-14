package uh2.fstm.ilisi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uh2.fstm.ilisi.Model.BO.Utilisateur;
import uh2.fstm.ilisi.Model.DAO.UtilisateurDAO;

import java.util.List;

/**
 * Created by TesekhiraEnligne on 11/25/18.
 */
@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurDAO utilisateurDAO;

    public List<Utilisateur> Retreive(){
        return (List<Utilisateur>) utilisateurDAO.findAll();
    }

    public void Insertion(Utilisateur sup)
    {
        utilisateurDAO.save(sup);
    }

    public void Supprimer(Long id)
    {
        utilisateurDAO.deleteById(id);
    }

    public void Modifier(Utilisateur sup)
    {
        utilisateurDAO.save(sup);
    }
    public Utilisateur RetreiveUtilisateur(Utilisateur user) {
        return (Utilisateur) utilisateurDAO.findByemail(user.getEmail());
    }
    public Utilisateur RetreiveUtilisateur(long id) {
        return (Utilisateur) utilisateurDAO.findById(id);
    }
}
