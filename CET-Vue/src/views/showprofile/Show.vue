<template>
    <div>
        <div>账号id: {{uid}}</div>
        <div>学生id: {{sid}}</div>
        <div>学生姓名: {{sname}}</div>
        <div>性别: {{gender}}</div>
        <div>年龄: {{age}}</div>
        <div>学校: {{school}}</div>
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
            this.sid = this.$route.query.sid;
            this.sname = this.$route.query.sname;
            this.gender = this.$route.query.gender;
            this.age = this.$route.query.age;
            this.school = this.$route.query.school;
        },

        data() {
            return {
                uid : "",
                sid : "",
                sname : "",
                gender: "",
                age : "",
                school : "",
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
