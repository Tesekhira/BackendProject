package uh2.fstm.ilisi.Controller;

/**
 * Created by AbdoWork on 24/11/2018.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uh2.fstm.ilisi.Model.BO.SuperMarcher;
import uh2.fstm.ilisi.Service.SuperMarcherService;

import java.util.List;

/**
 * Created by For work on 08/07/2018.
 */
@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/app/marcher")
public class SuperMarcherCtrl {

    @Autowired
    SuperMarcherService supermarcherservice;

    /**/
    @RequestMapping(value="/all",method= RequestMethod.GET)
    public List<SuperMarcher> getAll()
    {
        return supermarcherservice.Retreive();
    }

    @RequestMapping(value="/create",method=RequestMethod.POST)
    public void create(@RequestBody SuperMarcher sup)
    {

    }
    @RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
    public void delete(@PathVariable Long id)
    {
        supermarcherservice.Supprimer(id);
    }
    @RequestMapping(value="/update",method=RequestMethod.PUT)
    public void update(@RequestBody SuperMarcher sup)
    {
        supermarcherservice.Modifier(sup);
    }

}
