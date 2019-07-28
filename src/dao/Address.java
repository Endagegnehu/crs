package dao;

import entity.address;

public interface Address {
	
	public void saveAddres(address address_user);

	public address getUserAddres(int theID);

	public void saveAddresUpdate(address address_user, int id_address);
}
