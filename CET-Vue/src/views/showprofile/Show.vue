<template>
    <div>
        <div>账号id: {{uid}}</div>
        <div>准考证号: {{examid}}</div>
        <div>学生姓名: {{sname}}</div>
        <div>性别: {{gender}}</div>
        <div>年龄: {{age}}</div>
        <div>学校: {{school}}</div>
        <div>专业: {{majerity}}</div>
        <div>入学年份: {{enrollmentyear}}</div>
        <div>学历: {{degree}}</div>
        <div class="btnGroup">
            <el-button @click="goBack">返回</el-button>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Show",
        created(){
            this.uid = this.$route.query.uid;
            this.examid = this.$route.query.examid;
            this.sname = this.$route.query.sname;
            this.gender = this.$route.query.gender;
            this.age = this.$route.query.age;
            this.school = this.$route.query.school;
            this.majerity = this.$route.query.majerity;
            this.enrollmentyear = this.$route.query.enrollmentyear;
            this.degree = this.$route.query.degree;
        },

        data() {
            return {
                uid : "",
                examid : "",
                sname : "",
                gender: "",
                age : "",
                school : "",
                majerity : "",
                enrollmentyear : "",
                degree : "",
            };
        },

        methods: {
            goBack() {
                this.$router.go(-1);
            },
        }
    }
</script>

<style scoped>

</style>
