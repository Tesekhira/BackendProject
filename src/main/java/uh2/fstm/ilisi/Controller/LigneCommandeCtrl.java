package uh2.fstm.ilisi.Controller;

/**
 * Created by AbdoWork on 24/11/2018.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uh2.fstm.ilisi.Model.BO.LigneCommande;
import uh2.fstm.ilisi.Service.LigneCommandeService;

import java.util.List;

/**
 * Created by For work on 08/07/2018.
 */
@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/app/lignecmd")
public class LigneCommandeCtrl {
    @Autowired
    private LigneCommandeService ligneCommandeService;
    /**/
    @RequestMapping(value="/all",method= RequestMethod.GET)
    public List<LigneCommande> getAll()
    {
        return (List<LigneCommande>) ligneCommandeService.Retreive();
    }

    @RequestMapping(value="/create",method=RequestMethod.POST)
    public void create(@RequestBody LigneCommande lign)
    {
        ligneCommandeService.Insertion(lign);
    }
    @RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
    public void delete(@PathVariable long id)
    {
        ligneCommandeService.Supprimer(id);

    }
    @RequestMapping(value="/update",method=RequestMethod.PUT)
    public void update(@RequestBody LigneCommande lign)
    {
        ligneCommandeService.Modifier(lign);
    }

}
