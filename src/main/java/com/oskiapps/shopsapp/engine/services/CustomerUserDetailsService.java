package com.oskiapps.shopsapp.engine.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.oskiapps.shopsapp.engine.consts.RolesConsts;
import com.oskiapps.shopsapp.model.entities.CustomerAccount;
import com.oskiapps.shopsapp.repository.CustomerAccountRepository;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

	@Autowired
	private CustomerAccountRepository customerAccountRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<GrantedAuthority> role = AuthorityUtils.createAuthorityList(RolesConsts.ROLE_CUSTOMER);
		CustomerAccount customerAccount = customerAccountRepository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
		return new User(customerAccount.getEmail(), customerAccount.getPasswordHash(), role);
	}

}
