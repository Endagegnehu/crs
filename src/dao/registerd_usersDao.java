package dao;

import java.util.List;

import entity.address;
import entity.users;

public interface registerd_usersDao {
	public List<users> getRegisterdUsers();

	public List<address> getRegisterdUsersAddres();

	public int getRegisterdUsersID(int theID);
}
