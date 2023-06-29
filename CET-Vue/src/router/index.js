// 此文件专门负责项目的路由

import VueRouter from "vue-router"

// 引入组件
import Login from '../views/login/Login'
import Register from '../views/register/Register'
import Home from '../views/home/Home'
import { Message } from "element-ui";
import Show from "../views/showprofile/Show";
import ProfileSubmit from "../views/studentprofile/ProfileSubmit";
import TeacherLogin from "../views/login/TeacherLogin";
// import TeacherRegister from "../views/register/TeacherRegister";
import AdminLogin from "../views/login/AdminLogin";
// import AdminRegister from "../views/register/AdminRegister";
import Enroll from "../views/enroll/Enroll";
import QuestionInput from "../views/paper/QuestionInput";
import Grading from "../views/grading/Grading";
import Test from "../views/test/Test";
import AdminHome from "../views/home/AdminHome";
import Grade from "../views/grade/Grade";
import Pay from "../views/pay/Pay";
import Index from "../views/index/Index"

// 创建并暴露一个路由器
const router = new VueRouter({
    mode: 'history',    // 路由模式，该模式不会在地址中显示井号#
    routes: [
        {
            path: '/',          // 路径
            redirect: '/index'  // 重定向
        },
        {
            path: '/index',          // 路径
            component: Index    // 跳转到的组件
        },
        {
            path: '/login',     // 路径
            component: Login    // 跳转到的组件
        },
        {
            path: '/login-teacher',     // 路径
            component: TeacherLogin    // 跳转到的组件
        },
        {
            path: '/login-admin',     // 路径
            component: AdminLogin    // 跳转到的组件
        },
        {
            path: '/register',     // 路径
            component: Register    // 跳转到的组件
        },
        {
            path: '/home',     // 路径
            component: Home    // 跳转到的组件
        },
        {
            path: '/showprofile',
            component: Show
        },
        {
            path: '/studentprofile',
            component: ProfileSubmit
        },
        {
            path: '/enroll',
            component: Enroll
        },
        {
            path: '/questionInput',
            component: QuestionInput
        },
        {
            path: '/grading',     // 路径
            component: Grading    // 跳转到的组件
        },
        {
            path: '/test',     // 路径
            component: Test    // 跳转到的组件
        },
        {
            path: '/adminHome',
            component: AdminHome
        },
        {
            path: '/grade',     // 路径
            component: Grade    // 跳转到的组件
        },
        {
            path: '/pay',
            component: Pay
        },

]
})

// 导航守卫，前置处理
router.beforeEach((to, from, next) => {
    let isAuthenticated = !!sessionStorage.getItem('userInfo')
    // 如果路由要跳转到除了登录和注册的界面的话就判断是否已经登录，如果没有登录就强制跳到登录界面
    if (to.path !== '/index' && to.path !== '/login' && to.path !== '/login-teacher' && to.path!== '/login-admin' && to.path !== '/register' && !isAuthenticated) {
        next({ path: '/login' })
        Message({
            message: '请先登录！',
            type: "warning",
        });
    } else next()
})

export default router;
