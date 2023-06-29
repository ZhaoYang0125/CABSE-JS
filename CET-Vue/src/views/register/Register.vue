<template>
    <div>
        <el-card class="box-card">
            <h2>注册</h2>
            <el-form
                    :model="registForm"
                    status-icon
                    :registRules="registRules"
                    ref="registForm"
                    label-position="left"
                    label-width="80px"
                    class="demo-registForm"
            >
                <el-form-item label="用户名" prop="username">
                    <el-input v-model="registForm.username"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="pass">
                    <el-input
                            type="password"
                            v-model="registForm.pass"
                            autocomplete="off"
                    ></el-input>
                </el-form-item>
                <el-form-item label="确认密码" prop="password">
                    <el-input
                            type="password"
                            v-model="registForm.password"
                            autocomplete="off"
                    ></el-input>
                </el-form-item>
            </el-form>
            <div class="btnGroup">
                <el-button type="primary" @click="submitRegistForm('rgForm')" v-loading="loading"
                >提交</el-button
                >
                <el-button @click="resetForm('rgForm')">重置</el-button>
                <el-button @click="goBack">返回</el-button>
            </div>
        </el-card>
    </div>
</template>

<script>
    export default {
        data() {
            var validatePass = (rule, value, callback) => {
                if (value === "") {
                    callback(new Error("请输入密码"));
                } else {
                    if (this.rgForm.checkPass !== "") {
                        this.$refs.rgForm.validateField("checkPass");
                    }
                    callback();
                }
            };
            var validatePass2 = (rule, value, callback) => {
                if (value === "") {
                    callback(new Error("请再次输入密码"));
                } else if (value !== this.rgForm.pass) {
                    callback(new Error("两次输入密码不一致!"));
                } else {
                    callback();
                }
            };
            return {
                rgForm: {
                    username: "",
                    pass: "",
                    password: "",
                },
                rgRules: {
                    username: [
                        { required: true, message: "用户名不能为空！", trigger: "blur" },
                    ],
                    pass: [{ required: true, validator: validatePass, trigger: "blur" }],
                    password: [
                        { required: true, validator: validatePass2, trigger: "blur" },
                    ],
                },
                loading: false
            };
        },
        methods: {
            submitRgForm(formName) {
                this.$refs[formName].validate((valid) => {
                    this.loading = true;  // 提交按钮显示加载动画
                    if (valid) {
                        let _this = this;
                        this.axios({     // axios 向后端发起请求
                            url: "/api/user/register",  // 请求地址
                            method: "post",             // 请求方法
                            headers: {                  // 请求头
                                "Content-Type": "application/json",
                            },
                            data: { // 请求参数，为 data，与登录的 params 不太一样
                                username: _this.rgForm.username,
                                password: _this.rgForm.password,
                            },
                        }).then((res) => { // 当收到后端的响应时执行该括号内的代码，res 为响应信息，也就是后端返回的信息
                            if (res.data.code === '0') {  // 当响应的编码为 0 时，说明注册成功
                                // 显示后端响应的成功信息
                                this.$message({
                                    message: res.data.msg,
                                    type: "success",
                                });
                            }else{  // 当响应的编码不为 0 时，说明注册失败
                                // 显示后端响应的失败信息
                                this.$message({
                                    message: res.data.msg,
                                    type: "warning",
                                });
                            }
                            // 不管响应成功还是失败，收到后端响应的消息后就不再让登录按钮显示加载动画了
                            _this.loading = false;
                            console.log(_this.rgForm.username);
                            console.log(res);
                        });
                    } else { // 如果账号或密码有一个没填，就直接提示必填，不向后端请求
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
