package uh2.fstm.ilisi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uh2.fstm.ilisi.Model.BO.Recommander;
import uh2.fstm.ilisi.Model.BO.SuperMarcher;
import uh2.fstm.ilisi.Model.DAO.RecommanderDAO;
import uh2.fstm.ilisi.Model.DAO.SuperMarcherDAO;

import java.util.List;

/**
 * Created by TesekhiraEnligne on 11/25/18.
 */
@Service
public class RecommanderService {
    /**/
    @Autowired
    private RecommanderDAO recommanderDAO;

    public List<Recommander>  Retreive(){
        return (List<Recommander>) recommanderDAO.findAll();
    }

    public Recommander Insertion(Recommander sup)
    {
        return recommanderDAO.save(sup);
    }

    public void Supprimer(Long id)
    {
        recommanderDAO.deleteById(id);
    }

    public Recommander Modifier(Recommander sup)
    {
        return recommanderDAO.save(sup);
    }
}
