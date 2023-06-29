<template>
    <div>
        <div >
            {{infomation}}：
        </div>
        <div>
            <div>账号id: {{uid}}</div>
            <div>学生id: {{examid}}</div>
            <div>学生姓名: {{sname}}</div>
            <div>性别: {{gender}}</div>
            <div>年龄: {{age}}</div>
            <div>学校: {{school}}</div>
            <div>专业: {{majerity}}</div>
            <div>入学年份: {{enrollmentyear}}</div>
            <div>学历: {{degree}}</div>
            <div class="btnGroup" style="margin-top: 30px; text-align: center">
                <el-button type="primary" @click="submitEnroll"  v-loading="loading">报名提交</el-button>
                <el-button @click="goBack">返回前一页</el-button>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Enroll",
        created(){
            this.infomation = "核实信息"
            this.uid = this.$route.query.uid;
            this.examid = this.$route.query.examid;
            this.sname = this.$route.query.sname;
            this.gender = this.$route.query.gender;
            this.age = this.$route.query.age;
            this.school = this.$route.query.school;
            this.majerity = this.$route.query.majerity;
            this.enrollmentyear = this.$route.query.enrollmentyear;
            this.degree = this.$route.query.degree;
            this.loading = false;
        },

        data() {
            return {
                uid: "",
                examid: "",
                sname: "",
                gender: "",
                age: "",
                school: "",
                majerity:"",
                enrollmentyear:"",
                degree:"",

                loading: false,
                infomation: "核实信息",

                user: {
                    username: "",
                    uid: null,
                },
            };
        },

        methods: {
            submitEnroll() {
                this.loading = true;
                // 使用axios将信息发送到后端
                this.axios({
                    url: "/api/enroll/confirm",               // 请求地址
                    method: "post",                       // 请求方法
                    headers: {                            // 请求头
                        "Content-Type": "application/json",
                    },
                    params: {                             // 请求参数
                        uid: this.user.uid,
                    },
                }).then((res) => { // 当收到后端的响应时执行该括号内的代码，res 为响应信息，也就是后端返回的信息
                    if (res.data.code === "0") {  // 当响应的编码为 0 时，说明成功
                        this.infomation = "报名成功，以下为考生信息"
                        this.uid = res.data.data.uid;
                        this.examid = res.data.data.examid;
                        this.sname = res.data.data.sname;
                        this.gender = res.data.data.gender;
                        this.age = res.data.data.age;
                        this.school = res.data.data.school;
                        this.majerity = res.data.data.majerity;
                        this.enrollmentyear = res.data.data.enrollmentyear;
                        this.degree = res.data.data.degree;
                        // 显示后端响应的成功信息
                        this.$message({
                            message: res.data.msg,
                            type: "success",
                        });
                    } else {  // 当响应的编码不为 0 时，说明失败
                        // 显示后端响应的失败信息
                        this.$message({
                            message: res.data.msg,
                            type: "warning",
                        });
                    }
                    // 不管响应成功还是失败，收到后端响应的消息后就不再让登录按钮显示加载动画了
                    this.loading = false;
                    console.log(res);
                });


            },

            goBack() {
                this.$router.go(-1);
            },


        },

        mounted() {
            if (sessionStorage.getItem('userInfo')) {
                this.user = JSON.parse(sessionStorage.getItem('userInfo'));
            }
        },
    }
</script>

<style scoped>

</style>
