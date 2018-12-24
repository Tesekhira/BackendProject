package uh2.fstm.ilisi.Controller;

/**
 * Created by AbdoWork on 24/11/2018.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import uh2.fstm.ilisi.Model.BO.Client;
import uh2.fstm.ilisi.Model.BO.Utilisateur;
import uh2.fstm.ilisi.Model.DAO.UtilisateurDAO;
import uh2.fstm.ilisi.Service.ClientService;
import uh2.fstm.ilisi.Service.UserService;
import uh2.fstm.ilisi.security.JwtTokenProvider;

import java.util.List;

/**
 * Created by For work on 08/07/2018.
 */
//@CrossOrigin(origins = {"http://localhost:4200","http://192.168.1.13:4200"})
@CrossOrigin(origins  = "*")

@RestController
@RequestMapping("/app/client")
public class ClientCtrl {
    @Autowired
    private ClientService clientService;

    @Autowired
    private UserService userService;

    @Autowired
    private UtilisateurDAO utilisateurDAO;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value="/all",method= RequestMethod.GET)
    public List<Client> getAll(@RequestHeader("Authorization") String token)
    {

       if( jwtTokenProvider.getemail(token)!=null)
        return (List<Client>) clientService.Retreive();
        return null;
    }
    @RequestMapping(value="/{id}",method= RequestMethod.GET)
    public Client getClientId(@PathVariable long id)
    {
        return (Client) clientService.RetreiveClient(id);
    }
    @RequestMapping(value="/login",method= RequestMethod.POST)
    public Client getClient(@RequestBody Utilisateur cli)
    {
            String token=userService.signin(cli,1);
            if(token!=null)
            {
                Client client=(Client) clientService.RetreiveClient(cli);
                client.setToken(token);
                return client;
            }
            return null;
    }
    @RequestMapping(value="/create",method=RequestMethod.POST)
    public Utilisateur create(@RequestBody Client cli)
    {
        return (Utilisateur)userService.signup(cli,1);
    }
    @RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
    public void delete(@PathVariable long id,@RequestHeader("Authorization") String token)
    {
        if( jwtTokenProvider.getemail(token)!=null)
        clientService.Supprimer(id);

    }
    @RequestMapping(value="/update",method=RequestMethod.PATCH)
    public Client update(@RequestBody  Client cli,@RequestHeader("Authorization") String token)
    {
        if( jwtTokenProvider.getemail(token)!=null){
            Utilisateur res=utilisateurDAO.findByemail(cli.getEmail());
            if(res == null || (res != null  && res.getId() == cli.getId() ) )
                return clientService.Modifier(cli);
        }
        return null;
    }

    @RequestMapping(value="/CompteUpdate",method=RequestMethod.PATCH)
    public Client updateCompte(@RequestBody  Client cli,@RequestHeader("Authorization") String token)
    {
        if( jwtTokenProvider.getemail(token)!=null){
            cli.setPassword(passwordEncoder.encode(cli.getPassword()));
            return clientService.Modifier(cli);
        }
        return null;
    }
}
