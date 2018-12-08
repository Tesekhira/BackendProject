package uh2.fstm.ilisi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uh2.fstm.ilisi.Model.BO.SuperMarcher;
import uh2.fstm.ilisi.Model.DAO.SuperMarcherDAO;

import java.util.List;

/**
 * Created by TesekhiraEnligne on 11/25/18.
 */
@Service
public class SuperMarcherService {
    /**/
    @Autowired
    private SuperMarcherDAO SuperMarcherDao;

    public List<SuperMarcher>  Retreive(){
        return (List<SuperMarcher>) SuperMarcherDao.findAll();
    }

    public void Insertion(SuperMarcher sup)
    {
        SuperMarcherDao.save(sup);
    }

    public void Supprimer(Long id)
    {
        SuperMarcherDao.deleteById(id);
    }

    public void Modifier(SuperMarcher sup)
    {
        SuperMarcherDao.save(sup);
    }
}
