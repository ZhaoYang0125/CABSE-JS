<template>
    <el-container>
        <el-header>Head: CET6 六级试题</el-header>
        <h1 align="center">考试剩余时间 {{hour}}:{{minute}}:{{second}}</h1>
        <el-container>
            <el-aside width="200px">Aside</el-aside>

            <el-main>
                Main
                <el-form ref="answer" :model="answer" label-width="80px">
                    <h3>Part I Writing (30 minutes)</h3>
                    <div>
                        <strong>Directions: </strong>
                        <span>{{ paper.writing }}</span>
                        <el-row>
                            <el-col>
                                <el-form-item>
                                    <el-input type="textarea" v-model="answer.writing"></el-input>
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
                            <el-radio-group v-model="answer.listeningChoices[i]">
                                <el-radio v-for="j in 4" :label="String.fromCharCode((97 + j-1)).toUpperCase()">
                                    {{ String.fromCharCode((97 + j-1)+'').toUpperCase() }}.
                                    <span>{{paper.listeningChoices[(i-1)*4 + j-1]}}</span>
                                </el-radio>
                            </el-radio-group>
                        </div>
                    </div>

                    <h3>Part III Reading Comprehension (40 minutes)</h3>
                    <div>
                        <h3>SectionA</h3>
                        <p><strong>Directions: </strong>In this section, there is a passage with ten blanks. You are required to select one word for each blank from a list of choices given in a word bank following the passage. Read the passage through carefully before making your choices. Each choice in the bank is identified by a letter. Please mark the corresponding letter for each item on Answer Sheet 2 with a single line through the centre. You may not use any of the words in the bank more than once</p>
                        <span>{{ paper.sectionA }}</span>
                        <span v-for="i in 15">
                            {{ String.fromCharCode((97 + i-1)+'').toUpperCase() }}.{{paper.choicesOfSectionA[i-1]}}
                        </span>
                        <el-row v-for="i in 10">
                            <el-col :span="12">
                                <el-form-item :label="i">
                                    <el-input v-model="answer.choicesOfSectionA[i-1]" placeholder="请输入答案A-O"></el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                    </div>
                    <div>
                        <h3>SectionB</h3>
                        <p><strong>Directions: </strong>In this section, you are going to read a passage with ten statements attached to it. Each statement contains information given in one of the paragraphs. Identify the paragraph from which the information is derived. You may choose a paragraph more than once. Each paragraph is marked with a letter. Answer the questions by marking the corresponding letter on Answer Sheet</p>
                        <h4>Title</h4>
                        <span>{{ paper.sectionB }}</span>
                        <h4>paragraphs</h4>
                        <span v-for="i in 10">
                            {{paper.paragraphsOfSectionB[i-1]}}
                        </span>
                        <h4>statements</h4>
                        <span v-for="i in 10">
                            {{paper.statementsOfSectionB[i-1]}}
                        </span>
                        <el-row v-for="i in 10">
                            <el-col :span="12">
                                <el-form-item :label="i">
                                    <el-input v-model="answer.choicesOfSectionB[i-1]" placeholder="请输入答案A-J"></el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                    </div>
                    <div>
                        <h3>SectionC</h3>
                        <p><strong>Directions: </strong>There are 2 passages in this section. Each passage is followed by some questions or unfinished statements. For each of them there are four choices marked A), B), C) and D). You should decide on the best choice and mark the corresponding letter on Answer Sheet 2 with a single line through the centre.</p>
                        <h4>Passage One</h4>
                        <strong>Questions 46 to 50 are based on the following passage</strong>
                        <span>{{ paper.passagesOfSectionC[0] }}</span>
                        <div v-for="i in 2">
                            <span>{{paper.questionsOfSectionC[i-1]}}</span>
                            <el-radio-group v-model="answer.choicesOfSectionC[i-1]">
                                <el-radio v-for="j in 4" :label="String.fromCharCode((97 + j-1)).toUpperCase()">
                                    {{ String.fromCharCode((97 + j-1)+'').toUpperCase() }}.
                                    <span>{{paper.choicesOfSectionC[(i-1)*4 + j-1]}}</span>
                                </el-radio>
                            </el-radio-group>
                        </div>

                        <h4>Passage Two</h4>
                        ...
                    </div>

                    <h3>Part IV Translation (30 minutes)</h3>
                    <div>
                        <p><strong>Direction: </strong>For this part, you are allowed 30 minutes to translate a passage from Chinese into English. You should write your answer on Answer Sheet 2</p>
                        <span>{{paper.translation}}</span>
                        <el-row>
                            <el-col>
                                <el-form-item>
                                    <el-input type="textarea" v-model="answer.translation"></el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                    </div>

                    <el-form-item>
                        <el-button type="primary" @click="onSubmit">提交</el-button>
                    </el-form-item>
                </el-form>
            </el-main>
        </el-container>
    </el-container>
</template>

