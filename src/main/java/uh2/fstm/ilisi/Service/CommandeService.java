package uh2.fstm.ilisi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uh2.fstm.ilisi.Model.BO.Commande;
import uh2.fstm.ilisi.Model.DAO.CommandeDAO;

import java.util.List;

/**
 * Created by TesekhiraEnligne on 11/25/18.
 */
@Service
public class CommandeService {
    /**/
    @Autowired
    private CommandeDAO commandeDao;

    public List<Commande> Retreive(){
        return (List<Commande>) commandeDao.findAll();
    }

    public Commande Insertion(Commande sup)
    {
        return commandeDao.save(sup);
    }

    public void Supprimer(Long id)
    {
        commandeDao.deleteById(id);
    }

    public Commande Modifier(Commande sup)
    {
        return commandeDao.save(sup);
    }
}
