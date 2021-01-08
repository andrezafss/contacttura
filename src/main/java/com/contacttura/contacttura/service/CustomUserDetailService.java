package com.contacttura.contacttura.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.contacttura.contacttura.model.ContactturaUser;
import com.contacttura.contacttura.repository.ContactturaRepositoryUser;

@Component
public class CustomUserDetailService implements UserDetailsService {
	
	//metodo do spring que retorna um userDetail, buscando o user atraves do repositorio, recebendo a instancia do repositorio do user local
	private final ContactturaRepositoryUser contactturaRepositoryUser;
	
	@Autowired
	public CustomUserDetailService(ContactturaRepositoryUser contactturaRepositoryUser) {
		this.contactturaRepositoryUser = contactturaRepositoryUser;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		ContactturaUser user = Optional.ofNullable(contactturaRepositoryUser.findByUsername(username))
				.orElseThrow(()-> new UsernameNotFoundException("Usuario nao encontrado"));
	
		//lista que retorna as autorizaçoes e permissoes para cada tipo de usuario
		List<GrantedAuthority> authorityAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
		List<GrantedAuthority> authorityUser = AuthorityUtils.createAuthorityList("ROLE_USER");
		
		
		//inserindo os dados do meu model de usuario diretamente dentro do model de usuario do springSecurity, e validando as permissoes ou user
		return new org.springframework.security.core.userdetails.User
				(user.getUsername(), user.getPassword(), user.getAdmin() ?  authorityAdmin : authorityUser);
	}
	

}
