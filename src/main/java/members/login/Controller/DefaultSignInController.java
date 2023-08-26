package members.login.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
///import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
//import members.login.Dao.DefaultSignInDao;
import members.login.entity.SignIn;
import service.SignInService;

@RestController
@Slf4j

public class DefaultSignInController implements SignInController{

	@Autowired
	
	private SignInService signInService;
	
	@Override
	
	public List<SignIn> fetchAllSignIn() {
			return signInService.fetchAllSignIn();
	}
	
	
	@Override
	public SignIn createSignIn(int date, int studentNumber, String studentName, String description) {
		return signInService.createSignIn(date, studentNumber, studentName, description);
		
		
		
} 
@Override
public SignIn updateSignIn(int signInId,SignIn updatedSignIn) {
	return signInService.updateSignIn(signInId, updatedSignIn);
	
	
	
	
}
@Override
public void deleteSignIn(int signInId) { 
		log.debug("signInId={}", signInId);
		signInService.deleteSignIn(signInId);
		
}
}
