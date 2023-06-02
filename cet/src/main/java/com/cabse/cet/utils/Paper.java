package com.cabse.cet.utils;

import java.io.*;
import java.util.Arrays;


class Reading implements Serializable{
    String sectionA;
    String choicesOfSectionA[]; // 15
    String sectionB;
    String paragraphsOfSectionB[]; // 10
    String statementsOfSectionB[]; // 10
    String PassagesOfSectionC[]; // 2
    String questionsOfSectionC[]; // 10
    String choicesOfSectionC[]; // 40

    @Override
    public String toString() {
        return "Reading{" +
                "sectionA='" + sectionA + '\'' +
                ", choicesOfSectionA=" + Arrays.toString(choicesOfSectionA) +
                ", sectionB='" + sectionB + '\'' +
                ", paragraphsOfSectionB=" + Arrays.toString(paragraphsOfSectionB) +
                ", statementsOfSectionB=" + Arrays.toString(statementsOfSectionB) +
                ", PassagesOfSectionC=" + Arrays.toString(PassagesOfSectionC) +
                ", questionsOfSectionC=" + Arrays.toString(questionsOfSectionC) +
                ", choicesOfSectionC=" + Arrays.toString(choicesOfSectionC) +
                '}';
    }
}

public class Paper implements Serializable {
    String writing;
    String listeningChoices[]; // [100]: [25][4]
    Reading reading;
    String translation;

    public Paper() {
        reading = new Reading();
    }

    @Override
    public String toString() {
        return "Paper{" +
                "writing='" + writing + '\'' +
                ", listeningChoices=" + Arrays.toString(listeningChoices) +
                ", reading=" + reading +
                ", translation='" + translation + '\'' +
                '}';
    }

    public static Paper get(String path){
        Paper p = null;
        try
        {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            p = (Paper) in.readObject();
            in.close();
            fileIn.close();
            return p;
        }catch(IOException i)
        {
            i.printStackTrace();
            return null;
        }catch(ClassNotFoundException c)
        {
            System.out.println("Paper class not found");
            c.printStackTrace();
            return null;
        }
    }

    public static void save(Paper p, String name){
        try
        {
            FileOutputStream fileOut =
                    new FileOutputStream("./tmp/" + name);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(p);
            out.close();
            fileOut.close();
        }catch(IOException i)
        {
            i.printStackTrace();
        }
    }

    public static void testSer(){
        Paper p = new Paper();
        p.writing = "For this part, you are allowed 30 minutes to write an essay on the importance of having a sense of social responsibility. You should write at least 150 words but no more than 200 words";

        p.listeningChoices = new String[]{"Magazine reporter", "Fashion designer", "Website designer", "Features editor"};
//        {{"Magazine reporter", "Fashion designer", "Website designer", "Features editor"},
//                {"Magazine reporter", "Fashion designer", "Website designer", "Features editor"}};

        p.reading.sectionA = "When considering risk factors associated with serious chronic diseases, we often think about health indicators such as cholesterol, blood pressure, and body weight. " +
                "But poor diet and physical inactivity also each increase the risk of heart disease and have a role to play in the development of some cancers. Perhaps worse, the __26__ effects of an unhealthy diet and insufficient exercise are not limited to your body. " +
                "Recent research has also shown that __27__ in a high-fat and high-sugar diet may have negative effects on your brain, causing learning and memory __28__. " +
                "Studies have found obesity is associated with impairments in cognitive functioning, as __29__ by a range of learning and memory tests, such as the ability to remember a list of words presented some minutes or hours earlier. " +
                "There is also a growing body of evidence that diet induced cognitive impairments can emerge __30__ within weeks or even days. " +
                "For example, one study found healthy adults __31__ to a high-fat diet for five days showed impaired attention, memory, and mood compared with a low-fat diet control group. " +
                "Another study also found eating a high-fat and high-sugar breakfast each day for as little as four days resulted in problems with learning and memory __32__ to those observed in overweight and obese individuals.\n" +
                "Body weight was not hugely different between the groups eating a healthy diet and those on high and sugar diets. So this shows negative __33__ of poor dietary intake can occur even when body weight has not changed __34__. " +
                "Thus, body weight is not always the best indicator of health and a thin person still needs to eat well and exercise __35__.";
        p.reading.choicesOfSectionA = new String[]{"assessed", "assigned", "consequences", "conspicuously", "deficits", "designated", "detrimental", "digestion", "excelling", "indulging", "loopholes", "rapidly", "redundant", "regularly", "similar"};

        p.translation = "牡丹(peony)花色艳丽，形象高雅，象征着和平与繁荣，因而在中国被称为“花中之王”。中国许多地方都培育和种植牡丹。千百年来，创作了许多诗歌和绘画赞美牡丹。唐代时期，牡丹在皇家园林普遍种植并被誉为国花，因而特别风行。" +
                "十世纪时，洛阳古城成为牡丹栽培中心，而且这一地位一直保持到今天。现在，成千上万的国内外游客蜂拥到洛阳参加一年一度的牡丹节，欣赏洛阳牡丹的独特之美，同时探索九朝古都的历史。";

        save(p, "paper.ser");
        System.out.println("Serialized Paper...");

    }

    public static void testDeser(){
        Paper p = get("./tmp/paper.ser");
        System.out.println("Deserialized Paper...");
        System.out.print(p);
    }
}
