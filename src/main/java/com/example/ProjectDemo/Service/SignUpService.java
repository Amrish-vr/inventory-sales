package com.example.ProjectDemo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ProjectDemo.Model.Authorities;
import com.example.ProjectDemo.Model.SignUp;
import com.example.ProjectDemo.Model.Users;
import com.example.ProjectDemo.Repository.AuthoritiesRepository;
import com.example.ProjectDemo.Repository.SignUpRepository;
import com.example.ProjectDemo.Repository.UsersRepository;

@Service
public class SignUpService {
	
	@Autowired
	private SignUpRepository signUpRepo;
	@Autowired
	private UsersRepository usersRepo;
	@Autowired
	private AuthoritiesRepository authRepo;
	
	public void saveUsers (SignUp signup) {
		signUpRepo.save(signup);
		saveCredentails(signup);
	}
	
	private void saveCredentails (SignUp signup) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		Users user = new Users();
		user.setUsername(signup.getUserName());
		user.setPassword(passwordEncoder.encode(signup.getPassword()));
		user.setEnabled(true);
		usersRepo.save(user);
		saveAuthorities(signup);
	}
	
	private void saveAuthorities (SignUp signup) {
		Authorities authorities = new Authorities();
		authorities.setUsername(signup.getUserName());
		authorities.setAuthority("ROLE_USER");
		authRepo.save(authorities);
	}

}
