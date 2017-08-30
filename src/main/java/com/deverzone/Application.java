package com.deverzone;

import com.deverzone.dto.UserDTO;
import com.deverzone.model.user.Role;
import com.deverzone.model.user.User;
import com.deverzone.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	public void createUser() throws Exception{
		List<User> userList = new ArrayList<>();

		User userAdmin = new User();
		userAdmin.setEmail("admin");
		userAdmin.setName("admin");
		userAdmin.setPassword(new BCryptPasswordEncoder().encode("123"));
		userAdmin.setEmail("admin@deverzone.com");
		userAdmin.setPhone("010-1234-5678");
		userAdmin.setUsername("admin");
		List<Role> rolesAdmins = new ArrayList<>();
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		rolesAdmins.add(roleAdmin);
		userAdmin.setAuthorities(rolesAdmins);

		User user = new User();
		user.setEmail("user");
		user.setName("user");
		user.setPassword(new BCryptPasswordEncoder().encode("123"));
		user.setEmail("user@deverzone.com");
		user.setPhone("010-1234-5678");
		user.setUsername("user");
		List<Role> roleUsers = new ArrayList<>();
		Role roleUser= new Role();
		roleUser.setName("ROLE_USER");
		roleUsers.add(roleUser);
		user.setAuthorities(roleUsers);

		userList.add(userAdmin);
		userList.add(user);
		if(userService.deleteAll()){
			userService.createUserList(userList);
		}

	}
}


