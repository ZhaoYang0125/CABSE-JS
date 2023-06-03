<template>
<!--    <div>-->
<!--        <h2>欢迎{{ user.username }}！您的 uid 为{{ user.uid }}</h2>-->
<!--        <el-button @click="logout"> 登出 </el-button>-->
<!--    </div>-->
<div>
    请输入要批改的试卷ID
    <el-input v-model="findForm.paperid" style="width: 80px;margin-left: 0px"></el-input>&nbsp;&nbsp;&nbsp;
    请输入要批改的学生ID
    <el-input v-model="findForm.sid" style="width: 80px"></el-input>&nbsp;&nbsp;
    <el-button @click="findStudentAnswer">查询</el-button>
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
            <td><el-input v-model="writing.score"></el-input></td>
        </tr>
        <tr>
            <td>翻译</td>
            <td>{{translation.answer}}</td>
            <td>106.5</td>
            <td><el-input v-model="translation.score"></el-input></td>
        </tr>
        </tbody>
    </table>
    <el-button @click="findLastAnswer">上一页</el-button>
    <el-button @click="findNextAnswer">下一页</el-button>
</div>
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
                    sid:0
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
            findStudentAnswer(){

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
        width: 480px;
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
</style>
