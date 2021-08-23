package lib;

public interface IUserService {
	User findUserByUserName(String username);

	void validUser(User user);
}
