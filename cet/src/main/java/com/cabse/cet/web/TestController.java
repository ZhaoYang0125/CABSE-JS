package com.cabse.cet.web;

import com.cabse.cet.entity.Testpaper;
import com.cabse.cet.service.TestpaperService;
import com.cabse.cet.utils.Paper;

import com.cabse.cet.utils.PaperInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private TestpaperService testpaperService;

    @GetMapping("/paper")
    public PaperInfo paperController() {
        Integer count = testpaperService.countService();
        Random rand = new Random();
        Integer row = rand.nextInt(count);
        PaperInfo info = testpaperService.testService(row);
        return info;
    }
}
