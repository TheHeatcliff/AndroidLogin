package ar.com.globallogic.services;

public interface IAuthenticationService {

	void doLogin(String user,String password) throws Exception;
}
