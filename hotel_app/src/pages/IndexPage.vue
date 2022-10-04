<template>
  <div class="hello">
      <div class="header">
        <mu-paper class="banner">
          <img src="https://pic.imgdb.cn/item/62319dfb5baa1a80abe9583d.png" class="logo">
          <h1>{{ hotelInfo.hotelName }}</h1>
          <h2>一家国际化连锁经营的大型酒店</h2>
          <p v-if="!isLogin()">
            <mu-button color="secondary" @click="navigateTo('/login')">
              <b>立即登录</b>
            </mu-button>
            <mu-button @click="navigateTo('/register')">立即注册</mu-button>
          </p>
          <p v-else="isLogin()">
            <mu-button color="secondary" @click="navigateTo('/room')">
            浏览热门客房
            </mu-button>
            <mu-button color="" @click="navigateTo('/order')">查看个人订单</mu-button>
          </p>
        </mu-paper>
      </div>
    <!-- -->

    <!---->
    <div class="demo-paper">
        <mu-row>
          <mu-col lg="4" sm="12">
              <img :src="indexImg2">
            <h2>国际化</h2>
            <p>一家国际化连锁经营的大型酒店</p>
          </mu-col>

          <mu-col lg="4" sm="12">
              <img :src="indexImg1">
            <h2>信息化</h2>
            <p>酒店现代化形象的标志，为客户提供方便快捷的服务</p>
          </mu-col>

          <mu-col lg="4" sm="12">
              <img :src="indexImg3">
            <h2>互联网</h2>
            <p>网上预订快捷安全，折扣优惠高达50％！ 不收预订费，价格优惠。</p>
          </mu-col>

        </mu-row>
    </div>
    <!---->
    <div class="footer">
      Copyright @ 2022 <b> {{ hotelInfo.hotelName }} </b><br>
      地址：<b> {{ hotelInfo.address }} </b><br>
      电话号码： <b> {{ hotelInfo.telephone }} </b><br>
      电子邮箱：<b> {{ hotelInfo.email }} </b><br>
      网页地址：<b>  <a href="http://laicl.vip" style="color: white" >{{ hotelInfo.website }}</a></b>
<!--      网页地址：<b>  <a href="http://laicl.vip" style="color: white" >{{ hotelInfo.website }}</a></b>-->

    </div>
  </div>
</template>

<script>
  import indexImg1 from '../assets/imgs/index1.png'
  import indexImg2 from '../assets/imgs/index2.png'
  import indexImg3 from '../assets/imgs/index3.png'
  import colImg from '../assets/banner/banner2.jpg'
  import Cookies from 'js-cookie'
  import { getAllHotel } from "@/api/hotel"

  export default {
  name: 'IndexPage',
  data () {
    return {
      indexImg1,
      indexImg2,
      indexImg3,
      hotelInfo: {
        hotelName: "ho",
        address: ""
      },
      list: [{
        image: colImg,
        title: 'Breakfast',
        author: 'Myron'
      }, {
        image: colImg,
        title: 'Burger',
        author: 'Linyu'
      }, {
        image: colImg,
        title: 'Camera',
        author: 'ruolin'
      }]
    }
  },
  created: function() {
    this.isLogin()
    this.fetchData()
  },
  methods:{
    isLogin() {
      const username = Cookies.get("username")
      if (username == null || username === '') {
        return false;
      }
      else {
        return true
      }
    },

    navigateTo(val) {
      this.$router.push(val);
    },
    fetchData(){
      getAllHotel().then(res => {
        this.hotelInfo = res.data[0]
      }).catch(err => {
        console.log(err)
        this.$toast.error(err.toString())
      })
    },

  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.logo{
  border-radius: 50%;
  width: 100px;
  height: 100px;
}
.header >>>.mu-paper{

  width: 100%;


  /*background: url('../assets/banner/banner1.jpg')  ;*/
  background: url('https://pic.imgdb.cn/item/62319d885baa1a80abe8fa66.png')  ;
  background-repeat:no-repeat;

  overflow: hidden;

  background-size:100% 100%;


}
  .banner {
    /*margin-top: 64px;*/
    display: flex;
    flex-direction: column;
    /*background-image: linear-gradient(270deg,#8146b4,#6990f6);*/
    /*background-color: #2196f3;*/
    /*background-image: url('../assets/banner/banner1.jpg');*/
    /*background: url('../assets/banner/banner1.jpg')  no-repeat 0 0/cover ;*/


    height: 600px;
    align-items: center;
    justify-content: center;
    color: #fff;
  }
.carousel img{
    width: inherit;
  }
.demo-paper,.hello{
  width: 100%;
  text-align: center;
}
  .demo-paper img{
    width: 300px;
  }
  .footer{
    text-align: center;
    color: #fff;
    padding: 50px 40px;
    background-color: #2196f3;
    /*background-image: linear-gradient(270deg,#8146b4,#6990f6);*/
  }
.gridlist-inline-demo {

  display: flex;
  flex-wrap: nowrap;
  overflow-x: auto;
}
</style>
