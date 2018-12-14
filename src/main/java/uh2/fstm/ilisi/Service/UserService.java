package uh2.fstm.ilisi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uh2.fstm.ilisi.Model.BO.Client;
import uh2.fstm.ilisi.Model.BO.Livreur;
import uh2.fstm.ilisi.Model.BO.Utilisateur;
import uh2.fstm.ilisi.Model.DAO.ClientDAO;
import uh2.fstm.ilisi.Model.DAO.LivreurDAO;
import uh2.fstm.ilisi.Model.DAO.UtilisateurDAO;
import uh2.fstm.ilisi.exception.CustomException;
import uh2.fstm.ilisi.security.JwtTokenProvider;

import javax.servlet.http.HttpServletRequest;

@Service
@Transactional
public class UserService {
	@Autowired
	private ClientDAO clientDAO;

	@Autowired
	private LivreurDAO livreurDAO;

	@Autowired
	private UtilisateurDAO utilisateurDAO;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getPrincipal() + "";
		String password = authentication.getCredentials() + "";

		Utilisateur user = utilisateurDAO.findByemail(username);
		if (user == null || !passwordEncoder.matches(password,user.getPassword())) {
			throw new BadCredentialsException("1000");
		}

		return new UsernamePasswordAuthenticationToken(username,password);
	}

	public String signin(Object obj, int type) {
		try {
			switch(type) {

				case 1:
						Utilisateur client=(Utilisateur) obj;
						this.authenticate(new UsernamePasswordAuthenticationToken(client.getEmail(), client.getPassword()));
						return jwtTokenProvider.createToken(client.getEmail(), client.getPassword());
				case 2:
						Utilisateur livreur=(Utilisateur)obj;
						this.authenticate(new UsernamePasswordAuthenticationToken(livreur.getEmail(), livreur.getPassword()));
						return jwtTokenProvider.createToken(livreur.getEmail(), livreurDAO.findByemail(livreur.getEmail()).getPassword());
			}
		} catch (AuthenticationException e) {
			throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);

		}
		return null;
	}

	public Object signup(Object user, int type) {
		switch(type){
			case 1 :
				Client cli=(Client) user;
				if (!clientDAO.existsByemail(cli.getEmail())) {
					cli.setPassword(passwordEncoder.encode(cli.getPassword()));
					Client cl=clientDAO.save(cli);
					cl.setToken(jwtTokenProvider.createToken(cli.getEmail(), cli.getPassword()));
					return cl;
				} else {
					throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
				}

			case 2:
				Livreur liv= (Livreur) user;
				if (!livreurDAO.existsByemail(liv.getEmail())) {
					liv.setPassword(passwordEncoder.encode(liv.getPassword()));
					Livreur livr=livreurDAO.save(liv);
					livr.setToken(jwtTokenProvider.createToken(liv.getEmail(), liv.getPassword()));
					return livr;
				} else {
					throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
				}

		}
		return null;
	}

	/*public void delete(String username) {
		userRepository.deleteByUsername(username);
	}

	public User search(String username) {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new CustomException("The user doesn't exist", HttpStatus.NOT_FOUND);
		}
		return user;
	}
*/
	public Utilisateur whoami(HttpServletRequest req) {
		return utilisateurDAO.findByemail(jwtTokenProvider.getemail(jwtTokenProvider.resolveToken(req)));
	}
}
