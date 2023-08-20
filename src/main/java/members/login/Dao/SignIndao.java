package members.login.Dao;

public interface SignIndao {
	
	
	List<SignIn> fetchAllSignIn();
	
	
	SignIn createsignIn(int date, int studentNumber, String studentName, String descripton);
 
	
	SignIn updateSignIn(int date, int studentNumber, String studentName, String descripton);
	
	void deleteSignIn(int signInID);
	
}
