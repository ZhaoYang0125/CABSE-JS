<template>
    <el-container>
    <el-header>Head: CET6 六级试题录入</el-header>
        <el-container>
            <el-aside width="160px">
                <el-row>Aside</el-row>
                <el-row>
                    <el-form-item label="PaperID: ">
                        <el-input></el-input>
                    </el-form-item>
                </el-row>
                <el-row>
                    <el-button @click="qInputVisible = !qInputVisible, aInputVisible = !aInputVisible">试题录入</el-button>
                </el-row>
                <el-row>
                    <el-button @click="aInputVisible = !aInputVisible, qInputVisible = !qInputVisible">答案录入</el-button>
                </el-row>
            </el-aside>
            <el-main>
                Main
                <el-form ref="form" :model="form" label-width="80px" v-show="qInputVisible">
                    <h2>题目录入</h2>
                    <h3>Part I Writing (30 minutes)</h3>
                    <div>
                        <strong>Directions: </strong>
                        <el-row>
                            <el-col>
                                <el-form-item>
                                    <el-input type="textarea" autosize v-model="form.writing"></el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                    </div>

                    <h3>Part II Listening Comprehension (30 minutes)</h3>
                    <div>
                        <h4>Section A</h4>
                        <p><strong>Directions: </strong>In this section, you will hear two long conversations. At the end of each conversation, you will hear four questions. Both the conversation and the questions will be spoken only once. After you hear a question, you must choose the best answer from the four choices marked A), B), C) and D). Then mark the corresponding letter on Answer Sheet 1 with a single line through the centre.</p>
                        <strong>Questions 1 to 4 are based on the conversation you have just heard</strong>
                        <div v-for="i in 4">
                            {{i}}
                            <el-row>
                                <el-col :span="8">
                                    <el-form-item>
                                        <el-input v-for="j in 4" v-model="form.listeningChoices[(i-1)*4 + j-1]" placeholder="请输入内容"></el-input>
                                    </el-form-item>
                                </el-col>
                            </el-row>
                        </div>
                    </div>

                    <h3>Part III Reading Comprehension (40 minutes)</h3>
                    <div>
                        <h3>SectionA</h3>
                        <p><strong>Directions: </strong>In this section, there is a passage with ten blanks. You are required to select one word for each blank from a list of choices given in a word bank following the passage. Read the passage through carefully before making your choices. Each choice in the bank is identified by a letter. Please mark the corresponding letter for each item on Answer Sheet 2 with a single line through the centre. You may not use any of the words in the bank more than once</p>
                        <el-row>
                            <el-col :span="20">
                                <el-form-item>
                                    <el-input type="textarea" autosize v-model="form.sectionA"></el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row :gutter="16">
                            <el-col v-for="i in 15" :span="4">
                                <el-form-item>
                                    <el-input v-model="form.choicesOfSectionA[i-1]" placeholder="请输入内容"></el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                    </div>
                    <div>
                        <h3>SectionB</h3>
                        <p><strong>Directions: </strong>In this section, you are going to read a passage with ten statements attached to it. Each statement contains information given in one of the paragraphs. Identify the paragraph from which the information is derived. You may choose a paragraph more than once. Each paragraph is marked with a letter. Answer the questions by marking the corresponding letter on Answer Sheet</p>
                        <h4>Title</h4>
                        <el-row>
                            <el-col :span="12">
                                <el-form-item>
                                    <el-input v-model="form.sectionB"></el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <h4>statements</h4>
                        <el-row v-for="i in 10">
                            <el-col :span="16">
                                <el-form-item :label="i">
                                    <el-input type="textarea" autosize v-model="form.statementsOfSectionB[i-1]"></el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <h4>paragraphs</h4>
                        <el-row v-for="i in 10">
                            <el-col :span="16">
                                <el-form-item :label="i">
                                    <el-input type="textarea" autosize v-model="form.paragraphsOfSectionB[i-1]"></el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                    </div>
                    <div>
                        <h3>SectionC</h3>
                        <p><strong>Directions: </strong>There are 2 passages in this section. Each passage is followed by some questions or unfinished statements. For each of them there are four choices marked A), B), C) and D). You should decide on the best choice and mark the corresponding letter on Answer Sheet 2 with a single line through the centre.</p>
                        <h4>Passage One</h4>
                        <strong>Questions 46 to 50 are based on the following passage</strong>
                        <el-row>
                            <el-col :span="20">
                                <el-form-item>
                                    <el-input type="textarea" autosize v-model="form.PassagesOfSectionC[0]"></el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <div v-for="q in 2">
                            <el-row>
                                <el-col :span="12">
                                    <el-form-item>
                                        <el-input v-model="form.questionsOfSectionC[q-1]"></el-input>
                                    </el-form-item>
                                </el-col>
                            </el-row>
                            <el-row v-for="a in 4">
                                <el-col :span="12">
                                    <el-form-item :label="(q-1)*4 + a">
                                        <el-input v-model="form.choicesOfSectionC[(q-1)*4 + a - 1]"></el-input>
                                    </el-form-item>
                                </el-col>
                            </el-row>
                        </div>

                        <h4>Passage Two</h4>
                        ...
                    </div>

                    <h3>Part IV Translation (30 minutes)</h3>
                    <div>
                        <p><strong>Direction: </strong>For this part, you are allowed 30 minutes to translate a passage from Chinese into English. You should write your answer on Answer Sheet 2</p>
                        <el-row>
                            <el-col>
                                <el-form-item>
                                    <el-input type="textarea" v-model="form.translation"></el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                    </div>

                    <el-form-item>
                        <el-button type="primary" @click="onSubmit">录入</el-button>
                        <el-button type="primary" @click="goBack"> 取消</el-button>
                    </el-form-item>
                </el-form>

                <el-form ref="ansForm" :model="ansForm" label-width="80px" v-show="aInputVisible">
                    <h2>答案录入</h2>
                    <h3>Part Ⅰ Writing</h3>
                    <el-row>
                        <el-form-item>
                            <el-input type="textarea" autosize v-model="ansForm.writing"></el-input>
                        </el-form-item>
                    </el-row>

                    <h3>Part II Listening Comprehension</h3>
                    <div>
                        <h4>Section A</h4>
                        <el-row v-for="i in 2">
                            <el-col v-for="j in 4" :span="4">
                                <el-form-item>
                                    <el-input v-model="ansForm.listening[(i-1)*4 + (j-1)]"></el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <h4>Section B</h4>
                        <el-row>
                            <el-col v-for="j in 7" :span="4">
                                <el-form-item>
                                    <el-input v-model="ansForm.listening[8 + (j-1)]"></el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <h4>Section C</h4>
                        <el-row>
                            <el-col v-for="j in 10" :span="4">
                                <el-form-item>
                                    <el-input v-model="ansForm.listening[15 + (j-1)]"></el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                    </div>

                    <h3>Part III Reading Comprehension</h3>
                    <div>
                        <h4>Section A</h4>
                        <el-row>
                            <el-col v-for="j in 10" :span="4">
                                <el-form-item>
                                    <el-input v-model="ansForm.reading[(j-1)]"></el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <h4>Section B</h4>
                        <el-row>
                            <el-col v-for="j in 10" :span="4">
                                <el-form-item>
                                    <el-input v-model="ansForm.reading[10 + (j-1)]"></el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <h4>Section C</h4>
                        <el-row>
                            <el-col v-for="j in 10" :span="4">
                                <el-form-item>
                                    <el-input v-model="ansForm.reading[16 + (j-1)]"></el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                    </div>
                    <h3>Part IV Translation</h3>
                    <div>
                        <el-row>
                            <el-form-item>
                                <el-input type="textarea" autosize v-model="ansForm.translation"></el-input>
                            </el-form-item>
                        </el-row>
                    </div>

                    <el-button type="primary" @click="onSubmitAns">录入答案</el-button>
                    <el-button type="primary" @click="goBack"> 取消</el-button>
                </el-form>

            </el-main>
        </el-container>
    </el-container>
