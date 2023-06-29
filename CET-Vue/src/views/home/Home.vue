<template>
    <el-container>
        <el-header>
            <el-row style="background-color: lightblue">
                <el-col span="6" offset="1">
                    <p style="text-align: center; font-size: 20px">
                        欢迎 {{ user.username }}！
                    </p>
                </el-col>
                <el-col span="11" offset="3">
                    <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect"
                    style="background-color: lightblue">
                        <el-menu-item index="1">首页</el-menu-item>
                        <el-menu-item index="2">考试动态</el-menu-item>
                        <el-menu-item index="3">CET委员会</el-menu-item>
                        <el-menu-item index="4">考试大纲</el-menu-item>
                        <el-menu-item index="5">考核内容</el-menu-item>
                        <el-menu-item index="6">分数解释</el-menu-item>
                        <el-menu-item index="7">常见问题</el-menu-item>
                    </el-menu>
                </el-col>
            </el-row>
            <el-row style="width: 100%; margin: auto">
                <el-carousel ref="car" indicator-position="none" height="350px" :autoplay="false" arrow="never">
                    <el-carousel-item v-for="item in URLArr" :key="item">
                        <el-image
                                :src=item
                                :fit="fit"></el-image>
                    </el-carousel-item>
                </el-carousel>
            </el-row>
        </el-header>

        <el-main style="margin-top: 380px">
            <el-row style="margin-top: 30px">
                <el-col span="4" offset="2">
                    <el-card class="box-card">
                        <div slot="header">
                            <i class="el-icon-edit"></i>
                            <span style="font-size: 30px">项目介绍</span>
                        </div>
                        <div>
                            <p style="text-align: left; margin: auto 10px 10px">全国大学英语四、六级考试(CET)系教育部主办、教育部教育考试院（原教育部考试中…</p>
                            <el-button style="float: right; padding: 3px 0" type="text">详细>></el-button>
                        </div>
                    </el-card>
                </el-col>
                <el-col span="4" offset="1">
                    <el-card class="box-card">
                        <div slot="header">
                            <i class="el-icon-check"></i>
                            <span style="font-size: 30px">CET笔试</span>
                        </div>
                        <div>
                            <p style="text-align: left; margin: auto 10px 10px">CET笔试每年开考两次，分别于6月和12月举行，具体考试时间我中心将会在每年年初…</p>
                            <el-button style="float: right; padding: 3px 0" type="text">详细>></el-button>
                        </div>
                    </el-card>
                </el-col>
                <el-col span="4" offset="1">
                    <el-card class="box-card">
                        <div slot="header">
                            <i class="el-icon-bell"></i>
                            <span style="font-size: 30px">CET口试</span>
                        </div>
                        <div>
                            <p style="text-align: left; margin: auto 10px 10px">CET口试每年开考两次，分别于5月和11月举行，具体考试时间我中心将会在每年年初…</p>
                            <el-button style="float: right; padding: 3px 0" type="text">详细>></el-button>
                        </div>
                    </el-card>
                </el-col>
                <el-col span="4" offset="1">
                    <el-card class="box-card">
                        <div slot="header">
                            <i class="el-icon-user"></i>
                            <span style="font-size: 30px">考生服务</span>
                        </div>
                        <div>
                            <el-row style="margin-top: 5px;">
                                <el-col span="2"><el-button @click="enrollDrawer=true">在线报名</el-button></el-col>
                                <el-col span="2" offset="11"><el-button @click="gradeDrawer=true">成绩查询</el-button></el-col>
                            </el-row>
                            <el-row style="margin-top: 10px;">
                                <el-col span="2"><el-button @click="profileDrawer=true">完善信息</el-button></el-col>
                                <el-col span="2" offset="11"><el-button @click="toPay">在线缴费</el-button></el-col>
                            </el-row>
                            <el-row style="margin-top: 10px;">
                                <el-col span="2"><el-button @click="toExamination">在线考试</el-button></el-col>
                                <el-col span="2" offset="11"><el-button @click="logout">退出登录</el-button></el-col>
                            </el-row>
                        </div>
                    </el-card>
                </el-col>
            </el-row>

            <el-drawer
                    :visible.sync="enrollDrawer"
                    size="42%">
                <h1 style="font-size: 36px; font-weight: lighter">在线报名</h1>
                <enroll style="text-align: left; text-align: left; margin-left: 100px; font-size: 24px;"></enroll>
            </el-drawer>

            <el-drawer
                    :visible.sync="gradeDrawer"
                    size="42%">
                <h1 style="font-size: 36px; font-weight: lighter">成绩查询</h1>
                <el-row>
                    <el-input v-model="paperid" placeholder="请输入要查询的考试年月" style="width:400px; text-align: center"></el-input><el-button type="primary" @click="onSearch">查询</el-button>
                </el-row>
                <el-card v-if="grade.get" class="box-card">
                    <span v-if="grade.pass">合格</span>
                    <span v-else>不合格</span>
                    <br><span>总分：{{grade.total}}</span>
                    <br><span>写作：{{grade.writing}}</span>
                    <br><span>听力：{{grade.listening}}</span>
                    <br><span>阅读理解：{{grade.comprehension}}</span>
                    <br><span>翻译：{{grade.translation}}</span>
                </el-card>
            </el-drawer>

            <el-drawer
                    :visible.sync="profileDrawer"
                    size="82%">
