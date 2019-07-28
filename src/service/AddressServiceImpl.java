package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.Address;
import entity.address;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private Address userAddress;
	@Override
	@Transactional
	public void saveNewAddress(address user_address) {
		
		userAddress.saveAddres(user_address);

	}
	@Override
	@Transactional
	public address getUserAddres(int theID) {
		
		return userAddress.getUserAddres(theID);
	}
	

}
