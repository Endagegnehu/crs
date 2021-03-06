package service;

import entity.address;
import entity.job;
import entity.users;
import java.util.List;
import org.springframework.ui.Model;

public interface ProfileService {
    
    public List<users> getUser(int userid);
    public List<address> getAddress(int userid);
    public List<job> getJob(int userid);
    public String UpdateProfile(String user_name,String first_name,String last_name,String email,String password,String region,String woreda,String keble,String home_number,String phon,String name,int idusers,int idaddress,int idjob,Model model);
}