<script>
    export default {
        data() {
            return {
                timer : null,
                hours: 2,
                minutes: 30,
                seconds: 0,

                flag: false,
                user: {
                    username: "",
                    uid: null,
                },
                paper: {
                    writing: "",
                    listeningChoices: [],

                    sectionA: "",
                    choicesOfSectionA: [], // 15
                    sectionB: "",
                    statementsOfSectionB: [], // 10
                    paragraphsOfSectionB: [], // 10
                    passagesOfSectionC: [], // 2
                    questionsOfSectionC: [], // 10
                    choicesOfSectionC: [], // 40

                    translation: "",
                },
                answer: {
                    writing: "w",
                    listeningChoices: [
                        "A", "A", "A", "A",
                        "A", "A", "A", "A",
                        "A", "A", "A", "A",
                        "A", "A", "A", "A",
                        "A", "A", "A", "A",
                        "A", "A", "A", "A",
                        "A",
                    ], // 25

                    choicesOfSectionA: ["A", "B", "C", "D", "E", "F","G", "H", "I", "J"], // 10
                    choicesOfSectionB: ["A", "B", "C", "D", "E", "F","G", "H", "I", "J"], // 10
                    choicesOfSectionC: [
                        "A", "A", "A", "A",
                        "A", "A", "A", "A",
                        "A", "A",
                    ], // 10

                    translation: "translation",
                }
            }
        },

        mounted() {
            this.add();
        },

        created(){
            this.init();
        },

        methods: {
            init() {
                this.getPaper();
            },
            getPaper(){
                this.axios({
                    url: "/api/test/paper",               // 请求地址
                    method: "post",                       // 请求方法
                }).then((res) => { // 当收到后端的响应时执行该括号内的代码，res 为响应信息，也就是后端返回的信息
                    if (res.data.data != null) {
                        this.flag = true;

                        this.paper.writing = res.data.data.writing;
                        console.log(this.paper.writing);
                        this.paper.listeningChoices = res.data.data.listeningChoices;
                        this.paper.sectionA = res.data.data.sectionA;
                        this.paper.choicesOfSectionA = res.data.data.choicesOfSectionA;
                        this.paper.sectionB = res.data.data.sectionB;
                        this.paper.statementsOfSectionB = res.data.data.statementsOfSectionB;
                        this.paper.paragraphsOfSectionB = res.data.data.paragraphsOfSectionB;
                        console.log(res.data.data.paragraphsOfSectionB);
                        this.paper.passagesOfSectionC = res.data.data.passagesOfSectionC;
                        console.log(res.data.data.passagesOfSectionC);
                        console.log(this.paper.passagesOfSectionC);
                        this.paper.questionsOfSectionC = res.data.data.questionsOfSectionC;
                        this.paper.choicesOfSectionC = res.data.data.choicesOfSectionC;
                        this.paper.translation = res.data.data.translation;
                    }else{
                        this.$message({
                            message: res.data.msg,
                            type: "warning",
                        });
                        this.flag = false;
                    }
                    console.log(this.paper.writing);
                });
                console.log(this.paper.writing);
            },
            onSubmit() {
                if (this.flag == true){
                    if (sessionStorage.getItem('userInfo')) {
                        // 将用户信息存储到sessionStorage中
                        this.user = JSON.parse(sessionStorage.getItem('userInfo'));
                    }
                    let formData = new FormData();
                    for (let key in this.answer) {
                        formData.append(key, this.answer[key]);
                        console.log(formData.get(key));
                    }
                    formData.append('uid', this.user['uid']);
                    console.log(formData.get('uid'));
                    this.axios({
                        method: "post",
                        url: "api/test/submit",
                        headers:{
                            "Content-Type": "multipart/form-data"
                        },
                        withCredentials: true,
                        data: formData
                    }).then((response) => {
                        if (response.data.code === "0"){
                            console.log(response);
                            alert("试卷提交成功");
                            this.$router.push('/home');
                        }
                        else {
                            alert("试卷提交失败");
                        }

                    });
                }
            },

            // 数值小于10时显示位数
            num(n) {
                return n < 10 ? '0' + n : '' + n
            },
            // 倒计时函数
            add() {
                this.timer = window.setInterval( ()=> {
                    if (this.hours !== 0 && this.minutes === 0 && this.seconds === 0) {
                        this.hours -= 1;
                        this.minutes = 59;
                        this.seconds = 59;
                    } else if (this.hours === 0 && this.minutes !== 0 && this.seconds ===
                        0) {
                        this.minutes -= 1;
                        this.seconds = 59;
                    } else if (this.hours === 0 && this.minutes === 0 && this.seconds ===
                        0) {
                        this.seconds = 0;
                        window.clearInterval(this.timer);
                        this.onSubmit();
                    } else if (this.hours !== 0 && this.minutes !== 0 && this.seconds ===
                        0) {
                        this.minutes -= 1;
                        this.seconds = 59;
                    } else {
                        this.seconds -= 1;
                    }
                }, 1000)
            },

        },

        watch: {
            // 监听数值变化
            second: {
                handler(newVal) {
                    this.num(newVal)
                }
            },
            minute: {
                handler(newVal) {
                    this.num(newVal)
                }
            },
            hour: {
                handler(newVal) {
                    this.num(newVal)
                }
            }
        },
        computed: {
            // 初始化数据
            second() {
                return this.num(this.seconds)
            },
            minute() {
                return this.num(this.minutes)
            },
            hour() {
                return this.num(this.hours)
            }
        },

        destroyed(){
            if(this.timer) { //如果定时器在运行则关闭
                window.clearInterval(this.timer);
            }
        }

    }
</script>

<style scoped>
    .el-container{
        text-align: left;
    }
</style>
