package dao;

import entity.case_file;
import java.util.List;

public interface LawyerDao {
    List<case_file> listCasefile(int id);
}
