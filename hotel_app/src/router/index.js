import Vue from 'vue'
import Router from 'vue-router'
import IndexLayout from '@/pages/IndexLayout'
import IndexPage from '@/pages/IndexPage'
import Login from '@/pages/Login'
import page404 from '@/pages/404'
import Room from "@/pages/Room"
import MyProfile from '@/pages/MyProfile'
import Order from '@/pages/Order'
import UpdateUserdetails from  '@/pages/UpdateUserdetails'
import MakeOrder from "@/pages/MakeOrder";
import OrderDetail from "@/pages/OrderDetail";
import Register from "@/pages/Register";
import AdminLogin from "@/pages/AdminLogin";
import Manage from "../pages/manage";
import Hotelconfiguration from "../pages/Hotelconfiguration";
import Feedback from "../pages/Feedback";
import ForgetPassword from "../pages/forgetPassword";
import AboutMe from "../pages/AboutMe";
import roomDetail from "@/pages/roomDetails";
import RoomState from "../pages/RoomState";
import SalesNums from "../pages/SalesNums";
import UserConfig from "../pages/UserConfig";
import About from "../pages/about"
import CheckIn from "../pages/CheckIn";
import ManageIndex from "../pages/ManageIndex";
import AdminProfile from "../pages/AdminProfile";

import Cookie from 'js-cookie'
import Toast from 'muse-ui-toast';
Vue.use(Router)

const route = new Router({
  routes: [
    {path:'/forgetPassword',name:'ForgetPassword',component: ForgetPassword},
    { path: '/register', name: 'Register', component: Register },
    {path:'/adminLogin',name:'AdminLogin',component: AdminLogin},
    {path:'/manage',name:'manage',component: Manage},
    { path: '/updateUserdetails', name: 'UpdateUserdetails', component:UpdateUserdetails },
    { path: '/login', name: 'Login', component: Login },
    { path: '/404', name: '404', component: page404 },

    {
      path: '/',
      redirect: '/index',
      component: IndexLayout,
      children: [

        { path: '', name: 'Index', component: IndexPage },
        { path: '/room', name: 'Room', component: Room },
        { path: '/hotelconfiguration', name: 'Hotelconfiguration', component: Hotelconfiguration },
        {path:'/feedBack',name:'Feedback',component: Feedback},
        {path:'/aboutMe',name:'AboutMe',component: AboutMe},
        { path: '/roomDetail', name: 'roomDetail', component: roomDetail },
        { path: '/myProfile', name: 'MyProfile', component: MyProfile,meta: {requireAuth: true,} },
        { path: '/order', name: 'Order', component: Order,meta: {requireAuth: true,} },
        { path: '/orderDetail', name: 'OrderDetail', component: OrderDetail ,meta: {requireAuth: true,}},
        { path: '/makeOrder', name: 'MakeOrder', component: MakeOrder ,meta: {requireAuth: true,}}
      ]
    },
    {
      path: '/AD',
      redirect: '/manage',
      component: Manage,
      children: [
        {path: '/manageIndex',name: 'ManageIndex', component: ManageIndex},
        { path: '', name: 'manage', component: Manage },
        { path: '/roomState', name: 'RoomState', component: RoomState },
        { path: '/adminProfile', name: 'AdminProfile', component: AdminProfile },
        { path: '/salesNums', name: 'SalesNums', component: SalesNums },
        {path:'/userConfig',name:'UserConfig',component: UserConfig},
        {path:'/about',name:'About',component: About},
        {path:'/checkIn',name:'CheckIn',component: CheckIn}
      ]
    },
    { path: '*', redirect: '/404', hidden: true }
  ]
})

route.beforeEach((to,from,next)=>{
  if(to.matched.some((r)=> r.meta.requireAuth )){
    if(Cookie.get('user_id')){
      next();
    }else{
      Toast.warning("请先登录");
      next({
        path:'/login',
        query:{redirect: to.fullPath}
      });
    }
  }else next();
});

export default route
