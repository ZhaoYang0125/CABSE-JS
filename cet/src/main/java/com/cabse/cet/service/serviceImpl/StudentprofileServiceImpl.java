package com.cabse.cet.service.serviceImpl;

import com.cabse.cet.dao.ReportDao;
import com.cabse.cet.dao.StudentanswerDao;
import com.cabse.cet.dao.StudentprofileDao;
import com.cabse.cet.dao.UserDao;
import com.cabse.cet.entity.Report;
import com.cabse.cet.entity.Studentanswer;
import com.cabse.cet.entity.Studentprofile;
import com.cabse.cet.entity.User;
import com.cabse.cet.service.StudentprofileService;
import com.cabse.cet.utils.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.cabse.cet.utils.IDGeneration.getGeneratedID;

@Service
public class StudentprofileServiceImpl implements StudentprofileService {
    @Autowired
    private StudentprofileDao studentprofileDao;
    @Resource
    private UserDao userDao;
    @Resource
    private ReportDao reportDao;
    @Resource
    private StudentanswerDao studentanswerDao;

    @Override
    public Studentprofile saveStudentprofile(Studentprofile studentprofile){
        Studentprofile newprofile;
        Studentprofile sp = studentprofileDao.findByUid(studentprofile.getUid());
        if (sp!=null){
            studentprofile.setExamid(sp.getExamid());
            newprofile = modifyStudentprofile(studentprofile);
            return newprofile;
        }else{
            if (studentprofileDao.findByExamid(studentprofile.getExamid()) != null){
                return null;
            }
            String pwd = Security.encodePassword(studentprofile.getExamid().toString());
            User newUser = new User(studentprofile.getSname(), pwd, 1);
            newUser = userDao.save(newUser);
            if (newUser == null){
                return null;
            }
            studentprofile.setUid(newUser.getUid());
            newprofile = studentprofileDao.save(studentprofile);
            return newprofile;
        }
    }

    @Override
    public Studentprofile modifyStudentprofile(Studentprofile studentprofile) {
        Studentprofile sp = studentprofileDao.findByUid(studentprofile.getUid());
        Integer originExamid = sp.getExamid();
        List<Report> reports = reportDao.findByExamid(originExamid);
        for (int i = 0; i < reports.size(); i++) {
            reportDao.updateExamid(reports.get(i).getReportid(), studentprofile.getExamid());
        }

        List<Studentanswer> studentanswers = studentanswerDao.findByExamid(originExamid);
        for (int i = 0; i < studentanswers.size(); i++) {
            studentanswerDao.modifyExamid(studentanswers.get(i).getAnswerid(), studentprofile.getExamid());
        }

        studentprofileDao.modifyProfile(studentprofile.getUid(),
                studentprofile.getSname(),
                studentprofile.getGender(),
                studentprofile.getAge(),
                studentprofile.getSchool(),
                studentprofile.getMajerity(),
                studentprofile.getEnrollmentyear(),
                studentprofile.getDegree(),
                studentprofile.getExamid()
        );
        Studentprofile newprofile = studentprofileDao.findByUid(studentprofile.getUid());


        return newprofile;
    }

    @Override
    public Studentprofile findStudentprofile(Integer uid) {
        return studentprofileDao.findByUid(uid);
    }

    @Override
    public Integer examidService(Integer uid) {
        Studentprofile studentprofile = studentprofileDao.findByUid(uid);
        if (studentprofile == null)
        {
            return null;
        }
        Integer examid = studentprofile.getExamid();
        return examid;
    }

    @Override
    public List<Studentprofile> getList(){
        return studentprofileDao.findAll();
    }

    @Override
    public void deleteService(Integer uid){
        Studentprofile studentprofile = studentprofileDao.findByUid(uid);
        reportDao.deleteByExamid(studentprofile.getExamid());
        studentanswerDao.deleteByExamid(studentprofile.getExamid());

        studentprofileDao.deleteByUid(uid);


    }

}
