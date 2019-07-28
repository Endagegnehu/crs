package dao;

import entity.users;

public interface UsersDao {

	public void saveUser(users users_new);

	public users getUser(int theID);

	public void update(users users_form_page, int theID);
	public void deleteUser(int theID);
}