</template>

<script>
    export default {
        name: "QuestionInput",
        data() {
            return {
                qInputVisible: true,
                aInputVisible: false,
                form: {
                    writing: "For this part, you are allowed 30 minutes to write an essay on the importance of having a sense of social responsibility. You should write at least 150 words but no more than 160 words",
                    listeningChoices: [
                        "A) Magazine reporter", "B) Fashion designer", "C) Website designer", "D) Features editor",
                        "A) Designing sports clothing", "B) Consulting fashion experts", "C) Answering daily emails", "D) Interviewing job-seekers",
                        "A) It is challenging", "B) It is fascinating", "C) It is tiresome", "D) It is fashionable",
                        "A) Her persistence", "B) Her experience", "C) Her competence", "D) Her confidence",
                        "q5a1", "q1a2", "q1a3", "q1a4",
                        "q6a1", "q1a2", "q1a3", "q1a4",
                        "q7a1", "q1a2", "q1a3", "q1a4",
                        "q8a1", "q1a2", "q1a3", "q1a4",
                        "q9a1", "q1a2", "q1a3", "q1a4",
                        "q10a1", "q1a2", "q1a3", "q1a4",
                        "q1a1", "q1a2", "q1a3", "q1a4",
                        "q2a1", "q1a2", "q1a3", "q1a4",
                        "q3a1", "q1a2", "q1a3", "q1a4",
                        "q4a1", "q1a2", "q1a3", "q1a4",
                        "q5a1", "q1a2", "q1a3", "q1a4",
                        "q6a1", "q1a2", "q1a3", "q1a4",
                        "q7a1", "q1a2", "q1a3", "q1a4",
                        "q8a1", "q1a2", "q1a3", "q1a4",
                        "q9a1", "q1a2", "q1a3", "q1a4",
                        "q10a1", "q1a2", "q1a3", "q1a4",
                        "q1a1", "q1a2", "q1a3", "q1a4",
                        "q2a1", "q1a2", "q1a3", "q1a4",
                        "q3a1", "q1a2", "q1a3", "q1a4",
                        "q4a1", "q1a2", "q1a3", "q1a4",
                        "q5a1", "q1a2", "q1a3", "q1a4",
                    ],

                    sectionA: "When considering risk factors associated with serious chronic diseases, we often think about health indicators such as cholesterol, blood pressure, and body weight. But poor diet and physical inactivity also each increase the risk of heart disease and have a role to play in the development of some cancers. Perhaps worse, the __26__ effects of an unhealthy diet and insufficient exercise are not limited to your body. Recent research has also shown that __27__ in a high-fat and high-sugar diet may have negative effects on your brain, causing learning and memory __28__.\n" +
                        "\n" +
                        "Studies have found obesity is associated with impairments in cognitive functioning, as __29__ by a range of learning and memory tests, such as the ability to remember a list of words presented some minutes or hours earlier. There is also a growing body of evidence that diet induced cognitive impairments can emerge __30__ within weeks or even days. For example, one study found healthy adults __31__ to a high-fat diet for five days showed impaired attention, memory, and mood compared with a low-fat diet control group. Another study also found eating a high-fat and high-sugar breakfast each day for as little as four days resulted in problems with learning and memory __32__ to those observed in overweight and obese individuals.\n" +
                        "\n" +
                        "Body weight was not hugely different between the groups eating a healthy diet and those on high and sugar diets. So this shows negative __33__ of poor dietary intake can occur even when body weight has not changed __34__. Thus, body weight is not always the best indicator of health and a thin person still needs to eat well and exercise __35__.\n" +
                        "\n" ,
                    choicesOfSectionA: [
                        "A)assessed", "B)assigned ", "C)consequences ", "D)conspicuously ", "E)deficits ", "F)designated ", "G)detrimental ", "H)digestion ", "I)excelling ", "J)indulging ", "K)loopholes ", "L)rapidly ", "M)redundant ", "N)regularly ", "O)similar"
                    ], // 15
                    sectionB: "Increased Screen Time and Wellbeing Decline in Youth",
                    statementsOfSectionB: ["A) Have young people never had it so good? Or do they face more challenges than any previous generation? Our current era in the West is one of high wealth. This means minors enjoy material benefits and legal protections that would have been the envy of those living in the past. But There is an increasing suspicion that all is not well for our youth. And one of the most popular explanations, among some experts and the popular media, is that excessive \"screen time\" is to blame. (This refers to all the attention young people devote to their phones, tablets and laptops.) However, this is a contentious theory and such claims have been treated skeptically by some scholars based on their reading of the relevant data",
                        "B) Now a new study has provided another contribution to the debate, uncovering strong evidence that adolescent wellbeing in the United States really is experiencing a decline and arguing that the most likely cause is the electronic riches we have given them. The background to this is that from the 1960s into the early 1600s, measures of average wellbeing went up in the US. This was especially true for younger people. It reflected the fact that these decades saw a climb in general standards of living and avoidance of mass societal traumas like full-scale war or economic deprivation. However, the \"screen time\" hypothesis, advanced by researchers such as Jean Twenge, is that electronic devices and excessive time spent online may have reversed these trends in recent years, causing problems for young people's psychological health",
                        "C) To investigate, Twenge and her colleagues dived into the \"Monitoring the Future\" dataset based on annual surveys of American school students from grades 8, 10, and 12 that started in 1991. In total, 1.1 million young people answered various questions related to their wellbeing. Twenge's team's analysis of the answers confirmed the earlier, well-established wellbeing climb, with scores rising across the 1990s, and into the later 1600s，This was found across measures like self-esteem, life satisfaction, happiness and satisfaction with individual domains like job, neighborhood, or friends. But around 1612 these measures started to decline. This continued through 1616, the most recent year for which data is available",
                        "D) Twenge and her colleagues wanted to understand why this change in average wellbeing occurred. However, it is very hard to demonstrate causes using non-experimental data such as this. In fact, when Twenge previously used this data to suggest a screen time effect, some commentators were quick to raise this problem. They argued that her causal-sounding claims rested on correlational data, and that she had not adequately accounted for other potential causal factors. This time around, Twenge and her team make a point of saying that they are not trying to establish causes as such, but that they are assessing the plausibility of potential causes",
                        "E) First, they explain that if a given variable is playing a role in affecting wellbeing, then we should expect any change in that variable to correlate with the observed changes in wellbeing. If not, it is not plausible that the variable is a causal factor. So the researchers looked at time spent in a number of activities that could plausibly be driving the wellbeing decline. Less sport, and fewer meetings with peers correlated with lower wellbeing, as did less time reading print media (newspapers) and, surprisingly, less time doing homework. (This last finding would appear to contradict another popular hypothesis that it is our burdening of students with assignment that is causing all the problems,) In addition, more TV watching and more electronic communication both correlated with lower wellbeing. All these effects held true for measures of happiness, life satisfaction and self-esteem, with the effects stronger in the 8th and l0th-graders",
                        "F) Next, Twenge's team dug a little deeper into the data on screen time. They found that adolescents who spent a very small amount of time on digital devices- a couple of hours a week- had the highest wellbeing. Their wellbeing was even higher than those who never used such devices. However, higher doses of screen time were clearly associated with lower happiness. Those spending 10-19 hours per week on their devices were 41 percent more likely to be unhappy than lower-frequency users. Those who used such devices 40 hours a week or more (one in ten teenagers) were twice as likely to be unhappy. The data was slightly complicated by the fact that there was a tendency for kids who were social in the real world to also use more online communication, but by bracketing out different cases it became clear that the real-world sociality component correlated with greater wellbeing, whereas greater time on screens or online only correlated with poorer wellbeing",
                        "G) So far, so plausible. But the next question is, are the drops in average wellbeing happening at the same time as trends toward increased electronic device usage? It looks like it- -after all, 1612 was the tipping point when more than half of Americans began owning smartphones. Twenge and her colleagues also found that across the key years of 1613-16, wellbeing was indeed lowest in years where adolescents spent more time online, on social media, and reading news online, and when more youth in the United States had smartphones. And in a second analysis, they, found that where technology went, dips in wellbeing followed. For instance, years with a larger increase in online usage were followed by years with lower wellbeing, rather than the other way around. This does not prove causality, but is consistent with it. Meanwhile, TV use did not show this tracking. TV might make you less happy, but this is not what seems to be driving the recent declines in young people's average happiness",
                        "H) A similar but reversed pattern was found for the activities associated with greater wellbeing. For example, years when people spent more time with friends were better years for wellbeing (and followed by better years). Sadly, the data also showed face-to-face socializing and sports activity had declined over the period covered by the survey",
                        "I) There is another explanation that Twenge and her colleagues wanted to address; the impact of the great recession of 1607-1609, which hit a great number of American families and might be affecting adolescents. The dataset they used did not include economic data, so instead the researchers looked at whether the 1613-16 wellbeing decline was tracking economic indicators. 'They found some evidence that some crude measures, like income inequality, correlated with changes in wellbeing, but economic measures with a more direct impact, like family income and unemployment rates (which put families into difficulties), had no relationship with wellbeing. The researchers also note the recession hit some years before we see the beginning of the wellbeing drop, and before the steepest wellbeing decline, which occurred in 1613",
                        "J) The researchers conclude that electronic communication was the only adolescent activity that increased at the same time psychological wellbeing declined. I suspect that some experts in the field will be keen to address alterative explanations, such as unassessed variables playing a role in the wellbeing decline. But the new work does go further than previous research and suggests that screen time should still be considered a potential barrier to young people's flourishing"
                    ], // 10
                    paragraphsOfSectionB: [
                        "36.The year when most Americans began using smartphones was identified as a turning point in young Americans' level of happiness",
                        "37.Scores in various wellbeing measures began to go downward among young Americans in recent years",
                        "38.Unfortunately, activities involving direct contact with people, which contributed to better wellbeing were found to be on the decline",
                        "39.In response to past critics, Twenge and her co-researchers stress they are not trying to prove that the use of digital devices reduces young people's wellbeing",
                        "40.In the last few decades of the 16th century, living standards went up and economic depressions were largely averted in the US",
                        "41.Contrary to popular belief, doing homework might add to students' wellbeing",
                        "42.The author believes the researchers' new study has gone a step further regarding the impact of screen time on wellbeing",
                        "43.The researchers found that extended screen time makes young people less happy",
                        "44.Data reveals that economic inequality rather than family income might affect people's wellbeing",
                        "45.Too much screen time is widely believed to be the cause of unhappiness among today's young people"
                    ], // 10
                    PassagesOfSectionC: [
                        "\"The dangerous thing about lying is people don't understand how the act changes us,\" says Dan Ariely, behavioral psychologist at Duke University. Psychologists have documented children lying as early as the age of two. Some experts even consider lying a developmental milestone, like crawling and walking, because it requires sophisticated planning, attention and the ability to see a situation from someone else's perspective to manipulate them. But, for most people, lying gets limited as we develop a sense of morality and the ability to self-regulate.\n" +
                        "\n" +
                        "Harvard cognitive neuroscientist Joshua Greene says. for most of us, lying takes work. In studies, he gave subjects a chance to deceive for monetary gain while examining their brains in a functional MRI machine，which maps blood flow to active parts of the brain. Some people told the truth instantly and instinctively. But others opted to lie, and they showed increased activity in their frontal parietal (颅腔壁的) control network, which is involved in difficult or complex thinking. This suggests that they were deciding between truth and dishonesty and ultimately opting for the latter. For a follow-up analysis, he found that people whose neural(神经的)reward centres were more active when they won money were also more likely to be among the group of liars- suggesting that lying may have to do with the inability to resist temptation.\n" +
                        "\n" +
                        "Extremal conditions also matter in terms of when and how often we lie. We are more likely to lie, research shows, when we are able to rationalise it, when we are stressed and fatigued or sec others being dishonest. And we are less likely to lie when we have moral reminders or when we think others are watching. \"We as a society need to understand that, when we don't punish lying, we increase the probability it will happen again,\" Ariely says.\n" +
                        "\n" +
                        "In a 1616 study published in the journal Nature Neuroscience, Ariely and colleagues showed how dishonesty alters people's brains, making it easier to tell lies in the future. When people uttered a falsehood, the scientists noticed a burst of activity in their amygdala. The amygdala is a crucial part of the brain that produces fear, anxiety and emotional responses including that sinking, guilty feeling you get when you lie. But when scientists had their subjects play a game- in which they won money by deceiving their partner, they noticed the negative signals from the amygdala began to decrease. Not only that, but when people faced no consequences for dishonesty, their falsehoods tended to get even more sensational. This means that if you give people multiple opportunities to lie for their own benefit, they start with little lies which get bigger over time.",
                        "Passage Two"
                    ], // 2
                    questionsOfSectionC: [
                        "46. Why do some experts consider lying a milestone in a child's development",
                        "47. Why does the Harvard neuroscientist say that lying takes work",
                        "48. Under what circumstances do people tend to lie",
                        "49. When are people less likely to lie"], // 10
                    choicesOfSectionC: [
                        "A) It shows they have the ability to view complex situations from different angles", "B) It indicates they have an ability more remarkable than crawling and walking", "C) It represents their ability to actively interact with people around them", "D) It involves the coordination of both their mental and physical abilities",
                        "A) It is hard to choose from several options", "B) It is difficult to sound natural or plausible", "C) It requires speedy blood flow into one's brain", "D) It involves lots of sophisticated mental activity",
                        "A) When they become too emotional", "B) When they face too much peer pressure", "C) When the temptation is too strong", "D) When the consequences are not imminent",
                        "A) When they are worm out and stressed", "B) When they are under watchful eyes", "C) When they think in a rational way", "D) When they have a clear conscience",
                    ], // 40

                    translation: "牡丹(peony)花色艳丽，形象高雅，象征着和平与繁荣，因而在中国被称为“花中之王”。中国许多地方都培育和种植牡丹。千百年来，创作了许多诗歌和绘画赞美牡丹。唐代时期，牡丹在皇家园林普遍种植并被誉为国花，因而特别风行。十世纪时，洛阳古城成为牡丹栽培中心，而且这一地位一直保持到今天。现在，成千上万的国内外游客蜂拥到洛阳参加一年一度的牡丹节，欣赏洛阳牡丹的独特之美，同时探索九朝古都的历史。",
                },
                ansForm: {
                    writing:
                        "Problems such as the violation of privacy and environmental pollution are becoming increasingly prevalent in modern society. To some extent, they can be ascribed to a distinct lack of a sense of social responsibility among enterprises and individuals, which is of crucial importance in building a better world.\n" +
                        "\n" +
                        "When seeking profits, socially responsible corporations never forget to make positive contributions to our society. Take Alibaba, a leading tech company in China. The Ant Forest green initiative it launched in 1616 has so far inspired up to 500 million Alipay users to adopt low-carbon lifestyles and resulted in over 100 million trees planted in China's most barren regions. At the individual level, a sense of social responsibility motivates us college students to acquire as much knowledge as possible and put it into practice. It also prevents us from engaging in unethical behaviors such as campus violence and academic misconduct that cause negative social impacts.\n" +
                        "\n" +
                        "To sum up, a healthy society requires all its members to take on their respective responsibilities. Everyone, therefore, should develop a sense of social responsibility, especially we college students who will be a pillar of society in the future.ing", //写作
                    listening: [
                        'D', 'C', 'B', 'A', 'A', 'D', 'D', 'B',
                        'C', 'A', 'A', 'B', 'A', 'C', 'D',
                        'D', 'C', 'C', 'D', 'A','B', 'B', 'C', 'A', 'B',
                    ],   //25 听力
                    reading: [
                        'G', 'J', 'E', 'A', 'L', 'B', 'O', 'C', 'D', 'N',
                        'G', 'C', 'H', 'D', 'B', 'E', 'J', 'F', 'I', 'A',
                        'A', 'B', 'C', 'D', 'A', 'B', 'C', 'D', 'A', 'B',
                    ],   //30 阅读
                    translation: "The peony, boasting bright colors and an elegant appearance, is a symbol of peace and prosperity and thus recognized as \"king of the flowers\" in China. Peonies are bred and grown in many parts of the country. Over the centuries, numerous poems and paintings have been created to praise the flower. Peonies were particularly popular during the Tang Dynasty, when they were extensively cultivated in the imperial gardens and praised as the national flower. In the tenth century, the ancient city of Luoyang became the center for peony cultivation, a position it still holds today. Nowadays, thousands of tourists from home and abroad flock to Luoyang for the annual Peony Festival to both admire the unique beauty of the city's peonies and explore the history of the ancient capital of nine dynasties.", //翻译
                }
            };
        },
        methods: {
            onSubmit() {
                // let _this = this;
                // this.dialogFormVisible = false;
                let formData = new FormData();
                for (let key in this.form) {
                    formData.append(key, this.form[key]);
                    console.log(formData.get(key));
                }
                this.axios({
                    method: "post",
                    url: "api/paper/save",
                    headers:{
                        "Content-Type": "multipart/form-data"
                    },
                    withCredentials: true,
                    data: formData
                }).then((response) => {
                    console.log(response);
                    this.$message({
                        message: "录入试题成功！",
                        type: "success",
                    });
                });
            },
            onSubmitAns() {
                let formData = new FormData();
                for (let key in this.ansForm) {
                    formData.append(key, this.ansForm[key]);
                    console.log(formData.get(key));
                }
                this.axios({
                    method: "post",
                    url: "api/answer/save",
                    headers:{
                        "Content-Type": "multipart/form-data"
                    },
                    withCredentials: true,
                    data: formData
                }).then((response) => {
                    console.log(response);
                    this.$message({
                        message: "录入答案成功！",
                        type: "success",
                    });
                });
            },

            goBack() {
                this.$router.go(-1);
            },
        }
    }
</script>

<style scoped>
    .el-container{
        text-align: left;
    }
</style>
