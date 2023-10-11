package members.service;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import members.dao.SignInDao;
import members.entity.SignIn;


@Service
@Slf4j
public class DefaultSignInService implements SignInService{

	
	
	
	
	@Autowired
	private SignInDao signInDao;
	
	//@Transactional(readOnly = true)
	@Override
	public List<SignIn> fetchAllSignIn() { 
		List<SignIn> signIn = signInDao.fetchAllSignIn();
		if(signIn.isEmpty()) { 
			String msg = String.format("Add members");
			throw new NoSuchElementException(msg);
		}
		return signIn;
	}
	
	@Override
	public SignIn createSignIn(int date, int studentNumber, String studentName, String description) {
		log.info("Creates members in Service");
		return signInDao.createSignIn(date,studentNumber,studentName,description);
		
	}

	@Override
	public SignIn updateSignIn(int signInId, SignIn updatedSignIn) {
		log.info("update signed in exisiting members in the service ");
		return signInDao.updateSignIn(signInId,updatedSignIn);
	}

	@Override
	public void deleteSignIn(int signInId) {
		log.info("delete method was cast upon your request", signInId);
		
		signInDao.deleteSignIn(signInId);
	}

	
}

