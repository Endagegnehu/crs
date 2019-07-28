package service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UsersDao;
import entity.users;

@Service
public class UserServiceImp implements UsersService {
	
	@Autowired
	private UsersDao userDao;
	
	@Override
	@Transactional
	public void saveNewUser(users users_new) {
		
		userDao.saveUser(users_new);

	}

	@Override
	@Transactional
	public users getUser(int theID) {
		return userDao.getUser(theID);
	}

	@Override
	@Transactional
	public void saveNewUserUpdate(users users_form_page,int theID) {
		
		userDao.update(users_form_page,theID);
		
	}

	@Override
	@Transactional
	public void deleteUser(int current_user) {
		
		userDao.deleteUser(current_user);
		
	}

}
