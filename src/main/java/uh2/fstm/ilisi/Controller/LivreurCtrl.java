package uh2.fstm.ilisi.Controller;

/**
 * Created by AbdoWork on 24/11/2018.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import uh2.fstm.ilisi.Model.BO.Client;
import uh2.fstm.ilisi.Model.BO.Livreur;
import uh2.fstm.ilisi.Model.BO.Utilisateur;
import uh2.fstm.ilisi.Service.LivreurService;
import uh2.fstm.ilisi.Service.UserService;
import uh2.fstm.ilisi.security.JwtTokenProvider;

import java.util.List;

/**
 * Created by For work on 08/07/2018.
 */
//@CrossOrigin(origins = {"http://localhost:4200","http://192.168.1.13:4200"})
@CrossOrigin(origins  = "*")
@RestController
@RequestMapping("/app/livreur")
public class LivreurCtrl {
    @Autowired
    private LivreurService livreurService;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value="/all",method= RequestMethod.GET)
    public List<Livreur> getAll()
    {
        return (List<Livreur>) livreurService.Retreive();
    }
    @RequestMapping(value="/{id}",method= RequestMethod.GET)
    public Livreur getLivreurId(@PathVariable long id)
    {
        return (Livreur) livreurService.RetreiveLivreur(id);
    }
    @RequestMapping(value="/login",method= RequestMethod.POST)
    public Livreur getLivreur(@RequestBody Utilisateur cli)
    {
        String token=userService.signin(cli,2);
        if(token!=null)
        {
            Livreur livreur=(Livreur) livreurService.RetreiveLivreur(cli);
            livreur.setToken(token);
            return livreur;
        }
        return null;
    }
    @RequestMapping(value="/create",method=RequestMethod.POST)
    public Utilisateur create(@RequestBody Livreur liv)
    {
        return (Utilisateur)userService.signup(liv,2);
    }
    @RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
    public void delete(@PathVariable long id,@RequestHeader("Authorization") String token)
    {
        if( jwtTokenProvider.getemail(token)!=null)
        livreurService.Supprimer(id);

    }
    @RequestMapping(value="/update",method=RequestMethod.PATCH)
    public Livreur update(@RequestBody  Livreur liv,@RequestHeader("Authorization") String token)
    {
        if( jwtTokenProvider.getemail(token)!=null)
            return livreurService.Modifier(liv);

        return null;
    }
    @MessageMapping("/updateLiv")
    @SendTo("/socket/profileLivreur")
    public Livreur updateLiv(Livreur Liv)
    {
        return Liv;
    }
    @RequestMapping(value="/CompteUpdate",method=RequestMethod.PATCH)
    public Livreur updateCompte(@RequestBody  Livreur liv,@RequestHeader("Authorization") String token)
    {
        if( jwtTokenProvider.getemail(token)!=null){
            liv.setPassword(passwordEncoder.encode(liv.getPassword()));
            return livreurService.Modifier(liv);
        }

        return null;
    }
}
