package com.cabse.cet.web;

import com.cabse.cet.entity.Testpaper;
import com.cabse.cet.service.TestpaperService;
import com.cabse.cet.utils.Paper;
import com.cabse.cet.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName: PaperController
 * @PackageName:com.cabse.cet.web
 * @Description: TODO
 * @Author cd
 * @Date 2023/5/31 20:22
 * @Version 1.0.0
 */

@RestController
@RequestMapping("/paper")
public class PaperController {
    @Autowired
    private TestpaperService paperServive;

    @PostMapping("/save")
    public Result<Paper> saveController(@RequestParam("writing") String writing,
                                        @RequestParam("listeningChoices") String[] listeningChoices,
                                        @RequestParam("sectionA") String sectionA,
                                        @RequestParam("choicesOfSectionA") String[] choicesOfSectionA,
                                        @RequestParam("sectionB") String sectionB,
                                        @RequestParam("statementsOfSectionB") String[] statementsOfSectionB,
                                        @RequestParam("paragraphsOfSectionB") String[] paragraphsOfSectionB,
                                        @RequestParam("PassagesOfSectionC") String[] PassagesOfSectionC,
                                        @RequestParam("questionsOfSectionC") String[] questionsOfSectionC,
                                        @RequestParam("choicesOfSectionC") String[] choicesOfSectionC,
                                        @RequestParam("translation") String translation
                                        ){
        Paper p = new Paper(writing, listeningChoices, sectionA, choicesOfSectionA,
                sectionB, statementsOfSectionB, paragraphsOfSectionB, PassagesOfSectionC,
                questionsOfSectionC, choicesOfSectionC, translation);
        String url = Paper.save(p, "test.ser");
        Testpaper tp = new Testpaper();
        tp.setUrl(url);
        Testpaper newPaper = paperServive.saveService(tp);
        if(newPaper!=null){
            System.out.println(newPaper);
            return Result.success(p, "Success save paper!");
        }
        else{
            return Result.error("999","Fail. save paper failed!");
        }
    }
}
