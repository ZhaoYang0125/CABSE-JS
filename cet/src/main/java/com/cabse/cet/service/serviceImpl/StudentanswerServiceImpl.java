package com.cabse.cet.service.serviceImpl;
/*
 * Created with IntelliJ IDEA.
 * ClassName: StudentanswerServiceImpl
 * User: 张朝阳
 * Date: 2023/6/3
 * Time: 14:21
 * Description:学生答案服务层函数实现
 */

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
    public Studentanswer saveService(Studentanswer sa){
        Studentanswer newAnswer = studentanswerDao.save(sa);
        return newAnswer;
    }

    @Override
    public Studentanswer searchAnswerService(Integer paperid, Integer sid) {
        Studentanswer studentanswer=studentanswerDao.findByPaperidAndSid(paperid,sid);
        return studentanswer;
    }
}
