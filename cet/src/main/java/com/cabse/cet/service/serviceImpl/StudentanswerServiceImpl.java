package com.cabse.cet.service.serviceImpl;

import com.cabse.cet.dao.StudentanswerDao;
import com.cabse.cet.entity.Studentanswer;
import com.cabse.cet.service.StudentanswerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentanswerServiceImpl implements StudentanswerService{
    @Resource
    private StudentanswerDao studentanswerDao;

    @Override
    public Studentanswer searchAnswerService(Integer paperid, Integer sid) {
        Studentanswer studentanswer=studentanswerDao.findByPaperidAndSid(paperid,sid);
        return studentanswer;
    }
}
