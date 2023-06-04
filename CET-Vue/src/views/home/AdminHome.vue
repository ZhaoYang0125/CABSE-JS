<template>
    <el-container>
        <el-aside>Aside
            <el-row>
                <el-col>
                    <router-link to="/questionInput">
                        <el-button type="danger">试卷录入</el-button>
                    </router-link>
                </el-col>
            </el-row>
            <el-row>
                <el-col>
<!--                    <router-link to="/questionInput">-->
                    <el-button type="info" @click="$message('敬请期待');">教师信息管理</el-button>
<!--                    </router-link>-->
                </el-col>
            </el-row>
        </el-aside>
        <el-container>
            <el-header>
                <h2>学生信息管理</h2>
            </el-header>
            <el-main>
                <div>
                    <el-table border :data="tableData" stripe style="width: 100%;margin-bottom: 20px">
                        <el-table-column prop="uid" label="账号"></el-table-column>
                        <el-table-column prop="sname" label="姓名"></el-table-column>
                        <el-table-column prop="school" label="学校"></el-table-column>
                        <el-table-column prop="sid" label="学号"></el-table-column>
                        <el-table-column prop="gender" label="性别"></el-table-column>
                        <el-table-column prop="age" label="年龄"></el-table-column>
                        <el-table-column label="操作">
                            <template slot-scope="scope">
                                <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                                <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                <el-row>
                    <el-button @click="dialogFormVisible = !dialogFormVisible">添加</el-button>
                </el-row>
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
                        <el-form-item label="学号" :label-width="formLabelWidth">
                            <el-input v-model="form.sid" autocomplete="off"></el-input>
                        </el-form-item>
                        <el-form-item label="性别" :label-width="formLabelWidth">
                            <el-select v-model="form.gender" placeholder="请选择性别">
                                <el-option label="男" value=0></el-option>
                                <el-option label="女" value=1></el-option>
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
                    sid: '',
                    sname: '',
                    school: '',
                    gender: '',
                    age: '',
                },
                formLabelWidth: '120px',

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
                    sid: [
                        {required: true, message: "学号不能为空！", trigger: "blur"},
                    ],
                    uid: [
                        {required: true, message: "账号不能为空！", trigger: "blur"},
                    ],
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
                let _this = this;
                this.form.uid = row.uid;
                this.form.sid = row.sid;
                this.form.sname = row.sname;
                this.form.school = row.school;
                this.form.gender = row.gender;
                this.form.age = row.age;
                this.dialogFormVisible = true;
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
                this.axios({
                    url: "/api/studentprofile/profile",               // 请求地址
                    method: "post",                       // 请求方法
                    headers: {                            // 请求头
                        "Content-Type": "application/json",
                    },
                    data: {                             // 请求参数
                        uid: _this.form.uid,
                        sid: _this.form.sid,
                        sname: _this.form.sname,
                        gender: _this.form.gender,
                        age: _this.form.age,
                        school: _this.form.school
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
            },
        }
    }
</script>

<style scoped>

</style>