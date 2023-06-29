<template>
    <div ref='vantaRef' style="height: 780px">
        <el-row>
            <el-col push="10" style="margin-top: 20px">
                <el-button @click="drawer = true" type="primary">
                    管理员登录
                </el-button>
            </el-col>
        </el-row>
        <el-row >
            <h1 style="
                height: 380px;
                margin-left: 150px;
                margin-top: 280px;
                font-weight: 400;
                font-size: 102px;
                letter-spacing: -2px;
                text-align: left;
            "> CET6 </h1>
        </el-row>
        <el-drawer
                :visible.sync="drawer"
                size="42%">
            <h2>管理员登录</h2>
            <el-form
                    :model="ruleForm"
                    status-icon
                    :rules="rules"
                    ref="ruleForm"
                    label-position="left"
                    label-width="70px"
                    class="login-from"
            >
                <el-form-item label="用户名" prop="username" style="width: 80%; margin: 20px auto auto;">
                    <el-input v-model="ruleForm.username"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="password" style="width: 80%; margin: 20px auto auto;">
                    <el-input
                            type="password"
                            v-model="ruleForm.password"
                            autocomplete="off"
                    ></el-input>
                </el-form-item>
                <el-form-item label="token" prop="token" style="width: 80%; margin: 20px auto auto;">
                    <el-input
                            type="password"
                            v-model="ruleForm.token"
                            autocomplete="off"
                    ></el-input>
                </el-form-item>
            </el-form>
            <div class="btnGroup" style="width: 80%; margin: 50px auto auto; text-align: center">
                <el-button
                        type="primary"
                        @click="submitForm('ruleForm')"
                        v-loading="loading"
                >登录</el-button
                >
                <el-button @click="resetForm('ruleForm')">重置</el-button>
                <el-button @click="goBack">返回</el-button>
            </div>
        </el-drawer>
    </div>
</template>

<script>
    import * as THREE from 'three'
    import CLOUDS from 'vanta/src/vanta.halo'
    export default {
        name: "AdminLogin",
        data() {
            return {
                drawer: true,
                ruleForm: {
                    username: "",
                    password: "",
                    token: ""
                },
                rules: {
                    username: [
                        { required: true, message: "用户名不能为空！", trigger: "blur" },
                        { pattern: /^[a-zA-Z0-9]+$/, message: "请仅输入数字或英文！", trigger: "change"}
                    ],
                    password: [
                        { required: true, message: "密码不能为空！", trigger: "blur" },
                        // { pattern:/^(?![\d]+$)(?![a-zA-Z]+$)(?![^\da-zA-Z]+$)([^\u4e00-\u9fa5\s]){6,20}$/, message: "密码输入非法！", trigger: "change"}
                    ],
                    token: [
                        { required: true, message: "token不能为空！", trigger: "blur" },
                    ],
                },
                loading: false, // 是否显示加载动画
            };
        },
        methods: {
            submitForm(formName) {
                // 验证表单中的账号密码是否有效，因为在上面rules中定义为了必填 required: true
                this.$refs[formName].validate((valid) => {
                    // 点击登录后，让登录按钮开始转圈圈（展示加载动画）
                    this.loading = true;
                    // 如果经过校验，账号密码都不为空，则发送请求到后端登录接口
                    if (valid) {
                        let _this = this;
                        // 使用 axios 将登录信息发送到后端
                        this.axios({
                            url: "/api/admin/login",               // 请求地址
                            method: "post",                       // 请求方法
                            headers: {                            // 请求头
                                "Content-Type": "application/json",
                            },
                            params: {                             // 请求参数
                                username: _this.ruleForm.username,
                                password: _this.ruleForm.password,
                                token: _this.ruleForm.token,
                            },
                        }).then((res) => { // 当收到后端的响应时执行该括号内的代码，res 为响应信息，也就是后端返回的信息
                            if (res.data.code === "0") {  // 当响应的编码为 0 时，说明登录成功
                                // 将用户信息存储到sessionStorage中
                                sessionStorage.setItem("userInfo", JSON.stringify(res.data.data));
                                // 跳转页面到首页
                                this.$router.push('/adminHome');
                                // 显示后端响应的成功信息
                                this.$message({
                                    message: res.data.msg,
                                    type: "success",
                                });
                            } else {  // 当响应的编码不为 0 时，说明登录失败
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
                    } else {  // 如果账号或密码有一个没填，就直接提示必填，不向后端请求
                        console.log("error submit!!");
                        this.loading = false;
                        return false;
                    }
                });
            },

            resetForm(formName) {
                this.$refs[formName].resetFields();
            },

            goBack() {
                this.$router.go(-1);
            },

        },
        mounted() {
            this.vantaEffect = CLOUDS({
                el: this.$refs.vantaRef,
                THREE: THREE
            })
        },
        beforeDestroy() {
            if (this.vantaEffect) {
                this.vantaEffect.destroy()
            }
        }
    };
</script>

<style scoped>
    /* 设置登录面板居中，宽度为400px */
    .box-card {
        margin: auto auto;
        width: 400px;
    }
    /* 设置登录面板中的表单居中 */
    .login-from {
        margin: auto auto;
    }
</style>
