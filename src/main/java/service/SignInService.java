package service;

import java.util.List;

import members.login.entity.SignIn;


public interface SignInService {

	
	
	public List<SignIn> fetchAllSignIn() ;
	
	void deleteSignIn(int signInId);
	
	SignIn createSignIn(int date, int studentNumber,
			String StudentName, String description);

	
	SignIn updateSignIn(int signInId, int date, int studentNumber, String studentName,
			String description);

	
}