<template>
    <el-container>
        <el-header>Head: CET6 六级成绩查询</el-header>
        <el-container>
            <el-main>
                <el-row>
                    <el-input v-model="paperid" placeholder="请输入要查询的考试号" style="width:400px; text-align: center"></el-input><el-button type="primary" @click="onSearch">查询</el-button>
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
            </el-main>
        </el-container>
    </el-container>
</template>

<script>
    export default {
        data() {
            return {
                paperid: null,
                user: {
                    username: "",
                    uid: null,
                },
                grade: {
                    total: null,
                    listening: null,
                    comprehension: null,
                    writing: null,
                    translation: null,
                    pass: false,
                    get: false
                }
            }
        },

        methods: {
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
                        this.$router.push("/home");
                    }

                })
            },
        }
    }
</script>

<style scoped>
    .el-container{
        /*text-align: left;*/
    }
    /* 设置成绩面板居中，宽度为400px */
    .box-card {
        margin: auto auto;
        width: 400px;
    }
</style>