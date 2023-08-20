package service;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class DefaultSignInService implements SignInService{

	
	
	
	
	@Autowired
	private SignInyDao signInDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<SignIn> fetchAllInventorySignIn() { 
		List<SignIn> signIn = signInDao.fetchAllSignIn();
		if(signIn.isEmpty()) { 
			String msg = String.format("Add members");
			throw new NoSuchElementException(msg);
		}
		return signIn;
	}
	public SignIn createSignIn(int date, int studentNumber, String studentName, String description) {
		log.info("Creates members in Service");
		return SignInDao.createSignIn(date,studentNumber,studentName,description);
		
	}

	@Override
	public SignIn updateInventory(int signInId,int date, int studentNumber, String StudentName, String descripton) {
		log.info("update signed in exisiting members in the service ");
		return signInDao.updateSignIn(date,signInId, studentName,studentNumber,description);
	}

	@Override
	public void deleteSignIn(int signInId) {
		log.info("delete method was cast upon your request", signInId);
		
		signInDao.deleteSignIn(signInId);
	}

	
}

