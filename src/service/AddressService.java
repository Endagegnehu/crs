package service;

import entity.address;

public interface AddressService {
	public void saveNewAddress(address user_address);

	public address getUserAddres(int theID);
}
