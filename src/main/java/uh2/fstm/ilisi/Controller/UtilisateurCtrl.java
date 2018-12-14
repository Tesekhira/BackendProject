package uh2.fstm.ilisi.Controller;

/**
 * Created by AbdoWork on 24/11/2018.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uh2.fstm.ilisi.Model.BO.Utilisateur;
import uh2.fstm.ilisi.Service.UserService;
import uh2.fstm.ilisi.Service.UtilisateurService;
import uh2.fstm.ilisi.exception.CustomException;
import uh2.fstm.ilisi.security.JwtTokenProvider;

import java.util.List;

/**
 * Created by For work on 08/07/2018.
 */
@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/app/user")
public class UtilisateurCtrl {
    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private ClientCtrl clientCtrl;

    @Autowired
    private LivreurCtrl livreurCtrl;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserService userService;

    @RequestMapping(value="/all",method= RequestMethod.GET)
    public List<Utilisateur> getAll(@RequestHeader("Authorization") String token)
    {
        if( jwtTokenProvider.getemail(token)!=null)
        return (List<Utilisateur>) utilisateurService.Retreive();
        return null;
    }
    @RequestMapping(value="/login",method= RequestMethod.POST)
    public Object getUtilisateur(@RequestBody Utilisateur user)
    {
        Utilisateur myuser=utilisateurService.RetreiveUtilisateur(user);
        if(myuser!=null)
            switch(myuser.getType()){
                case 1:
                    return (Object)clientCtrl.getClient(user);
                case 2:
                    return (Object)livreurCtrl.getLivreur(user);
            }
        return (Object)clientCtrl.getClient(user);

    }
    @RequestMapping(value="/create",method=RequestMethod.POST)
    public void create(@RequestBody Utilisateur user)
    {
        utilisateurService.Insertion(user);
    }
    @RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
    public void delete(@PathVariable long id,@RequestHeader("Authorization") String token)
    {
        if( jwtTokenProvider.getemail(token)!=null)
            utilisateurService.Supprimer(id);

    }
    @RequestMapping(value="/update",method=RequestMethod.PATCH)
    public void update(@RequestBody Utilisateur user,@RequestHeader("Authorization") String token)
    {
        if( jwtTokenProvider.getemail(token)!=null)
            utilisateurService.Modifier(user);
    }

}
