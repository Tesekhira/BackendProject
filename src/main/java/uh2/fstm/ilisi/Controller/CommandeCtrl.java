package uh2.fstm.ilisi.Controller;

/**
 * Created by AbdoWork on 24/11/2018.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uh2.fstm.ilisi.Model.BO.Commande;
import uh2.fstm.ilisi.Service.CommandeService;

import java.util.List;

/**
 * Created by For work on 08/07/2018.
 */
@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/app/cmd")
public class CommandeCtrl {
    /**/
    @Autowired
    private CommandeService commandeService;

    @RequestMapping(value="/all",method= RequestMethod.GET)
    public List<Commande> getAll()
    {
        return (List<Commande>) commandeService.Retreive();
    }

    @RequestMapping(value="/create",method=RequestMethod.POST)
    public void create(@RequestBody Commande cmd)
    {
        commandeService.Insertion(cmd);
    }
    @RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
    public void delete(@PathVariable long id)
    {
        commandeService.Supprimer(id);

    }
    @RequestMapping(value="/update",method=RequestMethod.PUT)
    public void update(@RequestBody Commande cmd)
    {
        commandeService.Modifier(cmd);
    }

}
