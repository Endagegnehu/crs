package dao;

import java.util.List;

import entity.job;

public interface JobDao {

	void saveJob(job user_job);

	List<job> getofficer();

}
