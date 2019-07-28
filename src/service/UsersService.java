package service;

import entity.users;

public interface UsersService {
	public void saveNewUser(users users_new);

	public users getUser(int theID);

	public void saveNewUserUpdate(users users_form_page, int id_users);

	public void deleteUser(int current_user);
}