<!--                <h1 style="font-size: 36px; font-weight: lighter">完善信息</h1>-->
                <profile-submit ></profile-submit>
<!--                <show></show>-->
            </el-drawer>
        </el-main>
    </el-container>
</template>

<script>
    import Enroll from "../enroll/Enroll";
    import Login from "../login/Login";
    import ProfileSubmit from "../studentprofile/ProfileSubmit";
    export default {
        components: {ProfileSubmit, Login, Enroll},
        data() {
            return {
                enrollDrawer: false,
                gradeDrawer: false,
                profileDrawer: false,
                user: {
                    username: "",
                    uid: null,
                    state: null,
                },
                URLArr: [
                    require("@/assets/index/10.png"),
                ],
                paperid: null,
                grade: {
                    total: null,
                    listening: null,
                    comprehension: null,
                    writing: null,
                    translation: null,
                    pass: false,
                    get: false
                }
            };
        },
        methods: {
            logout(){
                // 移除本地用户登录信息
                sessionStorage.removeItem('userInfo');
                // 跳转页面到登录页
                this.$router.push('/login');
            },

            toProfileSubmit(){
                // 跳转页面到登录页
                this.$router.push('/studentprofile');
            },

            onSearch() {
                if (sessionStorage.getItem('userInfo')) {
                    // 将用户信息存储到sessionStorage中
                    this.user = JSON.parse(sessionStorage.getItem('userInfo'));
                }
                let formData = new FormData();
                formData.append('paperid', this.paperid);
                formData.append('uid', this.user['uid']);
                console.log(formData.get('uid'));
                this.axios({
                    method: "post",
                    url: "api/grade/search",
                    headers: {
                        "Content-Type": "multipart/form-data"
                    },
                    withCredentials: true,
                    data: formData
                }).then((response) => {
                    if (response.data.code === "0") {
                        this.grade.get = true;
                        console.log(response);
                        this.grade.comprehension = response.data.data.comprehension;
                        this.grade.listening = response.data.data.listening;
                        this.grade.translation = response.data.data.translation;
                        this.grade.writing = response.data.data.writing;
                        this.grade.total = Math.round(this.grade.comprehension + this.grade.listening + this.grade.translation + this.grade.writing);
                        if (this.grade.total >= 425) {
                            this.grade.pass = true;
                        }
                    } else {
                        alert("成绩尚未发布，请耐心等待");
                        // this.$router.push("/home");
                    }

                })
            },
            toEnroll(){
                let _this = this;
                // 使用axios将信息发送到后端
                this.axios({
                    url: "/api/studentprofile/findprofile",               // 请求地址
                    method: "post",                       // 请求方法
                    headers: {                            // 请求头
                        "Content-Type": "application/json",
                    },
                    params: {                             // 请求参数
                        uid: _this.user.uid,
                    },
                }).then((res) => { // 当收到后端的响应时执行该括号内的代码，res 为响应信息，也就是后端返回的信息
                    if (res.data.code == "0") {  // 当响应的编码为 0 时，说明成功
                        // 跳转页面到首页
                        this.$router.push({
                            path: '/enroll',
                            query: {
                                uid: res.data.data.uid,
                                examid: res.data.data.examid,
                                sname: res.data.data.sname,
                                gender: res.data.data.gender,
                                age: res.data.data.age,
                                school: res.data.data.school,
                                majerity: res.data.data.majerity,
                                enrollmentyear: res.data.data.enrollmentyear,
                                degree: res.data.data.degree,
                            }
                        });
                        // // 显示后端响应的成功信息
                        // this.$message({
                        //     message: res.data.msg,
                        //     type: "success",
                        // });
                    } else {  // 当响应的编码不为 0 时，说明失败
                        // 显示后端响应的失败信息
                        this.$message({
                            message: res.data.msg,
                            type: "warning",
                        });
                    }
                    // 不管响应成功还是失败，收到后端响应的消息后就不再让登录按钮显示加载动画了
                    _this.loading = false;
                    console.log(res);
                });
            },

            toPay(){
                this.$router.push('/pay');
            },

            toExamination() {

                this.axios({
                    url: "/api/user/finduser",               // 请求地址
                    method: "post",                       // 请求方法
                    headers: {                            // 请求头
                        "Content-Type": "application/json",
                    },
                    params: {                             // 请求参数
                        uid: this.user.uid,
                    },
                }).then((res) => {
                    if (res.data.code == "0"){
                        if (res.data.data.state == 2){
                            this.$router.push('/test');
                        }else{
                            this.$message({
                                message: "没有报名！",
                                type: "warning",
                            });
                        }
                    }
                });

            },

            toGrade() {
                this.$router.push('/grade');
            },

        },
        mounted() {
            if (sessionStorage.getItem('userInfo')) {
                this.user = JSON.parse(sessionStorage.getItem('userInfo'));
            }
        },

    };
</script>

<style scoped>

</style>
