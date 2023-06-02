package com.cabse.cet.utils;

import java.util.*;

class Choice {
    String choice;
    Integer index;
}

class Question {
     String typeName;
     String title;
     Double score;
     Integer id;
     Integer type;
     List<Choice> choices;

     Question(){choices = new ArrayList<>();}
}

public class PaperInfo {
    public List<Question> questionList;

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public PaperInfo() {questionList = new ArrayList<>();}

    public void getInfoFromPaper(Paper p){
        Integer id = 1;
        Question writing = new Question();
        writing.typeName = "Writing";
        writing.title = p.writing;
        writing.score = 106.5;
        writing.id = id++;
        writing.type = 4;
        questionList.add(writing);
        for (int i=0; i<25; i++) {
            Question listening = new Question();
            listening.typeName = "Listening";
            listening.id = id++;
            listening.type = 1;
            if (i<15) {
                listening.score = 7.1;
            }
            else {
                listening.score = 14.2;
            }
            for (int j=0; j<4; j++) {
                Choice c = new Choice();
                c.choice = p.listeningChoices[i*4+j];
                c.index = j;
                listening.choices.add(c);
            }
            questionList.add(listening);
        }

        Question translation = new Question();
        translation.typeName = "Translation";
        translation.title = p.translation;
        translation.score = 106.5;
        translation.id = id++;
        translation.type = 4;
        questionList.add(translation);
    }
}
