package com.generation.LojaGames.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.generation.LojaGames.models.Usuario;
import com.generation.LojaGames.repositories.UsuarioRepository;

@Service
public class UserDetailsServiceImplements implements UserDetailsService {

	private @Autowired UsuarioRepository repository;
		@Override
		public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
			Optional<Usuario> user = repository.findByUsuario(userName);
			if (user.isPresent()) {
				return new UserDetailsImplements(user.get());
			} else {
				throw new UsernameNotFoundException(userName + " Não existe!");
			}


	}

}
