package com.cabse.cet.web;

import com.cabse.cet.entity.Paperanswer;
import com.cabse.cet.service.PaperanswerService;
import com.cabse.cet.utils.Answer;
import com.cabse.cet.utils.CurrentDate;
import com.cabse.cet.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/answer")
public class PaperAnswerController {
    @Autowired
    private PaperanswerService paperanswerService;

    @PostMapping("/save")
    public Result<Paperanswer> submitController(@RequestParam("writing") String writing,
                                           @RequestParam("listening") String[] listening,
                                           @RequestParam("reading") String[] reading,
                                           @RequestParam("translation") String translation
    ) {
        char[] l = new char[listening.length];
        char[] r = new char[reading.length];
        for (int i=0; i<listening.length; i++) {
            l[i] = listening[i].charAt(0);
        }
        for (int i=0; i<reading.length; i++) {
            r[i] = reading[i].charAt(0);
        }
        Answer a = new Answer(writing, l, r, translation);
        String date = CurrentDate.getTestDate();
        String url = Answer.save(a, "paperAns_"+date+".ser");
        Paperanswer pa = new Paperanswer();
        pa.setUrl(url);
        pa.setPaperid(Integer.parseInt(CurrentDate.getTestDate()));
        Paperanswer npa = paperanswerService.saveAnswerService(pa);
        if(npa!=null){
            System.out.println(npa);
            return Result.success(npa, "Success save answer!");
        }
        else{
            return Result.error("888","Fail. save paper failed!");
        }
    }
}
