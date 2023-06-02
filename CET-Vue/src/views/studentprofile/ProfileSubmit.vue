<template>
    <div>
        <el-card class="box-card">
            <h2>完善个人信息</h2>
            <el-form
                    :model="ruleForm"
                    status-icon
                    :rules="rules"
                    ref="ruleForm"
                    label-position="left"
                    label-width="80px"
                    class="demo-ruleForm"
            >
                <el-form-item label="学生姓名" prop="sname">
                    <el-input v-model="ruleForm.sname"></el-input>
                </el-form-item>

                <el-form-item label="性别" prop="gender">
                    <el-input
                            v-model="ruleForm.gender"
                            autocomplete="off"
                    ></el-input>
                </el-form-item>

                <el-form-item label="年龄" prop="age">
                    <el-input
                            v-model="ruleForm.age"
                            autocomplete="off"
                    ></el-input>
                </el-form-item>

                <el-form-item label="学校" prop="school">
                    <el-input
                            v-model="ruleForm.school"
                            autocomplete="off"
                    ></el-input>
                </el-form-item>

            </el-form>

            <div class="btnGroup">
                <el-button type="primary" @click="submitForm('ruleForm')"  v-loading="loading">提交</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
                <el-button @click="goBack">返回</el-button>
            </div>
        </el-card>
    </div>
</template>

<script>
    export default {
        name: "ProfileSubmit",
        data() {
            return {
                ruleForm: {
                    // sid : null,
                    sname : "",
                    gender: "",
                    age : null,
                    school : "",
                },
                rules: {
                    sname: [
                        { required: true, message: "学生姓名不能为空！", trigger: "blur" },
                    ],
                    gender: [
                        { required: true, message: "性别不能为空！", trigger: "blur"},
                    ],
                    age: [
                        { required: true, message: "年龄不能为空！", trigger: "blur" },
                    ],
                    school: [
                        { required: true, message: "学校不能为空！", trigger: "blur" },
                    ],
                },
                user: {
                    username: "",
                    uid: null,
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
                    // 如果经过校验，都不为空，则发送请求到后端登录接口
                    if (valid) {
                        let _this = this;
                        // 使用axios将信息发送到后端
                        this.axios({
                            url: "/api/studentprofile/profile",               // 请求地址
                            method: "post",                       // 请求方法
                            headers: {                            // 请求头
                                "Content-Type": "application/json",
                            },
                            data: {                             // 请求参数
                                uid: _this.user.uid,
                                // sid: _this.ruleForm.sid,
                                sname: _this.ruleForm.sname,
                                gender: _this.ruleForm.gender,
                                age: _this.ruleForm.age,
                                school: _this.ruleForm.school
                            },
                        }).then((res) => { // 当收到后端的响应时执行该括号内的代码，res 为响应信息，也就是后端返回的信息
                            if (res.data.code === "0") {  // 当响应的编码为 0 时，说明成功
                                // 跳转页面到首页
                                this.$router.push({
                                    path: '/showprofile',
                                    query: {
                                        uid: this.user.uid,
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

                    } else {  // 如果有一个没填，就直接提示必填，不向后端请求
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
            if (sessionStorage.getItem('userInfo')) {
                this.user = JSON.parse(sessionStorage.getItem('userInfo'));
            }
        },
    }
</script>

<style scoped>

</style>
