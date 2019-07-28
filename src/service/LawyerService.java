package service;

import entity.case_file;
import java.util.List;

public interface LawyerService {
    List<case_file> listCaasefile(int id);
}
