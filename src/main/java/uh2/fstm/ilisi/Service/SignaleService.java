package uh2.fstm.ilisi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uh2.fstm.ilisi.Model.BO.Signale;
import uh2.fstm.ilisi.Model.DAO.SignaleDAO;


import java.util.List;

/**
 * Created by TesekhiraEnligne on 11/25/18.
 */
@Service
public class SignaleService {
    /**/
    @Autowired
    private SignaleDAO signaleDAO;

    public List<Signale>  Retreive(){
        return (List<Signale>) signaleDAO.findAll();
    }

    public Signale Insertion(Signale sup)
    {
        return signaleDAO.save(sup);
    }

    public void Supprimer(Long id)
    {
        signaleDAO.deleteById(id);
    }

    public Signale Modifier(Signale sup)
    {
        return signaleDAO.save(sup);
    }
}
