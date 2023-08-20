package members.login.Controller;

import java.util.List;

import members.login.entity.SignIn;
import service.SignInService;

@RestController
@Sl4j

public class DefaultSignInController implements SignInController{

	@Autowired
	
	private SignInService sinInService;
	
	@Override
	
	public List<SignIn> fetchAllSignIn() {
			return signInService.fetchAllSignIn();
	}
	
	
	@Override
	public SignIn createSignIn(int date, int studentNumber, String studentName, String description);
		return signInService.createSignIn(int date, int studentNumber, String studentName, String description);
		
		
		
} 
@Override
public SignIn updateSignIn(int date, int studentNumber, String studentName, String descripton);
	return signInService.updateSignIn(int date, int studentNumber, String studentName, String descripton);
	
	
	
	
}
@Override
public void deleteSignIn(int signInId) { 
		log.debug("signInId={}", signInId);
		signInService.deleteSignIn(signInId);
		
}
}
