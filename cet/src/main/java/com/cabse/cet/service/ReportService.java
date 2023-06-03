package com.cabse.cet.service;

public interface ReportService {
    boolean updateTranslationService(Integer paperid,Integer sid,Integer score);
    boolean updateWritingService(Integer paperid,Integer sid,Integer score);
}
