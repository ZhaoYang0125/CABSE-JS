<template>
    <div class="btnGroup">
        <div>
            <h2>欢迎{{ user.username }}！您的 uid 为{{ user.uid }}</h2>
            <el-button @click="logout"> 登出 </el-button>
        </div>
        <div>
            <el-button @click="toProfileSubmit"> 完善个人信息 </el-button>
        </div>
        <div>
            <el-button @click="toEnroll"> 六级报名 </el-button>
        </div>
        <div>
            <el-button @click="toPay"> 缴费 </el-button>
        </div>
        <div>
            <el-button @click="toExamination"> 在线考试 </el-button>
        </div>
    </div>

</template>

<script>
    export default {
        data() {
            return {
                user: {
                    username: "",
                    uid: null,
                },
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
                    if (res.data.code === "0") {  // 当响应的编码为 0 时，说明成功
                        // 跳转页面到首页
                        this.$router.push({
                            path: '/enroll',
                            query: {
                                uid: res.data.data.uid,
                                sid: res.data.data.sid,
                                sname: res.data.data.sname,
                                gender: res.data.data.gender,
                                age: res.data.data.age,
                                school: res.data.data.school
                            }
                        });
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
                    _this.loading = false;
                    console.log(res);
                });
            },

            toPay(){
                // TODO:
            },

            toExamination() {
                // TODO:
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
