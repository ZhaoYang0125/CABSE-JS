<template>
    <div>
        <div>
            <h2>欢迎{{ user.username }}！您的 uid 为{{ user.uid }}</h2>
            <el-button @click="logout"> 登出 </el-button>
        </div>
        <h4 style="text-align: center">欢迎来到评卷系统</h4>
        <el-form ref="findForm" :model="findForm">
            <el-form-item>
                <el-input v-model="findForm.paperid" style="width: 480px; margin-top: 15px">
                    <template slot="prepend">请输入要批改的试卷ID</template>
                </el-input>
            </el-form-item>
            <el-form-item>
                <el-input v-model="findForm.sid" style="width: 480px; margin-top: 15px">
                    <template slot="prepend">请输入要批改的学生ID</template>
                </el-input>
            </el-form-item>
        </el-form>
        <el-button @click="findStudentAnswer('findForm')" style="margin: 0px auto; margin-top: 15px">查询</el-button>
        <div v-if="displayAnswer">
            <table id="hor-minimalist-b" summary="Employee Pay Sheet" style="margin: 0px auto">
                <thead>
                <tr>
                    <th scope="col">题目</th>
                    <th scope="col">学生答案</th>
                    <th scope="col">满分</th>
                    <th scope="col">分数</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>写作</td>
                    <td>{{writing.answer}}</td>
                    <td>106.5</td>
                    <td><el-input
                            @blur="updateWritingScore(writing.score)"
                                  v-model="writing.score"
                                  style="width: 80px"></el-input></td>
                </tr>
                <tr>
                    <td>翻译</td>
                    <td>{{translation.answer}}</td>
                    <td>106.5</td>
                    <td><el-input ref="translation"
                            @blur="updateTranslationScore('translation')"
                            v-model="translation.score"
                            style="width: 80px"></el-input></td>
                </tr>
                </tbody>
            </table>
            <el-button @click="findLastAnswer">上一页</el-button>
            <el-button @click="findNextAnswer">下一页</el-button>
        </div>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                writing:{
                    answer:"",
                    score:0
                },
                translation:{
                    answer:"",
                    score:0
                },
                findForm:{
                    paperid:0,
                    sid:0
                },
                displayAnswer:false
            };
        },
        methods: {
            logout(){
                // 移除本地用户登录信息
                sessionStorage.removeItem('userInfo');
                // 跳转页面到登录页
                this.$router.push('/login');
            },
            findStudentAnswer(formName){
                this.$refs[formName].validate((valid)=>{
                    this.loading = true;
                    if (valid) {
                        let _this = this;
                        this.axios({
                            url: "/api/teacher/grading",               // 请求地址
                            method: "post",                       // 请求方法
                            headers: {                            // 请求头
                                "Content-Type": "application/json",
                            },
                            params: {                             // 请求参数
                                paperid: _this.findForm.paperid,
                                sid: _this.findForm.sid,
                            },
                        }).then((a)=> {
                            if(typeof (a.data)=="undefined" || a.data.length==0){
                                alert("找不到学生"+_this.findForm.sid+"在试卷"+_this.findForm.paperid+"的作答情况");
                            }
                            else{
                                console.log(a);
                                sessionStorage.setItem("answerInfo", JSON.stringify(a.data.data));
                                _this.writing.answer=a.data.writing;
                                _this.translation.answer=a.data.translation;
                            }
                        })
                    }
                    this.loading = false;
                })
                this.displayAnswer=true;
            },
            findLastAnswer(){//上一页
                this.findForm.sid-=1;
                // this.findStudentAnswer('findForm');
                this.axios({
                    url: "/api/teacher/grading",               // 请求地址
                    method: "post",                       // 请求方法
                    headers: {                            // 请求头
                        "Content-Type": "application/json",
                    },
                    params: {                             // 请求参数
                        paperid: this.findForm.paperid,
                        sid: this.findForm.sid,
                    },
                }).then((a)=> {
                    if(typeof (a.data)=="undefined" || a.data.length==0){
                        alert("找不到学生"+this.findForm.sid+"在试卷"+this.findForm.paperid+"的作答情况");
                        this.findForm.sid+=1;
                    }
                })
            },
            findNextAnswer(){//下一页
                this.findForm.sid+=1;
                // this.findStudentAnswer('findForm');
                this.axios({
                    url: "/api/teacher/grading",               // 请求地址
                    method: "post",                       // 请求方法
                    headers: {                            // 请求头
                        "Content-Type": "application/json",
                    },
                    params: {                             // 请求参数
                        paperid: this.findForm.paperid,
                        sid: this.findForm.sid,
                    },
                }).then((a)=> {
                    if(typeof (a.data)=="undefined" || a.data.length==0){
                        alert("找不到学生"+this.findForm.sid+"在试卷"+this.findForm.paperid+"的作答情况");
                        this.findForm.sid-=1;
                    }
                })
            },
            updateWritingScore(s){
                        let _this = this;
                        this.axios({
                            url: "/api/teacher2/writing",               // 请求地址
                            method: "post",                       // 请求方法
                            headers: {                            // 请求头
                                "Content-Type": "application/json",
                            },
                            params: {                             // 请求参数
                                paperid: _this.findForm.paperid,
                                sid: _this.findForm.sid,
                                score:_this.writing.score
                            },
                        }).then((a)=>{
                            if(a.data==true){
                                console.log(a)
                            }
                        })
            },
            updateTranslationScore(s){
                this.axios({
                    url: "/api/teacher2/translation",               // 请求地址
                    method: "post",                       // 请求方法
                    headers: {                            // 请求头
                        "Content-Type": "application/json",
                    },
                    params: {                             // 请求参数
                        paperid: this.findForm.paperid,
                        sid: this.findForm.sid,
                        score:this.translation.score
                    },
                }).then((a)=>{
                    if(a.data==true){
                        console.log(a)
                    }
                })
            },
        },
        mounted() {
            if (sessionStorage.getItem('userInfo')) {
                // 将用户信息存储到sessionStorage中
                this.user = JSON.parse(sessionStorage.getItem('userInfo'));
            }
        }
    };
</script>

<style scoped>
    #hor-minimalist-b
    {
        font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
        font-size: 12px;
        background: #fff;
        margin: 45px;
        width: 780px;
        border-collapse: collapse;
        text-align: left;
    }
    #hor-minimalist-b th
    {
        font-size: 14px;
        font-weight: normal;
        color: #039;
        padding: 10px 8px;
        border-bottom: 2px solid #6678b1;
    }
    #hor-minimalist-b td
    {
        border-bottom: 1px solid #ccc;
        color: #669;
        padding: 6px 8px;
    }
    #hor-minimalist-b tbody tr:hover td
    {
        color: #009;
    }
</style>
