package service;

import dao.StatisticsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StatisticsServiceImpl implements StatisticsService{

    @Autowired
    private StatisticsDao statisticsDao;
    
    @Override
    @Transactional
    public int NumberOfTheft() 
    {
        return statisticsDao.NumberOfTheft();
    }

    @Override
    @Transactional
    public int NumberOfRobbery() {
        return statisticsDao.NumberOfRobbery();
    }

    @Override
    @Transactional
    public int NumberOfAssault() {
        return statisticsDao.NumberOfAssault();
    }

    @Override
    @Transactional
    public int NumberOfAttemptedMurder() 
    {
        return statisticsDao.NumberOfAttemptedMurder();
    }

    @Override
    @Transactional
    public int NumberOfMurder() 
    {
        return statisticsDao.NumberOfMurder();
    }
    
}
