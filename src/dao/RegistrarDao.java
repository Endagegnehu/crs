package dao;

import entity.case_file;
import java.util.List;

public interface RegistrarDao {
    
    public List<case_file> listCaseFile(int id);
    public void ApprovecaseFile(String name,int id);
}
