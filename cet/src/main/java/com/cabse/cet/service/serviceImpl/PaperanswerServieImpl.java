package com.cabse.cet.service.serviceImpl;

import com.cabse.cet.dao.PaperanswerDao;
import com.cabse.cet.entity.Paperanswer;
import com.cabse.cet.service.PaperanswerService;
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
}
