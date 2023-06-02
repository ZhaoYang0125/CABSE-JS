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
                // TODO:
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
