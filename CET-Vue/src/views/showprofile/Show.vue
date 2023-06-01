<template>
    <div>
        <!-- TODO: 页面刷新了吗？-->
        <div>账号id: {{uid}}</div>
        <div>学生id: {{sid}}</div>
        <div>学生姓名: {{sname}}</div>
        <div>性别: {{gender}}</div>
        <div>年龄: {{age}}</div>
        <div>学校: {{school}}</div>
    </div>
</template>

<script>
    import {EventBus} from 'src/eventbus/event-bus.js' // 引入事件中心
    export default {
        name: "Show",
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
            informationFromProfileSubmit() {
                EventBus.$on('profileSubmitToShow', param => {
                    this.uid = param.uid;
                    this.sid = param.sid;
                    this.sname = param.sname;
                    this.gender = param.gender;
                    this.age = param.age;
                    this.school = param.school;
                })
            }
        }
    }
</script>

<style scoped>

</style>
