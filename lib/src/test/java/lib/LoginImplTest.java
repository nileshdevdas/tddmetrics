package lib;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.mockito.Mockito;

@Testable
public class LoginImplTest {

	private ILogin login;
	private IUserService userService;

	@BeforeEach
	public void before() {
		// Creaste the mock
	}

	@DisplayName("Returns Exception if Username/Password is Wrong ....")
	@Test
	void testLoginBadCredentials() {
		this.userService = Mockito.mock(IUserService.class);
		// pass the mock
		this.login = new LoginImpl(userService);
		String username = "nilesh";
		User user = new User();
		user.setUsername(username);
		Mockito.when(userService.findUserByUserName(username)).thenThrow(LoginException.class);
		assertThrows(LoginException.class, () -> {
			this.login.login("nilesh", "badpassword");
		});
	}

	@DisplayName("Return void no Exception if credentials are good....")
	@Test
	void testLoginGoodCredentials() throws Exception {
		this.userService = Mockito.mock(IUserService.class);
		this.login = new LoginImpl(userService);
		String username = "nilesh";
		User user = new User();
		user.setUsername(username);
		Mockito.when(userService.findUserByUserName(username)).thenReturn(user);
		this.login.login("nilesh", "goodpassword");
	}

}
