package uh2.fstm.ilisi.Controller;

/**
 * Created by AbdoWork on 24/11/2018.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;
import uh2.fstm.ilisi.Model.BO.Commande;
import uh2.fstm.ilisi.Service.CommandeService;
import uh2.fstm.ilisi.security.JwtTokenProvider;

import java.util.List;

/**
 * Created by For work on 08/07/2018.
 */
//@CrossOrigin(origins = {"http://localhost:4200","http://192.168.1.13:4200"})
@CrossOrigin(origins  = "*")
@RestController
@RequestMapping("/app/cmd")
public class CommandeCtrl {
    /**/
    @Autowired
    private CommandeService commandeService;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @RequestMapping(value="/all",method= RequestMethod.GET)
    public List<Commande> getAll(@RequestHeader("Authorization") String token)
    {
        if( jwtTokenProvider.getemail(token)!=null)
        return (List<Commande>) commandeService.Retreive();
        return null;
    }

    @RequestMapping(value="/create",method=RequestMethod.POST)
    @MessageMapping("/newCommande")
    @SendTo("/socket/new")
    public Commande create(@RequestBody Commande cmd,@RequestHeader("Authorization") String token)
    {
        if( jwtTokenProvider.getemail(token)!=null)
            return commandeService.Insertion(cmd);

        return null;
    }
    @RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
    public void delete(@PathVariable long id,@RequestHeader("Authorization") String token)
    {
        if( jwtTokenProvider.getemail(token)!=null)
        commandeService.Supprimer(id);

    }
    @RequestMapping(value="/update",method=RequestMethod.PATCH)
    public void update(@RequestBody Commande cmd,@RequestHeader("Authorization") String token)
    {
        if( jwtTokenProvider.getemail(token)!=null)
            commandeService.Modifier(cmd);
    }
}
