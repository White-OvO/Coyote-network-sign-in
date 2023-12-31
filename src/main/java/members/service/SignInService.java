package members.service;

import java.util.List;

import members.entity.SignIn;


public interface SignInService {

	
	
	public List<SignIn> fetchAllSignIn() ;
	
	void deleteSignIn(int signInId);
	
	SignIn createSignIn(int date, int studentNumber,
			String StudentName, String description);

	
//	SignIn updateSignIn(int signInId, int date, int studentNumber, String studentName,
//			String description);

	SignIn updateSignIn(int signInId, SignIn updatedSignIn);

	
}