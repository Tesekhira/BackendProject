package uh2.fstm.ilisi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uh2.fstm.ilisi.Model.BO.Client;
import uh2.fstm.ilisi.Model.BO.Signale;
import uh2.fstm.ilisi.Service.ClientService;
import uh2.fstm.ilisi.Service.SignaleService;
import uh2.fstm.ilisi.security.JwtTokenProvider;

import java.util.List;

@CrossOrigin(origins  = "*")
@RestController
@RequestMapping("/app/signale")
public class SignaleCtrl {

    @Autowired
    SignaleService signaleService;

    @Autowired
    ClientService clientService;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    /**/
    @RequestMapping(value="/all",method= RequestMethod.GET)
    public List<Signale> getAll()
    {
        return signaleService.Retreive();
    }

    @RequestMapping(value="/create",method=RequestMethod.POST)
    public Signale create(@RequestBody Signale rec, @RequestHeader("Authorization") String token)
    {
        if( jwtTokenProvider.getemail(token)!=null)
        {
            Signale s = signaleService.Insertion(rec);
            Client c = clientService.RetreiveClient(rec.getClient_id());
            c.setNbSignale(c.getNbSignale() + 1);
            clientService.Modifier(c);
            return s;
        }

        return null;
    }
    @RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
    public void delete(@PathVariable Long id,@RequestHeader("Authorization") String token)
    {
        if( jwtTokenProvider.getemail(token)!=null)
            signaleService.Supprimer(id);
    }
    @RequestMapping(value="/update",method=RequestMethod.PATCH)
    public Signale update(@RequestBody Signale rec,@RequestHeader("Authorization") String token)
    {
        if( jwtTokenProvider.getemail(token)!=null)
            return signaleService.Modifier(rec);
        return null;
    }

}
