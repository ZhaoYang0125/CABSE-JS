<template>
    <el-container>
        <!--            <el-button @click="dialogVisible = true">登录</el-button>-->
        <el-header height="100%" style="width: 90%; margin: auto">
            <el-row gutter="20" class="HdBgImg">
                <el-col :span="6" offset="2">
                    <el-image :src="cet6" :fit="fit"></el-image>
                </el-col>
            </el-row>
            <el-row gutter="20" >
                <el-tabs v-model="activeName" @tab-click="handleClick" stretch="true" style="background-color: lightgray">
                    <el-tab-pane label="首页" name="1"></el-tab-pane>
                    <el-tab-pane label="考试简介" name="2"></el-tab-pane>
<!--                    <el-tab-pane label="考生须知" name="3"></el-tab-pane>-->
<!--                    <el-tab-pane label="考试时间" name="4"></el-tab-pane>-->
<!--                    <el-tab-pane label="报名流程" name="5"></el-tab-pane>-->
                    <el-tab-pane label="常见问题" name="6"></el-tab-pane>
                    <el-tab-pane label="成绩报告单" name="7"></el-tab-pane>
                    <el-tab-pane label="联系我们" name="8"></el-tab-pane>
                </el-tabs>
            </el-row>
        </el-header>
        <el-main>
            <el-row style="width: 90%; margin: auto">
                <el-carousel ref="ca" indicator-position="none" height="350px" :autoplay="false" arrow="never">
                    <el-carousel-item v-for="item in URLArr" :key="item">
                        <el-image
                                :src=item
                                :fit="fit"></el-image>
                    </el-carousel-item>
                </el-carousel>
            </el-row>
            <el-row>
                <el-col :span="20" offset="2">
                    <el-steps :active="active" finish-status="success">
                        <el-step title="注册" icon="el-icon-user-solid"></el-step>
                        <el-step title="登录" icon="el-icon-user"></el-step>
                        <el-step title="完善信息" icon="el-icon-info"></el-step>
                        <el-step title="报名" icon="el-icon-s-promotion"></el-step>
                        <el-step title="缴费" icon="el-icon-s-finance"></el-step>
                        <el-step title="报名成功" icon="el-icon-check"></el-step>
                    </el-steps>
                </el-col>
<!--                <el-col :span="2">-->
<!--                    <el-button style="margin-top: 12px;background-color: white" @click="next">下一步</el-button>-->
<!--                </el-col>-->
            </el-row>
            <el-row style="margin-top: 40px; margin-left: 100px; margin-right: 100px">
                <el-col :span="8">
                    <el-menu
                            default-active="2"
                            class="el-menu-vertical-demo"
                            background-color="#F1ACDB"
                            active-text-color="#E6A23C">
                        <el-menu-item style="height: 100px; margin-top: 10px; margin-bottom: 10px">
                            <i class="el-icon-menu"></i>
                            <router-link to="/login">
                                <el-button >进入报名</el-button>
                            </router-link>
                        </el-menu-item>
                        <el-menu-item style="height: 100px; margin-top: 10px; margin-bottom: 10px">
                            <i class="el-icon-document"></i>
                            <router-link to="/login-teacher">
                                <el-button>教师入口</el-button>
                            </router-link>
                        </el-menu-item>
                        <el-menu-item style="height: 100px; margin-top: 10px; margin-bottom: 10px">
                            <i class="el-icon-setting"></i>
                            <router-link to="/login-admin">
                                <el-button >管理入口</el-button>
                            </router-link>
                        </el-menu-item>
                    </el-menu>
                </el-col>

                <el-col :span="8">
                    <el-image :src="midImg" :fit="fit"></el-image>
                </el-col>

                <el-col :span="8">
                    <el-menu
                        background-color="#1C534F"
                        text-color="#fff"
                        active-text-color="#2F8A84">
                        <el-menu-item>
                            <i class="el-icon-setting"></i>
                            <span slot="title">CET考试最新动态</span>
                        </el-menu-item>
                        <el-menu-item style="height: 280px">
                            <p style="text-align: left;">
                            <strong>
                                2023年上半年考试时间：
                            </strong><br>
                            笔试：6-17<br>
                            上午：英语、日语、德语、俄语、法语四级<br>
                            下午：英语、日语、德语、俄语六级<br>
                            </p>

                        </el-menu-item>
                    </el-menu>

                </el-col>
            </el-row>
        </el-main>
    </el-container>
</template>

<script>
    export default {
        name: "Index",
        data(){
            return {
                activeName: '1',
                carousel: '',
                active: 0,
                dialogVisible: false,
                cet6:'https://cet.neea.edu.cn/res/Home/node/161230188.jpg',
                URLArr: [
                    require("@/assets/index/1.png"),
                    require("@/assets/index/2.png"),
                    require("@/assets/index/3.png"),
                    require("@/assets/index/4.png"),
                    require("@/assets/index/5.png"),
                    require("@/assets/index/6.png"),
                    require("@/assets/index/7.png"),
                    require("@/assets/index/8.png"),
                ],
                midImg: require("@/assets/index/9.png"),
            }
        },
        methods: {
            handleClick(tab) {
                this.$refs.ca.setActiveItem(tab.name - 1);
                console.log(tab);
            },
            next() {
                if (this.active++ > 5) this.active = 0;
            }
        }
    }
</script>

<style scoped>
    .HdBgImg{
        background-image:url("https://resource.neea.edu.cn/project/CET/images/ad_bg.jpg")
    }
    .el-button{
        background-color: #922C7E;
        width: 80%;
        height: 80%;
        margin-top: 10px;
        font-size: large;
        color: rosybrown
    }
</style>