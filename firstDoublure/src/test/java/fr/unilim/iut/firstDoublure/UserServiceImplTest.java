package fr.unilim.iut.firstDoublure;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;



public class UserServiceImplTest {
	@Test
	public void should_create_user_with_hashed_password() {
		HashProvider hasha = mock(HashProvider.class);
		UserService userService = new UserServiceImpl(hasha);
		when(hasha.hash("secret")).thenReturn("secret2");
 	
		User user = userService.createUser("Bob", "secret");

 		assertEquals(user.firstName(), "Bob");
 		assertEquals(user.hashedPassword(), "secret2");
	}
}