<template>
    <div>
        <el-container>
            <el-aside>
                <router-link to="/questionInput">
                    <el-button  icon="el-icon-edit" plain type="primary">试卷录入</el-button>
                    <el-button type="info" @click="logout" plain>登 出</el-button>
                </router-link>
            </el-aside>
            <el-container>
                <el-header>
                    <h2>学生信息管理</h2>
                </el-header>
                <el-main>
                    <div>
                        <el-table border :data="tableData" stripe style="width: 100%;margin-bottom: 20px"
                                  :header-cell-style="{ background: '#cbf1f3', fontSize:'16px',color:'black',fontweight:400}" >
                            <el-table-column prop="uid" label="账号" align="center"></el-table-column>
                            <el-table-column prop="sname" label="姓名" align="center"></el-table-column>
                            <el-table-column prop="school" label="学校" align="center"></el-table-column>
                            <el-table-column prop="majerity" label="专业" align="center"></el-table-column>
                            <el-table-column prop="enrollmentyear" label="入学年份" align="center"></el-table-column>
                            <el-table-column prop="degree" label="学历" align="center"></el-table-column>
                            <el-table-column prop="examid" label="准考证号" align="center"></el-table-column>
                            <el-table-column prop="gender" label="性别" align="center"></el-table-column>
                            <el-table-column prop="age" label="年龄" align="center"></el-table-column>
                            <el-table-column label="操作">
                                <template slot-scope="scope">
                                    <el-button size="mini" type="primary" icon="el-icon-edit"  @click="handleEdit(scope.$index, scope.row) "plain>编辑</el-button>
                                    <br></br>
                                    <el-button size="mini" type="danger" icon="el-icon-delete"  @click="handleDelete(scope.$index, scope.row)"plain>删除</el-button>
                                </template>
                            </el-table-column>
                        </el-table>
                        <el-button type="success" icon="el-icon-edit" @click="dialogFormVisible = !dialogFormVisible" plain>添加</el-button>
                    </div>
                    <el-dialog title="学生信息" :visible.sync="dialogFormVisible">
                        <el-form :model="form" :rules="rules">
                            <el-form-item label="账号" :label-width="formLabelWidth">
                                <el-input v-model="form.uid" autocomplete="off"></el-input>
                            </el-form-item>
                            <el-form-item label="姓名" :label-width="formLabelWidth">
                                <el-input v-model="form.sname" autocomplete="off"></el-input>
                            </el-form-item>
                            <el-form-item label="学校" :label-width="formLabelWidth">
                                <el-input v-model="form.school" autocomplete="off"></el-input>
                            </el-form-item>
                            <el-form-item label="专业" :label-width="formLabelWidth">
                                <el-input v-model="form.majerity" autocomplete="off"></el-input>
                            </el-form-item>
                            <el-form-item label="入学年份" :label-width="formLabelWidth">
                                <el-input v-model="form.enrollmentyear" autocomplete="off"></el-input>
                            </el-form-item>
                            <el-form-item label="学历" :label-width="formLabelWidth">
                                <el-input v-model="form.degree" autocomplete="off"></el-input>
                            </el-form-item>
                            <el-form-item label="准考证号" :label-width="formLabelWidth">
                                <el-input v-model="form.examid" autocomplete="off"></el-input>
                            </el-form-item>
                            <el-form-item label="性别" :label-width="formLabelWidth">
                                <el-select v-model="form.gender" placeholder="请选择性别">
                                    <el-option label="男" value="男"></el-option>
                                    <el-option label="女" value="女"></el-option>
                                </el-select>
                            </el-form-item>
                            <el-form-item label="年龄" :label-width="formLabelWidth">
                                <el-input v-model="form.age" autocomplete="off"></el-input>
                            </el-form-item>
                        </el-form>
                        <div slot="footer" class="dialog-footer">
                            <el-button @click="dialogFormVisible = false">取 消</el-button>
                            <el-button type="primary" @click="submitForm('form')">确 定</el-button>
                        </div>
                    </el-dialog>

                </el-main>
                <el-footer>
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
            </el-container>
        </el-container>
    </div>
</template>

