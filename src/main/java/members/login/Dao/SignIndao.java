package members.login.Dao;

import java.util.List;

import members.login.entity.SignIn;

public interface SignInDao {
	
	
	List<SignIn> fetchAllSignIn();
	
	
	SignIn createSignIn(int date, int studentNumber, String studentName, String descripton);
 
	
	SignIn updateSignIn(int signInId, SignIn updatedSignIn);
	
	void deleteSignIn(int signInId);









	
}
