<template>
  <div id="Hotelconfiguration">
    <mu-container class="HotelconfigurationPaper">
      <mu-row>
        <mu-appbar class="HotelconfigurationAppBar"  color="#5c6bc0">
          <mu-icon value="whatshot" slot="left"></mu-icon>
          基础配置
        </mu-appbar>
      </mu-row>
    </mu-container>

    <div class="ro" >
      <div class="co">
        <div class="image">
          <img src="https://pic.imgdb.cn/item/622ef5d25baa1a80abbcf842.jpg">
        </div>
        <div class="text">
          <span>玩乐  |  购物</span>
        </div>
      </div>
      <div class="co">
        <div class="image">
          <img src="https://pic.imgdb.cn/item/62303b7f5baa1a80ab498960.jpg">
        </div>
        <div class="text">
          <span>记录  |  漫步</span>
        </div>
      </div>
      <div class="co">
        <div class="image">
          <img src="https://pic.imgdb.cn/item/62303b7f5baa1a80ab49895c.jpg">
        </div>
        <div class="text">
          <span>休息  |  观赏</span>
        </div>
      </div>

    </div>

    <div class="ro" style="float: left;width: 100%;padding-top: 40px;padding-bottom: 30px">
      <div class="co">
        <div class="image">
          <img src="https://pic.imgdb.cn/item/62303b7f5baa1a80ab49895a.jpg">
        </div>
        <div class="text">
          <div class="text">
            <span>享受  |  美食</span>
          </div>
        </div>
      </div>
      <div class="co">
        <div class="image">
          <img src="https://pic.imgdb.cn/item/62303b7f5baa1a80ab498966.jpg">
        </div>
        <div class="text">
          <span>运动  |  娱乐</span>
        </div>
      </div>
      <div class="co">
        <div class="image">
          <img src="https://pic.imgdb.cn/item/6230368b5baa1a80ab44a3c9.jpg">
        </div>
        <div class="text">
          <span>方便  |  停歇</span>
        </div>
      </div>

    </div>

    <mu-button fab style="left: 1400px" @click="touch()">
      <svg t="1647315900462" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2221" width="40" height="40"><path d="M773.6 912.7h-1.2c-37.2-0.4-74.5-0.4-111.8-0.4h-56.9c-38 0-76 0-114.1-0.5-21.1-0.6-41.9-5-61.5-13-33.3-13-52.3-42-52.2-79.7l0.1-141.4c0-78.3 0-156.7 0.7-235 0.1-21.3 13.8-41.3 25.5-51.8 45.3-41.4 94.5-93 115.1-162.6 5.7-19.4 7.9-40.8 10.2-63.4 4.6-45 33.8-74.3 72.8-74.3 15.3 0 30.6 4.6 45.6 13.5 30.1 18.1 50.2 46.5 61.3 87 17.8 64.3 8.7 126.7-1.3 180.2v0.2c-2.3 12.5 7.1 24.1 19.9 24.1h130c22.4 0 54.5 2.8 74.3 26.8 14.4 17.5 18.5 41.1 12.4 72.3-18.6 95.9-41.4 192.6-63.2 282.7-6.8 28.1-18.1 54.1-29 79.3l-4.7 10.8c-12.4 29.2-38 45.2-72 45.2zM216.1 903.3h-11.9c-43 0-78.2-35.2-78.2-78.2V476.6c0-43 35.2-78.2 78.2-78.2h11.9c43 0 78.2 35.2 78.2 78.2V825c0.1 43.1-35.1 78.3-78.2 78.3z" fill="#13227a" p-id="2222"></path></svg><path d="M773.6 912.7h-1.2c-37.2-0.4-74.5-0.4-111.8-0.4h-56.9c-38 0-76 0-114.1-0.5-21.1-0.6-41.9-5-61.5-13-33.3-13-52.3-42-52.2-79.7l0.1-141.4c0-78.3 0-156.7 0.7-235 0.1-21.3 13.8-41.3 25.5-51.8 45.3-41.4 94.5-93 115.1-162.6 5.7-19.4 7.9-40.8 10.2-63.4 4.6-45 33.8-74.3 72.8-74.3 15.3 0 30.6 4.6 45.6 13.5 30.1 18.1 50.2 46.5 61.3 87 17.8 64.3 8.7 126.7-1.3 180.2v0.2c-2.3 12.5 7.1 24.1 19.9 24.1h130c22.4 0 54.5 2.8 74.3 26.8 14.4 17.5 18.5 41.1 12.4 72.3-18.6 95.9-41.4 192.6-63.2 282.7-6.8 28.1-18.1 54.1-29 79.3l-4.7 10.8c-12.4 29.2-38 45.2-72 45.2zM216.1 903.3h-11.9c-43 0-78.2-35.2-78.2-78.2V476.6c0-43 35.2-78.2 78.2-78.2h11.9c43 0 78.2 35.2 78.2 78.2V825c0.1 43.1-35.1 78.3-78.2 78.3z" fill="#333333" p-id="2222"></path>
    </mu-button>
    <div class="tom"></div>
    <div class="more">
      <div align="center" style="font-size:xx-large;padding-top: 30px;padding-bottom: 20px">
        优质服务
      </div>
        <div style="text-align: center;font-size: 15px">---------</div>

      <div align="center" style="font-size:20px;padding-top: 30px;color: #8e9ba1">
        商业精英们可享受各式服务，为您的繁忙行程增添一份温暖!
      </div>

      <div class="cardContainer" style="float: left;width: 100%">
        <div class="card">
          <div class="cardImg">
            <img src="https://pic.imgdb.cn/item/62304d835baa1a80ab56ecda.jpg" width="265px" height="200px">
          </div>
          <div class="cardText">
            <h2 align="center">自助入住、零秒退房</h2>
            <h4 align="center" style="margin-top: 10px;color: #8e9ba1">华住推出华掌柜产品，帮助行程匆忙的旅客实现自助入住、零秒退房</h4>

          </div>
        </div>

        <div class="card">
          <div class="cardImg">
            <img src="https://pic.imgdb.cn/item/62304d835baa1a80ab56ecc0.jpg" width="265px" height="200px">
          </div>
          <div class="cardText">
            <h2 align="center">延迟退房</h2>
            <h4 align="center" style="margin-top: 10px;color: #8e9ba1">针对金会员以上级别可延迟至14:00</h4>

          </div>
        </div>

        <div class="card">
          <div class="cardImg">
            <img src="https://pic.imgdb.cn/item/62304d835baa1a80ab56ecc3.jpg" width="265px" height="200px">
          </div>
          <div class="cardText">
            <h2 align="center">开票立取</h2>
            <h4 align="center" style="margin-top: 10px;color: #8e9ba1">保留您的公司发票信息，后续入住开票无需您再提供发票信息，并可提前打印，退房时无需等待</h4>

          </div>
        </div>

        <div class="card">
          <div class="cardImg">
            <img src="https://pic.imgdb.cn/item/62304d835baa1a80ab56ecc9.jpg" width="265px" height="200px" >
          </div>
          <div class="cardText">
            <h2 align="center" >Hello一家更好的酒店服务</h2>
            <h4 align="center" style="margin-top: 10px;color: #8e9ba1">
              店内在线沟通平台，为您提供24小时暖心服务，随时响应您的需求，解答您的问题，服务触手可及，提供“以你唯一”的专属温暖体验。
            </h4>
          </div>
        </div>

        <div class="card">
          <div class="cardImg">
            <img src="https://pic.imgdb.cn/item/62304d835baa1a80ab56ecd2.jpg" width="265px" height="200px">
          </div>
          <div class="cardText">
           <h2 align="center"> 随心预订</h2>
            <h4 align="center" style="margin-top: 10px;color: #8e9ba1"> 随时随地预订你的住宿，为行程增加一份高效</h4>

          </div>
        </div>

      </div>

    </div>
    <div class="more2">
      <div align="center" style="font-size:xx-large;padding-top: 30px;padding-bottom: 20px">
        成本更低
      </div>
      <div style="text-align: center;font-size: 15px">---------</div>

      <div align="center" style="font-size:20px;padding-top: 30px;color: #8e9ba1">
        [价格成本、时间成本、人力成本、管理成本] 降低15%
      </div>

      <div class="cardContainer" style="float: left;width: 100%">
        <div class="card2">
          <div class="cardImg">
            <img src="https://pic.imgdb.cn/item/62305fe95baa1a80ab6182e9.jpg" width="265px" height="200px">

          </div>
          <div class="cardText">
            <h2 align="center">员工</h2>
            <h4 align="center" style="margin-top: 10px;color: #8e9ba1">以后再也不需要繁琐的报销流程，差旅体验大幅提升</h4>

          </div>
        </div>

        <div class="card2">
          <div class="cardImg">
            <img src="https://pic.imgdb.cn/item/62305fe95baa1a80ab6182d8.jpg" width="265px" height="200px">
          </div>
          <div class="cardText">
            <h2 align="center">行政</h2>
            <h4 align="center" style="margin-top: 10px;color: #8e9ba1">APP、网上都可以预订，方便快捷</h4>

          </div>
        </div>

        <div class="card2">
          <div class="cardImg">
            <img src="https://pic.imgdb.cn/item/62305fe95baa1a80ab6182c0.jpg" width="265px" height="200px">
          </div>
          <div class="cardText">
            <h2 align="center">财务</h2>
            <h4 align="center" style="margin-top: 10px;color: #8e9ba1">结算流程便捷高效，财务效率得到了提升，同时保障了员工差旅透明合规</h4>
          </div>
        </div>

        <div class="card2">
          <div class="cardImg">
            <img src="https://pic.imgdb.cn/item/62305fe95baa1a80ab6182bb.jpg" width="265px" height="200px" >
          </div>
          <div class="cardText">
            <h2 align="center" >老板</h2>
            <h4 align="center" style="margin-top: 10px;color: #8e9ba1">
              公司的价格成本、时间成本、人力成本、管理成本都大幅降低
            </h4>
          </div>
        </div>

        <div class="card2">
          <div class="cardImg">
            <img src="https://pic.imgdb.cn/item/62305fe95baa1a80ab6182cc.jpg" width="265px" height="200px">
          </div>
          <div class="cardText">
            <h2 align="center"> 企业</h2>
            <h4 align="center" style="margin-top: 10px;color: #8e9ba1">享受最优惠价格预订房间的权益</h4>

          </div>
        </div>

      </div>

    </div>
    <div class="footer">
      Copyright @ 2022 <b> {{ hotelInfo.hotelName }} </b><br>
      地址：<b> 明兰街道</b><br>
      电话号码： <b> 14796703635 </b><br>
      电子邮箱：<b>1938868551@qq.com </b><br>
      网页地址：<b>  <a href="http://laicl.vip" style="color: white" >laicl.vip</a></b>
    </div>
  </div>
