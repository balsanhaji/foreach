package com.example.ecoleapi.service;

import com.example.ecoleapi.dto.User;
import com.example.ecoleapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	public UserDetails loadUserByUsername(String username) {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

		User user = userRepository.findByLogin(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(username);
		builder.password(encoder.encode(user.getMdp()));
		builder.roles(user.getRole());
		return builder.build();
	}

}