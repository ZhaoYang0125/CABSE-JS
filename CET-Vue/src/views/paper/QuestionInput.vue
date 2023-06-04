<template>
    <el-container>
    <el-header>Head: CET6 六级试题录入</el-header>
        <el-container>
            <el-aside width="200px">
                <el-row>Aside</el-row>
                <el-row>
                    <el-form-item label="PaperID: ">
                        <el-input></el-input>
                    </el-form-item>
                </el-row>
                <el-row>
                    <el-button @click="qInputVisible = !qInputVisible">试题录入</el-button>
                </el-row>
                <el-row>
                    <el-button @click="aInputVisible = !aInputVisible">答案录入</el-button>
                </el-row>
            </el-aside>
            <el-main>
                Main
                <el-form ref="form" :model="form" label-width="80px" v-show="qInputVisible">
                    <h3>Part I Writing (30 minutes)</h3>
                    <div>
                        <strong>Directions: </strong>
                        <el-row>
                            <el-col>
                                <el-form-item>
                                    <el-input type="textarea" v-model="form.writing"></el-input>
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
                                <el-col>
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
                            <el-form-item>
                                <el-input type="textarea" v-model="form.sectionA"></el-input>
                            </el-form-item>
                        </el-row>
                        <el-row :gutter="20">
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
                            <el-col :span="8">
                                <el-form-item>
                                    <el-input v-model="form.sectionB"></el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <h4>statements</h4>
                        <el-row v-for="i in 10">
                            <el-col :span="16">
                                <el-form-item :label="i">
                                    <el-input type="textarea" v-model="form.statementsOfSectionB[i-1]"></el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <h4>paragraphs</h4>
                        <el-row v-for="i in 10">
                            <el-col :span="12">
                                <el-form-item :label="i">
                                    <el-input v-model="form.paragraphsOfSectionB[i-1]"></el-input>
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
                            <el-col>
                                <el-form-item>
                                    <el-input type="textarea" v-model="form.PassagesOfSectionC[0]"></el-input>
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
                        <el-button>取消</el-button>
                    </el-form-item>
                </el-form>

                <el-form ref="ansForm" :model="ansForm" label-width="80px" v-show="aInputVisible">
                    <h3>Part Ⅰ Writing</h3>
                    <el-row>
                        <el-form-item>
                            <el-input type="textarea" v-model="ansForm.writing"></el-input>
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
                                    <el-input v-model="ansForm.reading[20 + (j-1)]"></el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                    </div>
                    <h3>Part IV Translation</h3>
                    <div>
                        <el-row>
                            <el-form-item>
                                <el-input type="textarea" v-model="ansForm.translation"></el-input>
                            </el-form-item>
                        </el-row>
                    </div>

                    <el-button type="primary" @click="onSubmitAns">录入答案</el-button>
                    <el-button>取消</el-button>
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
                aInputVisible: true,
                form: {
                    writing: "writing",
                    listeningChoices: [
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

                    sectionA: "sectionA",
                    choicesOfSectionA: ["A", "B", "C", "D", "E", "F","G", "H", "I", "J", "K", "L", "M", "N", "O",], // 15
                    sectionB: "sectionB",
                    statementsOfSectionB: ["A", "B", "C", "D", "E", "F","G", "H", "I", "J"], // 10
                    paragraphsOfSectionB: ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10"], // 10
                    PassagesOfSectionC: ["Passage One", "Passage Two"], // 2
                    questionsOfSectionC: ["q1", "q2", "q3", "q4"], // 10
                    choicesOfSectionC: [
                        "q1a1", "q1a1", "q1a1", "q1a1",
                        "q2a1", "q2a1", "q2a1", "q2a1",
                        "q1a1", "q1a1", "q1a1", "q1a1",
                        "q2a1", "q2a1", "q2a1", "q2a1",
                    ], // 40

                    translation: "translation",
                },
                ansForm: {
                    writing: "writing", //写作
                    listening: ['A','B','C','D','A','B','C','D','A','B','C','D','A','B','C','D',
                        'A','B','C','D','A','B','C','D','A'],   //25 听力
                    reading: ['A','B','C','D','A','B','C','D','A','B','C','D','A','B','C','D',
                        'A','B','C','D','A','B','C','D','A','B','C','D','A','B','C','D','A','B','C','D',
                        'A','B','C','D'],   //30 阅读
                    translation: "translation", //翻译
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
                });
            }
        }
    }
</script>

<style scoped>
    .el-container{
        text-align: left;
    }
</style>