<script>
    export default {
        name: "AdminHome",
        data() {
            return {
                page: 1,
                total: 10,
                pageSize: 5,
                tableData: [],
                dialogFormVisible: false,
                form: {
                    uid: '',
                    examid: '',
                    sname: '',
                    school: '',
                    majerity : "",
                    enrollmentyear : "",
                    degree : "",
                    gender: '',
                    age: '',
                },
                formLabelWidth: '120px',
                isEdit: false,

                rules: {
                    sname: [
                        {required: true, message: "学生姓名不能为空！", trigger: "blur"},
                    ],
                    gender: [
                        {required: true, message: "性别不能为空！", trigger: "blur"},
                    ],
                    age: [
                        {required: true, message: "年龄不能为空！", trigger: "blur"},
                    ],
                    school: [
                        {required: true, message: "学校不能为空！", trigger: "blur"},
                    ],
                    majerity: [
                        { required: true, message: "专业不能为空！", trigger: "blur" },
                    ],
                    enrollmentyear: [
                        { required: true, message: "入学年份不能为空！", trigger: "blur" },
                    ],
                    degree: [
                        { required: true, message: "学历不能为空！", trigger: "blur" },
                    ],
                    examid: [
                        {required: true, message: "准考证号不能为空！", trigger: "blur"},
                    ],
                    // uid: [
                    //     {required: true, message: "账号不能为空！", trigger: "blur"},
                    // ],
                }
            }
        },
        created() {
            this.loadData()
        },
        methods: {
            pageChange(page) {
                this.page = page,
                    this.loadData()
            },
            loadData() {
                this.axios({
                    url: "/api/studentprofile/getDataList",               // 请求地址
                    method: "get",                       // 请求方法
                    headers: {                            // 请求头
                        "Content-Type": "application/json",
                    },
                }).then(res => {
                    this.tableData = res.data.data;
                    this.total = res.data.data.length;
                }).catch(e => {
                    console.log(e)
                })
            },
            handleEdit(index, row) {
                // let _this = this;
                this.form.uid = row.uid;
                this.form.examid = row.examid;
                this.form.sname = row.sname;
                this.form.school = row.school;
                this.form.majerity = row.majerity;
                this.form.enrollmentyear = row.enrollmentyear;
                this.form.degree = row.degree;
                this.form.gender = row.gender;
                this.form.age = row.age;
                this.dialogFormVisible = true;
                this.isEdit = true;

            },
            handleDelete(index, row) {
                this.axios({
                    url: "/api/studentprofile/delete",               // 请求地址
                    method: "post",                       // 请求方法
                    headers: {                            // 请求头
                        "Content-Type": "application/json",
                    },
                    params: {                             // 请求参数
                        uid: row.uid,
                    },
                }).then(res => {
                    this.loadData()
                    this.$message('删除成功! 姓名: ' + row.sname);
                }).catch(e => {
                    console.log(e)
                })
            },
            submitForm(formName) {
                let _this = this;
                // 使用axios将信息发送到后端
                if (_this.isEdit == false) {
                    this.axios({
                        url: "/api/studentprofile/profile",               // 请求地址
                        method: "post",                       // 请求方法
                        headers: {                            // 请求头
                            "Content-Type": "application/json",
                        },
                        data: {                             // 请求参数
                            uid: _this.form.uid,
                            examid: _this.form.examid,
                            sname: _this.form.sname,
                            gender: _this.form.gender,
                            age: _this.form.age,
                            school: _this.form.school,
                            majerity: _this.form.majerity,
                            enrollmentyear: _this.form.enrollmentyear,
                            degree: _this.form.degree,
                        },
                    }).then((res) => { // 当收到后端的响应时执行该括号内的代码，res 为响应信息，也就是后端返回的信息
                        if (res.data.code === "0") {
                            // 显示后端响应的成功信息
                            this.$message({
                                message: res.data.msg,
                                type: "success",
                            });
                            this.loadData()
                            this.dialogFormVisible = false
                        } else {  // 当响应的编码不为 0 时，说明失败
                            // 显示后端响应的失败信息
                            this.$message({
                                message: res.data.msg,
                                type: "warning",
                            });
                        }
                        console.log(res);
                    });
                } else {
                    this.axios({
                        url: "/api/studentprofile/modifyprofile",               // 请求地址
                        method: "post",                       // 请求方法
                        headers: {                            // 请求头
                            "Content-Type": "application/json",
                        },
                        data: {                             // 请求参数
                            uid: _this.form.uid,
                            examid: _this.form.examid,
                            sname: _this.form.sname,
                            gender: _this.form.gender,
                            age: _this.form.age,
                            school: _this.form.school,
                            majerity: _this.form.majerity,
                            enrollmentyear: _this.form.enrollmentyear,
                            degree: _this.form.degree,
                        },
                    }).then((res) => { // 当收到后端的响应时执行该括号内的代码，res 为响应信息，也就是后端返回的信息
                        if (res.data.code === "0") {
                            // 显示后端响应的成功信息
                            this.$message({
                                message: res.data.msg,
                                type: "success",
                            });
                            this.loadData()
                            this.dialogFormVisible = false
                        } else {  // 当响应的编码不为 0 时，说明失败
                            // 显示后端响应的失败信息
                            this.$message({
                                message: res.data.msg,
                                type: "warning",
                            });
                        }
                        console.log(res);
                    });
                }
                this.isEdit = false;
            },


            logout() {
                // 跳转页面到登录页
                this.$router.push('/login-admin');
                // 移除本地用户登录信息
                sessionStorage.removeItem('userInfo');
            },
        }
    }
</script>

<style scoped>
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
        background-color: #e3fdfb;
        color: #333;
        text-align: center;
        height: calc(100vh - 100px);
    }
    .el-container{
        weight:100%;
        height:100%;
    }
</style>
