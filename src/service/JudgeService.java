package service;

import entity.case_file;
import entity.cr_file;
import entity.users;
import java.util.List;

public interface JudgeService {
    
    public List<String> GetJudges();
    public List<case_file> getCasefiles(int id);
    public List<cr_file> creatCrfiles(int investigator_id,int casefile_id,String defendant_name,
                                       String crime_name,String dateof_crime,String date_filed_on,
                                       String dateof_imprisonment,String sentence);
    public List<cr_file> listallcr_files();
}
