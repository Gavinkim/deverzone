package com.deverzone.v01;

import com.deverzone.Application;
import com.deverzone.model.user.Role;
import com.deverzone.model.user.User;
import com.deverzone.repository.UserRepository;
import com.deverzone.security.auth.AnonAuthentication;
import com.deverzone.security.auth.TokenBasedAuthentication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.After;
import org.junit.Before;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@Ignore
@RunWith( SpringRunner.class )
@SpringBootTest(classes = { Application.class })
public abstract class AbstractTest {

	@Autowired
	protected UserRepository userRepository;

	@Autowired
	protected ObjectMapper objectMapper;

	@Before
	public final void beforeAbstractTest() {
		securityContext = Mockito.mock( SecurityContext.class );
		SecurityContextHolder.setContext( securityContext );
		Mockito.when( securityContext.getAuthentication() ).thenReturn( new AnonAuthentication() );
	}

	@After
	public final void afterAbstractTest() {
		SecurityContextHolder.clearContext();
	}

	protected SecurityContext securityContext;

	protected void mockAuthenticatedUser( User user ) {
		mockAuthentication( new TokenBasedAuthentication( user ) );
	}

	private void mockAuthentication( TokenBasedAuthentication auth ) {
		auth.setAuthenticated( true );
		Mockito.when( securityContext.getAuthentication() ).thenReturn( auth );
	}

    protected User buildTestAnonUser() {
        User user = new User();
        user.setUsername("user");
        return user;
    }

	protected User buildTestUser() {

		User user = new User();
		Role userRole = new Role();
		userRole.setName("ROLE_USER");
		List<Role> userAuthorities = new ArrayList<>();
		userAuthorities.add(userRole);
		user.setUsername("user");
		user.setAuthorities(userAuthorities);
		return user;
	}


    protected User buildTestAdmin() {
        Role userRole = new Role();
        Role adminRole = new Role();
        userRole.setName("ROLE_USER");
        adminRole.setName("ROLE_ADMIN");
        List<Role> adminAuthorities = new ArrayList<>();
        adminAuthorities.add(userRole);
        adminAuthorities.add(adminRole);
        User admin = new User();
        admin.setUsername("admin");
        admin.setAuthorities(adminAuthorities);
        return admin;
    }


}