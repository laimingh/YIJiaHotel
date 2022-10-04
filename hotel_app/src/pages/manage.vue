<template>
  <div id="index" >
    <mu-appbar style="width: 100%;" class="appBar" z-depth="0" color="primary">
      <mu-button icon slot="left" @click="open = !open">
        <mu-icon value="menu"></mu-icon>
      </mu-button>
      <mu-button flat  @click="navigateTo('/about')"><h2>管理员界面</h2></mu-button>
      <mu-menu slot="right" open-on-hover v-if="this.isLogin()">
        <mu-button flat>
          <mu-chip class="demo-chip" color="primary">
            <mu-avatar :size="32" color="secondary">
              <mu-icon value="account_circle"> </mu-icon>
            </mu-avatar>
            {{ username  }}
          </mu-chip>
        </mu-button>
        <mu-list slot="content">
          <mu-list-item button @click="navigateTo('/adminProfile')">
            <mu-list-item-content>
              <mu-list-item-title>查看个人信息</mu-list-item-title>
            </mu-list-item-content>
          </mu-list-item>
          <mu-list-item button @click="confirm()">
            <mu-list-item-content>
              <mu-list-item-title>注销</mu-list-item-title>
            </mu-list-item-content>
          </mu-list-item>
        </mu-list>
      </mu-menu>
      <mu-button v-if="!this.isLogin()" round flat slot="right" @click="navigateTo('/login')">登 录</mu-button>
    </mu-appbar>
    <router-view class="layout" />
    <!--<div class="footer">-->
    <!--地址：<b> {{ hotelInfo.address }} </b>-->
    <!--电话号码： <b> {{ hotelInfo.telephone }} </b>-->
    <!--电子邮箱：<b> {{ hotelInfo.email }} </b>-->
    <!--</div>-->
    <mu-drawer :open.sync="open" :docked="docked" :z-depth="24" >
      <mu-list @click="open = !open">
        <!--<mu-list-item>-->
        <!--<mu-list-item-title></mu-list-item-title>-->
        <!--<mu-list-item-action >-->
        <!--<mu-button icon @click="open = false">-->
        <!--<mu-icon value="close"></mu-icon>-->
        <!--</mu-button>-->
        <!--</mu-list-item-action>-->
        <!--</mu-list-item>-->
        <mu-list-item button @click="navigateTo('/about')">
          <mu-list-item-action>
            <i class="el-icon-thumb" style="font-size: 28px" ></i>
          </mu-list-item-action>
          <mu-list-item-title>管理首页</mu-list-item-title>
        </mu-list-item>

        <mu-list-item button @click="navigateTo('/manageIndex')">
          <mu-list-item-action>
            <mu-icon value="home"></mu-icon>
          </mu-list-item-action>
          <mu-list-item-title>
            销售情况
          </mu-list-item-title>
        </mu-list-item>
<!--        <mu-list-item button @click="navigateTo('/roomState')">-->
<!--          <mu-list-item-action>-->
<!--            <mu-icon value="hotel"></mu-icon>-->
<!--          </mu-list-item-action>-->
<!--          <mu-list-item-title>-->
<!--            查看客房状态-->
<!--          </mu-list-item-title>-->
<!--        </mu-list-item>-->
        <mu-list-item button @click="navigateTo('/salesNums')">
          <mu-list-item-action>
            <i class="el-icon-s-data" style="font-size: 28px" ></i>
          </mu-list-item-action>
          <mu-list-item-title>客房状态</mu-list-item-title>
        </mu-list-item>
        <mu-list-item button @click="navigateTo('/checkIn')">
          <mu-list-item-action>
            <i class="el-icon-coin" style="font-size: 28px" ></i>
          </mu-list-item-action>
          <mu-list-item-title>入住登记</mu-list-item-title>
        </mu-list-item>
        <mu-list-item button @click="navigateTo('/userConfig')">
          <mu-list-item-action>
            <i class="el-icon-coordinate" style="font-size: 28px" ></i>
          </mu-list-item-action>
          <mu-list-item-title>用户管理</mu-list-item-title>
        </mu-list-item>

        <!--<mu-list-item  @click="open = false" button>-->
        <!--<mu-list-item-action>-->
        <!--<mu-icon value="chevron_left"></mu-icon>-->
        <!--</mu-list-item-action>-->
        <!--<mu-list-item-title>关闭侧边栏</mu-list-item-title>-->
        <!--</mu-list-item>-->
      </mu-list>
    </mu-drawer>
<!--    <div class="footer">-->
<!--      Copyright @ 2022 <b> {{ hotelInfo.hotelName }} </b><br>-->
<!--      地址：<b> 明兰街道</b><br>-->
<!--      电话号码： <b> 14796703635 </b><br>-->
<!--      电子邮箱：<b>1938868551@qq.com </b><br>-->
<!--      网页地址：<b>  <a href="http://laicl.vip" style="color: white" >laicl.vip</a></b>-->
<!--    </div>-->
  </div>
</template>

<script>
import Cookies from 'js-cookie'
import { getAllHotel } from "@/api/hotel"
export default {
  name: "Index",
  data() {
    return {
      username : Cookies.get("username"),
      open: false,
      docked: false,
      right: false,
      hotelInfo: {
        hotelName: "ho",
        address: null
      }
    }
  },
  created: function(){
    this.fetchData()
  },
  methods: {
    navigateTo(val){
      this.$router.push(val)
    },
    logout(){
      Cookies.remove("username")
      Cookies.remove("user_id")
      Cookies.remove("session")
      Cookies.remove("order_id")
      this.navigateTo("/")
      this.$router.go(0)
    },
    fetchData(){
      // console.log(123456)
      getAllHotel().then(res => {
        // console.log(res)
        this.hotelInfo = res.data[0]
      }).catch(err => {
        console.log(err)
        this.$toast.error(err.toString())
      })
    },

    //  退出提示
    confirm () {
      this.$confirm('确定要注销？', '提示', {
        type: 'warning'
      }).then(({ result }) => {
        if (result) {
          this.logout()
        } else {
          this.$toast.message('点击了取消');
        }
      });
    },
  }
}
</script>

<style scoped>
#index{
  padding: 0;

}
.appBar{
  color: #fff;
  position: fixed;
  left: 0;
  right: 0;
  top: 0;
  z-index: 101;
  overflow: hidden;
  height:60px;
  /*background-image: linear-gradient(270deg,#8146b4,#6990f6);*/
}
.footer{
  text-align: center;
  color: #fff;
  padding: 50px 40px;
  /*background-image: linear-gradient(270deg,#8146b4,#6990f6);*/
  background-color: #2196f3;
}
.layout{
  margin-top: 60px;
}

.footer{
  text-align: center;
  color: #fff;
  padding: 30px 40px;
  background-color: #2196f3;
  background-image: linear-gradient(270deg,#fbc4c4,#6990f6);
}
</style>
