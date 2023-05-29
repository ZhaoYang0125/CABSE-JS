<template>
    <div>
<<<<<<< HEAD
        <h2>欢迎{{ user.uname }}！您的 uid 为{{ user.uid }}</h2>
        <el-button @click="logout"> 登出 </el-button>
        <el-button @click="toRescue">
            window.open跳转到外部链接测试
        </el-button>
        <router-link to = "www.baidu.com">www.baidu.com</router-link>
=======
        <h2>欢迎{{ user.username }}！您的 uid 为{{ user.uid }}</h2>
        <el-button @click="logout"> 登出 </el-button>
<!--        <el-button @click="toRescue">-->
<!--            window.open跳转到外部链接测试-->
<!--        </el-button>-->
<!--        <router-link to = "www.baidu.com">www.baidu.com</router-link>-->
>>>>>>> 12b034c2812629d7e01993e4b12de100c48a99fd
    </div>


</template>

<script>
    export default {
        data() {
            return {
                user: {
<<<<<<< HEAD
                    uname: "",
                    uid: null,
                    url: 'https://www.baid.com/',
=======
                    username: "",
                    uid: null,
                    // url: 'https://www.baid.com/',
>>>>>>> 12b034c2812629d7e01993e4b12de100c48a99fd
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
<<<<<<< HEAD
            toRescue() {
                window.open('https://www.baidu.com',"_blank");
                // window.location.href = this.url;
                // window.location.reload();
            },
=======
            // toRescue() {
            //     window.open('https://www.baidu.com',"_blank");
            //     // window.location.href = this.url;
            //     // window.location.reload();
            // },
>>>>>>> 12b034c2812629d7e01993e4b12de100c48a99fd
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
<<<<<<< HEAD
</style>
=======
</style>
>>>>>>> 12b034c2812629d7e01993e4b12de100c48a99fd
