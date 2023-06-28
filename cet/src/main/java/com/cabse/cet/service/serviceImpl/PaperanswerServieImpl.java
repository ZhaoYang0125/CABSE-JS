package com.cabse.cet.service.serviceImpl;

import com.cabse.cet.dao.PaperanswerDao;
import com.cabse.cet.entity.Paperanswer;
import com.cabse.cet.service.PaperanswerService;
import com.cabse.cet.utils.Answer;
import com.cabse.cet.utils.CurrentDate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaperanswerServieImpl implements PaperanswerService {
    @Resource
    private PaperanswerDao paperanswerDao;

    @Override
    public Paperanswer searchAnswerService(Integer paperid) {
        Paperanswer paperanswer = paperanswerDao.findByPaperid(paperid);
        return paperanswer;
    }

    @Override
    public Paperanswer saveAnswerService(Paperanswer a) {
        Paperanswer paperanswer = paperanswerDao.findByPaperid(Integer.parseInt(CurrentDate.getTestDate()));
        if (paperanswer != null){
            return null;
        }else{
            Paperanswer newPaperans = paperanswerDao.save(a);
            return newPaperans;
        }
    }
}
