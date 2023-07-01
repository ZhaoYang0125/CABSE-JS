<template>
    <el-container>
        <el-aside>
            <el-button type="info" @click="logout" plain> 登出 </el-button>
        </el-aside>
        <el-container>
            <el-header>
                <h2>欢迎{{ user.username }}！您的 工号 为{{ user.jobnumber }}</h2>
            </el-header>
            <el-main>

                <h3 style="text-align: center">欢迎来到评卷系统</h3>
                <el-form ref="findForm" :model="findForm">
                    <el-form-item>
                        <el-input v-model="findForm.paperid" style="width: 480px; margin-top: 15px">
                            <template slot="prepend">请输入要批改的试卷ID</template>
                        </el-input>
                    </el-form-item>

                </el-form>
                <el-button @click="findStudentAnswer('findForm')" icon="el-icon-search" style="margin: 20px auto; margin-top: 15px"  plain>查询</el-button>
                <el-button type="primary" @click="submit" style="margin: 20px; margin-top: 15px"  plain>提交</el-button>
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
                                    v-model="writing.score"
                                    style="width: 80px"></el-input></td>
                        </tr>
                        <tr>
                            <td>翻译</td>
                            <td>{{translation.answer}}</td>
                            <td>106.5</td>
                            <td><el-input ref="translation"
                                          v-model="translation.score"
                                          style="width: 80px"></el-input></td>
                        </tr>
                        </tbody>
                    </table>

                </div>
                <el-footer v-if="displayAnswer">
                    <el-pagination
                            background
                            layout="prev, pager, next"
                            :total="total"
                            :current-page="page"
                            :page-size="pageSize"
                            @current-change="pageChange"
                    >
                    </el-pagination>

                </el-footer>
            </el-main>

        </el-container>
    </el-container>
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
                    examid:0
                },
                displayAnswer:false,
                user: {
                    username: "",
                    jobnumber: null,
                },

                tableData: [],
                page: 1,
                total: 1,
                pageSize: 1,
            };

        },
        methods: {
            logout(){
                // 跳转页面到登录页
                this.$router.push('/index');
                // 移除本地用户登录信息
                sessionStorage.removeItem('userInfo');
            },
            findStudentAnswer(formName){
                let _this = this;
                this.axios({
                    url: "/api/teacher/grading",               // 请求地址
                    method: "post",                       // 请求方法
                    headers: {                            // 请求头
                        "Content-Type": "application/json",
                    },
                    params: {                             // 请求参数
                        paperid: _this.findForm.paperid,
                    },
                }).then((res)=> {
                    _this.tableData = res.data.data;
                    _this.total = res.data.data.length;
                    console.log("total=" + _this.total);
                    // console.log("tableData: "+_this.tableData);
                    if (_this.total == 0){
                        alert("未找到学生试卷作答");
                        location.reload();
                    }else{
                        sessionStorage.setItem("answerInfo", JSON.stringify(res.data.data));
                        _this.writing.answer=_this.tableData[(_this.page-1) % _this.total].writing;
                        _this.translation.answer=_this.tableData[(_this.page-1) % _this.total].translation;
                        _this.findForm.examid = _this.tableData[(_this.page-1) % _this.total].examid;
                        console.log(_this.tableData[(_this.page-1) % _this.total]);
                        console.log("index=" + (_this.page-1) % _this.total);
                    }
                }).catch(e => {
                    console.log(e)
                })
                this.displayAnswer=true;
            },
            pageChange(page) {
                this.page = page,
                    this.findStudentAnswer()
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
                        examid: _this.findForm.examid,
                        score:_this.writing.score
                    },
                }).then((a)=>{
                    if(a.data==true){
                        console.log(a)
                        // this.$message({
                        //     message: "提交成功!",
                        //     type: "success",
                        // });
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
                        examid: this.findForm.examid,
                        score:this.translation.score
                    },
                }).then((a)=>{
                    if(a.data==true){
                        // console.log(a)
                        this.$message({
                            message: "提交成功!",
                            type: "success",
                        });
                    }
                })
            },
            submit(){
                this.updateWritingScore(this.writing.score);
                this.updateTranslationScore(this.translation.score);
            }
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
    .el-aside {
        background-color: #71c9cd;
        color: #333;
        text-align: center;
        line-height: 200px;
    }
    .el-header, .el-footer {
        background-color: #e3fdfb;
        color: #333;
        text-align: center;
        line-height: 30px;
    }
    .el-main {
        background-color: #ebfffb;
        color: #333;
        text-align: center;
        /*line-height: 160px;*/
        height: calc(100vh - 100px);
    }
    .el-container{
        weight:100%;
        height: 100%;
    }
</style>
