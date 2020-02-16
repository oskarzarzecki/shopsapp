package com.oskiapps.shopsapp.controllers;

import java.util.Date;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oskiapps.shopsapp.engine.services.CustomerAccountEmailService;
import com.oskiapps.shopsapp.engine.utils.JwtTokenUtil;
import com.oskiapps.shopsapp.model.auxiliaries.AuthenticationRequest;
import com.oskiapps.shopsapp.model.auxiliaries.AuthenticationResponse;
import com.oskiapps.shopsapp.model.entities.CustomerAccount;
import com.oskiapps.shopsapp.repository.CustomerAccountRepository;

@RestController
@RequestMapping("/customer-auth")
public class CustomerAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private CustomerAccountRepository customerAccountRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	CustomerAccountEmailService customerAccountEmailService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		Objects.requireNonNull(authenticationRequest.getUsername());
		Objects.requireNonNull(authenticationRequest.getPassword());

		final Authentication auth = this.authenticate(authenticationRequest.getUsername(),
				authenticationRequest.getPassword());
//		auth.getAuthorities().add(new SimpleGrantedAuthority(""));
		final String token = jwtTokenUtil.generateToken(auth);

		SecurityContextHolder.getContext().setAuthentication(auth);

		CustomerAccount customerAccount = customerAccountRepository.findByEmail(authenticationRequest.getUsername())
				.orElseThrow(() -> new UsernameNotFoundException(
						"User not found with username: " + authenticationRequest.getUsername()));
		customerAccount.setLastVisit(new Date());
		customerAccountRepository.save(customerAccount);

		return ResponseEntity.ok(new AuthenticationResponse(authenticationRequest.getUsername(), token));
	}

	private Authentication authenticate(String username, String password) throws Exception {
		try {
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

	@RequestMapping(value = "/authorize", method = RequestMethod.POST)
	public ResponseEntity<Boolean> authorize() throws Exception {
		return ResponseEntity.ok(true);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ResponseEntity<AuthenticationResponse> logout() throws Exception {
		return ResponseEntity.ok(new AuthenticationResponse("", ""));
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<Boolean> register(@RequestBody AuthenticationRequest registerRequest) throws Exception {
		CustomerAccount ca = new CustomerAccount();
		Date now = new Date();
		ca.setEmail(registerRequest.getUsername());
		if (!this.validatePassword(registerRequest.getPassword())) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		ca.setPasswordHash(passwordEncoder.encode(registerRequest.getPassword()));
		ca.setDateFrom(now);
		ca.setLastVisit(now);
		ca.setOnline(0);
		ca.setActive(1);
		ca.setDeleted(0);
		customerAccountRepository.save(ca);
		customerAccountEmailService.sendRegistrationMessage(registerRequest.getUsername());
		return ResponseEntity.ok(true);
	}

	private boolean validatePassword(String password) {
		if (password == null || password.equals(""))
			return false;
		if (password.length() < 8 || password.length() > 200)
			return false;
		return true;
	}

	@RequestMapping(value = "/validate-unique-email", method = RequestMethod.POST)
	public ResponseEntity<Boolean> validateUniqueEmail(@RequestBody String email) throws Exception {
		return ResponseEntity.ok(customerAccountRepository.existsByEmail(email));
	}

	@RequestMapping(value = "/encode", method = RequestMethod.POST)
	public ResponseEntity<String> encode(@RequestParam String text) throws Exception {
		BCryptPasswordEncoder e = new BCryptPasswordEncoder();
		return ResponseEntity.ok(e.encode(text));
	}

}
