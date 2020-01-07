package com.cognizant.truyum;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.cognizant.truyum.exception.UserAlreadyExistsException;
import com.cognizant.truyum.model.Role;
import com.cognizant.truyum.model.Users;
import com.cognizant.truyum.repository.UserRepository;
import com.cognizant.truyum.security.AppUserDetailsService;
import com.cognizant.truyum.service.UserService;

@SpringBootTest
public class UserDetailsServiceMockTest {

	@Autowired
	UserRepository repository;

	@Autowired
	AppUserDetailsService appUserDetailsService;

	@Autowired
	UserService userService;
	
	@Test
	public void testLoadUserByUsername() {

		UserRepository repository = Mockito.mock(UserRepository.class);
		
		Mockito.when(repository.findByUserName("user")).thenReturn(createUser());
		UserDetails user = appUserDetailsService.loadUserByUsername("user");
		
		String expected = "$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK";
		assertEquals(expected, user.getPassword());
	}

	@Test
	public void testvoidsignup() {

		Users user = createUser();

		UserRepository repository = Mockito.mock(UserRepository.class);
		Mockito.when(repository.findByUserName(user.getUserName())).thenReturn(user);

		Set<Role> roleList = new HashSet<Role>();
		roleList.add(new Role(1, "USER"));
		user.setRoleList(roleList);
		Mockito.when(repository.save(user)).thenReturn(user);

		assertEquals("user", user.getUserName());
	}

	@Test
	public void testLoadByUserNameNotFoundException() throws UsernameNotFoundException {
		
		UserRepository repository = Mockito.mock(UserRepository.class);
		Mockito.when(repository.findByUserName("user")).thenReturn(null);
		
		if (appUserDetailsService.loadUserByUsername("user") == null) {
		    assertThrows(UsernameNotFoundException.class,()->appUserDetailsService.loadUserByUsername("user"));
		}
	}

	@Test
	public void testLoadByUserAlreadyExistsException() throws UserAlreadyExistsException {
		
		Users user = createUser();

		UserRepository repository = Mockito.mock(UserRepository.class);
		Mockito.when(repository.findByUserName(user.getUserName())).thenReturn(user);

		Set<Role> roleList = new HashSet<Role>();
		roleList.add(new Role(1, "USER"));
		user.setRoleList(roleList);
		
		Mockito.when(repository.save(user)).thenReturn(user);
		assertThrows(UserAlreadyExistsException.class,()->userService.signUp(user));
		
	}
	
	
	public Users createUser() {

		Set<Role> roleList = new HashSet<Role>();
		Users newUser = new Users();
		newUser.setId(1);
		newUser.setUserName("user");
		newUser.setFirstName("user");
		newUser.setLastName("user");
		newUser.setPassword("$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK");
		newUser.setRoleList(roleList);
		return newUser;
	}
 }


