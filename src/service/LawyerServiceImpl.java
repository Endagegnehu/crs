package service;

import dao.LawyerDao;
import entity.case_file;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LawyerServiceImpl implements LawyerService{

    @Autowired
    private LawyerDao lawyerDao;
    
    @Override
    @Transactional
    public List<case_file> listCaasefile(int id) 
    {
        return lawyerDao.listCasefile(id);
    }
    
}
