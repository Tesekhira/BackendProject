package uh2.fstm.ilisi.Controller;

/**
 * Created by AbdoWork on 24/11/2018.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uh2.fstm.ilisi.Model.BO.Recommander;
import uh2.fstm.ilisi.Model.BO.SuperMarcher;
import uh2.fstm.ilisi.Service.RecommanderService;
import uh2.fstm.ilisi.Service.SuperMarcherService;
import uh2.fstm.ilisi.security.JwtTokenProvider;

import java.util.List;

/**
 * Created by For work on 08/07/2018.
 */
//@CrossOrigin(origins = {"http://localhost:4200","http://192.168.1.13:4200"})
@CrossOrigin(origins  = "*")
@RestController
@RequestMapping("/app/recommander")
public class RecommanderCtrl {

    @Autowired
    RecommanderService recommanderService;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    /**/
    @RequestMapping(value="/all",method= RequestMethod.GET)
    public List<Recommander> getAll()
    {
        return recommanderService.Retreive();
    }

    @RequestMapping(value="/create",method=RequestMethod.POST)
    public Recommander create(@RequestBody Recommander rec,@RequestHeader("Authorization") String token)
    {
        if( jwtTokenProvider.getemail(token)!=null)
            return recommanderService.Insertion(rec);
        return null;
    }
    @RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
    public void delete(@PathVariable Long id,@RequestHeader("Authorization") String token)
    {
        if( jwtTokenProvider.getemail(token)!=null)
            recommanderService.Supprimer(id);
    }
    @RequestMapping(value="/update",method=RequestMethod.PATCH)
    public Recommander update(@RequestBody Recommander rec,@RequestHeader("Authorization") String token)
    {
        if( jwtTokenProvider.getemail(token)!=null)
            return recommanderService.Modifier(rec);
        return null;
    }

}
