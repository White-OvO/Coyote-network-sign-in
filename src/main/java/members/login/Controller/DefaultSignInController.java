package members.login.Controller;


@RestController
@Sl4j

public class DefaultSignInController implements SignInController{

	@Autowired
	
	private SignInService sinInService;
	
	@Override
	
	public List<SignIn> fetchAllSignIns() {
			return signInService.fetchAllSignIn();
	}
	
	
	@Override
	public SignIn createSignIn(int date, int studentNumber, String studentName, String descripton);
		return signInService.createSignIn(int date, int studentNumber, String studentName, String descripton);
		
		
		
} 
@Override
public SignIn updateInventory(int date, int studentNumber, String studentName, String descripton);
	return signInService.updateSignIn(int date, int studentNumber, String studentName, String descripton);
	
	
	
	
}
@Override
public void deleteSignIn(int studentNumber) { 
		log.debug("studentNumber={}", studentNumber);
		signInService.deleteSignIn(signInId);
		
}
}
