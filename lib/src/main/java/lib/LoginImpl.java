package lib;

/**
 * this is the CUT (Class undertest)
 * 
 * @author niles
 *
 */
public class LoginImpl implements ILogin {

	/**
	 * this is the depenedency...... You are not supposed to test this
	 **/
	private IUserService userService;

	public LoginImpl(IUserService userService) {
		this.userService = userService;
	}

	@Override
	public void login(String username, String password) throws LoginException {
		var user = new User();
		user.setUsername(username);
		user.setPassword(password);
		var existingUser = userService.findUserByUserName(username);
		if (existingUser != null) {
			userService.validUser(user);
		} else {
			throw new LoginException();
		}
	}

}