</template>

<script>
export default {
  name: "Hotelconfiguration",
  data(){
    return{
      hotelInfo: {
        hotelName: "ho",
        address: ""
      }
    }
  },
  created: function(){


  },
  mounted() {
  },
  methods:{

  },


}
</script>

<style scoped>
#Hotelconfiguration{
  /*background-image: linear-gradient(270deg,#8146b4,#6990f6);*/
  background-image: url("https://pic.imgdb.cn/item/622fffd95baa1a80ab2c162b.jpg");
  background-repeat:no-repeat;
}

.HotelconfigurationAppBar{

  height: 40px;
  width: auto!important;
  border-radius: 30px;
  margin: 10px;
  color: #fff;
  padding: 10px;
}
.HotelconfigurationPaper{
  margin: 20px auto 0;
  padding: 20px 0;
}

.ro{
  display: flex;
  justify-content: center;
}

.co{
  width: 360px;
  height: 306px;
  border-radius: 12px;
  overflow: hidden;
  margin-right: 25px;
  background: gainsboro;
}

.co .image {
  width: 360px;
  height: 256px;
  overflow: hidden;
}

.image > img{
  width: 100%;
  height: 100%;
  transition: all 1.2s ease;
}

.co .text{
  display: flex;
  height: 50px;
  font-size: 26px;
  color: #ffffff;
  align-items: center;
  justify-content: center;
}

.image:hover > img{

  transform: scale(1.2);
}
.tom{
  height: 60px;
}
.more{
  height: 640px;
  background: #f6f6f6;
}
.more2{
  height: 640px;
  background: #FFFFFF;
}
.card{
  height: 400px;
  width: 265px;
  float: left;
  margin-top: 30px;
  margin-left: 30px;
  border-radius: 12px;
  background-color: #ffffff;

}

.card2{
  height: 400px;
  width: 265px;
  float: left;
  margin-top: 30px;
  margin-left: 30px;
  border-radius: 12px;
  background-color: #f6f6f6;
}
.cardImg > img{
  border-radius: 12px;
}

.footer{
  text-align: center;
  color: #fff;
  padding: 30px 40px;
  background-color: #2196f3;
  background-image: linear-gradient(270deg,#fbc4c4,#6990f6);
}
</style>
