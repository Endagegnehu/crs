package dao;

import java.util.List;

import entity.address;
import entity.criminal_profile;

public interface CriminalProfileDao {
    
    public String SaveSuspect(criminal_profile criminalprofile, address address);

	public void save(criminal_profile criminalprofile);
	
	public List<criminal_profile> getRegisteredSuspects();
}
