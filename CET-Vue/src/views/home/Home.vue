<template>
    <div>
        <h2>欢迎{{ user.uname }}！您的 uid 为{{ user.uid }}</h2>
        <el-button @click="logout"> 登出 </el-button>
        <el-button @click="toRescue">
            window.open跳转到外部链接测试
        </el-button>
        <router-link to = "www.baidu.com">www.baidu.com</router-link>
    </div>


</template>

<script>
    export default {
        data() {
            return {
                user: {
                    uname: "",
                    uid: null,
                    url: 'https://www.baid.com/',
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
            toRescue() {
                window.open('https://www.baidu.com',"_blank");
                // window.location.href = this.url;
                // window.location.reload();
            },
        },
        mounted() {
            if (sessionStorage.getItem('userInfo')) {
                // 将用户信息存储到sessionStorage中
                this.user = JSON.parse(sessionStorage.getItem('userInfo'));
            }
        },

    };
</script>

<style scoped>
</style>