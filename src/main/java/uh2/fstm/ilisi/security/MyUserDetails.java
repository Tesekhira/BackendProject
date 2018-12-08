package uh2.fstm.ilisi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uh2.fstm.ilisi.Model.BO.Utilisateur;
import uh2.fstm.ilisi.Model.DAO.UtilisateurDAO;

@Service
public class MyUserDetails implements UserDetailsService {
	@Autowired
	private UtilisateurDAO userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		final Utilisateur user = userRepository.findByemail(email);

		if (user == null) {
			throw new UsernameNotFoundException("User '" + email + "' not found");
		}

		return org.springframework.security.core.userdetails.User//
				.withUsername(email)//
				.password(user.getPassword())//
				.accountExpired(false)//
				.accountLocked(false)//
				.credentialsExpired(false)//
				.disabled(false)//
				.build();
	}
}
