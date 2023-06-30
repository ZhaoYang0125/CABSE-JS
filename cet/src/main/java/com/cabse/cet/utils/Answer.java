package com.cabse.cet.utils;
/*
 * Created with IntelliJ IDEA.
 * ClassName: Answer
 * User: 张朝阳
 * Date: 2023/6/2
 * Time: 18:29
 * Description:答案类
 */

import java.io.*;
import java.util.Arrays;

public class Answer implements Serializable {
    private static final long serialVersionUID = 8069639368820181233L;
    Integer examid;
    String writing;//写作
    char listenning[];//25 听力
    char reading[];//30 阅读
    String translation;//翻译

    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
    }

    public Answer() {
        this.writing = "考生未作答";
        this.translation = "考生未作答";
    }

    public Answer(Integer examid, String writing, char[] listenning, char[] reading, String translation) {
        this.examid = examid;
        this.writing = writing;
        this.listenning = listenning;
        this.reading = reading;
        this.translation = translation;
    }

    public Answer(String writing, char[] listenning, char[] reading, String translation) {
        this.writing = writing;
        this.listenning = listenning;
        this.reading = reading;
        this.translation = translation;
    }


    public String getWriting() {
        return writing;
    }

    public void setWriting(String writing) {
        this.writing = writing;
    }

    public char[] getListenning() {
        return listenning;
    }

    public void setListenning(char[] listenning) {
        this.listenning = listenning;
    }

    public char[] getReading() {
        return reading;
    }

    public void setReading(char[] reading) {
        this.reading = reading;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "examid=" + examid +
                ", writing='" + writing + '\'' +
                ", listenning=" + Arrays.toString(listenning) +
                ", reading=" + Arrays.toString(reading) +
                ", translation='" + translation + '\'' +
                '}';
    }

    //从文件中获取答案
    public static Answer get(String path){
        try {
            Answer a=null;
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            a = (Answer) in.readObject();
            in.close();
            fileIn.close();
            return a;
        }catch (IOException i)
        {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    //保存答案到文件中
    public static String save(Answer a,String name) {
        try {
            String path = "./tmp/" + name;
            FileOutputStream fileOut =
                    new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(a);
            out.close();
            fileOut.close();
            return path;
        }catch (IOException i)
        {
            i.printStackTrace();
            return null;
        }
    }

    public static void testSerAns() throws IOException {
        Answer a=new Answer();
        a.writing=
                "who has engaged in production of spice bean jam for more than 30 years and their products are trusted by almost all Chinese people. "+
                "The only secret of her success is to take the social responsibility and repay society when pursuing interests. "+
                "If she only pursued short-term interests and turned a blind eye to her responsibility, she would not establish her business empire.\n" +
                "　　To sum up, having a sense of social responsibility is so valuable to our life that everyone should know its importance and be a man with strong social responsibility.";
        a.listenning=new char[]{'A','B','C','D','A','B','C','D','A','B','C','D','A','B','C','D',
                'A','B','C','D','A','B','C','D','A'};
        a.reading=new char[]{'A','B','C','D','A','B','C','D','A','B','C','D','A','B','C','D',
                'A','B','C','D','A','B','C','D','A','B','C','D','A','B','C','D','A','B','C','D',
                'A','B','C','D'};
        a.translation="The peony, with its rich color and elegant image, symbolizes peace and prosperity,"+
                "making it known as the \"king of flowers\" in China. "+
                "Peony is cultivated in many parts of China. For thousands of years, "+
                "many poems and paintings have been created in praise of peony."+
                " During the tang dynasty, peony was widely planted in the imperial gardens and known as the national flower,"+
                " so it was very popular. In the 10th century, the ancient city of Luoyang became a center for peony cultivation,"+
                " a position it has maintained to this day."+
                " Now, thousands of tourists from home and abroad flock to Luoyang for the annual peony festival to"+
                " enjoy the unique beauty of the peony and explore the history of the ancient capital of nine dynasties.";
//        a.setReading();
        save(a,"answer_0_1.ser");
        System.out.println("Serialized Answer...");
    }

    public static void testDeserAnser() throws IOException, ClassNotFoundException {
        Answer a= get("./tmp/answer_0_1.ser");
        System.out.println("Deserialized Answer...");
//        System.out.print(a);
    }
}
