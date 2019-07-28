package service;

import dao.JudgeDao;
import entity.case_file;
import entity.cr_file;
import entity.users;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JudgeServiceImpl implements JudgeService{

    @Autowired
    private JudgeDao judgeDao;
    
    @Override
    @Transactional
    public List<String> GetJudges() 
    {
     return judgeDao.GetJudges();
    }

    @Override
    @Transactional
    public List<case_file> getCasefiles(int id) 
    {
        return judgeDao.getcasefiles(id);
    }

    @Override
    @Transactional
    public List<cr_file> creatCrfiles(int investigator_id, int casefile_id, String defendant_name, String crime_name, String dateof_crime, String date_filed_on, String dateof_imprisonment, String sentence) 
    {
        return judgeDao.creatCrfiles(investigator_id, casefile_id, defendant_name, crime_name, dateof_crime, date_filed_on, dateof_imprisonment, sentence);
    }

    @Override
    @Transactional
    public List<cr_file> listallcr_files() 
    {
        return judgeDao.listallcrfiles();
    }
    
}
