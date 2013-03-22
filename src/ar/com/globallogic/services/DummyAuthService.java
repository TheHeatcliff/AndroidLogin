package ar.com.globallogic.services;

public class DummyAuthService implements IAuthenticationService {

	public void doLogin(String userName, String password) throws Exception {
		if ((!userName.equals("niko")) && (!password.equals("1234"))){
			throw new Exception("Invalid credentials");
		}

	}

}
