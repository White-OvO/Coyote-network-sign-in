package service;
import java.util.List;
import java.util.NoSuchElementException;

import lombok.extern.slf4j.Slf4j;
import members.login.Dao.SignInDao;
import members.login.entity.SignIn;


@Service
@Slf4j
public class DefaultSignInService implements SignInService{

	
	
	
	
	@Autowired
	private SignInDao signInDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<SignIn> fetchAllSignIn() { 
		List<SignIn> signIn = signInDao.fetchAllSignIn();
		if(signIn.isEmpty()) { 
			String msg = String.format("Add members");
			throw new NoSuchElementException(msg);
		}
		return signIn;
	}
	public SignIn createSignIn(int date, int studentNumber, String studentName, String description) {
		log.info("Creates members in Service");
		return signInDao.createSignIn(date,studentNumber,studentName,description);
		
	}

	@Override
	public SignIn updateSignIn(int signInId,int date, int studentNumber, String studentName, String description) {
		log.info("update signed in exisiting members in the service ");
		return SignInDao.updateSignIn(signInId,date, studentNumber,studentName, description);
	}

	@Override
	public void deleteSignIn(int signInId) {
		log.info("delete method was cast upon your request", signInId);
		
		signInDao.deleteSignIn(signInId);
	}

	
}

