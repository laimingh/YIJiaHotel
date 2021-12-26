<template>
  <div class="room-container">

    <div v-if="id === '1'">
<!--      <img src="https://pic.imgdb.cn/item/6155c9662ab3f51d911d903a.jpg" />-->
      <mu-carousel>
        <mu-carousel-item>
          <img src="https://pic.imgdb.cn/item/6155c9662ab3f51d911d903a.jpg">
        </mu-carousel-item>
        <mu-carousel-item>
          <img :src="carouselImg2">
        </mu-carousel-item>
        <mu-carousel-item>
          <img :src="carouselImg3">
        </mu-carousel-item>
        <mu-carousel-item>
          <img :src="carouselImg4">
        </mu-carousel-item>
        <mu-carousel-item>
          <img :src="carouselImg5">
        </mu-carousel-item>
        <mu-carousel-item>
          <img :src="carouselImg6">
        </mu-carousel-item>
      </mu-carousel>
    </div>

    <div v-else-if="id === '2'">
      <mu-carousel>
        <mu-carousel-item>
          <img :src="shuang1">
        </mu-carousel-item>
        <mu-carousel-item>
          <img :src="shuang2">
        </mu-carousel-item>
        <mu-carousel-item>
          <img :src="shuang3">
        </mu-carousel-item>
      </mu-carousel>
    </div>

    <div v-else-if="id === '3'">
      <mu-carousel>
        <mu-carousel-item>
          <img :src="yuan1">
        </mu-carousel-item>
        <mu-carousel-item>
          <img :src="yuan2">
        </mu-carousel-item>
        <mu-carousel-item>
          <img :src="yuan3">
        </mu-carousel-item>
      </mu-carousel>
    </div>

    <div v-else>
      <mu-carousel>
        <mu-carousel-item>
          <img :src="shui1">
        </mu-carousel-item>
        <mu-carousel-item>
          <img :src="shui2">
        </mu-carousel-item>
        <mu-carousel-item>
          <img :src="shui3">
        </mu-carousel-item>
      </mu-carousel>
    </div>


<!--    <mu-carousel v-else>-->
<!--      <h1>1</h1>-->
<!--&lt;!&ndash;      <mu-carousel-item>&ndash;&gt;-->
<!--&lt;!&ndash;        <img :src="carouselImg1">&ndash;&gt;-->
<!--&lt;!&ndash;      </mu-carousel-item>&ndash;&gt;-->
<!--&lt;!&ndash;      <mu-carousel-item>&ndash;&gt;-->
<!--&lt;!&ndash;        <img :src="carouselImg1">&ndash;&gt;-->
<!--&lt;!&ndash;      </mu-carousel-item>&ndash;&gt;-->
<!--&lt;!&ndash;      <mu-carousel-item>&ndash;&gt;-->
<!--&lt;!&ndash;        <img :src="carouselImg1">&ndash;&gt;-->
<!--&lt;!&ndash;      </mu-carousel-item>&ndash;&gt;-->
<!--&lt;!&ndash;      <mu-carousel-item>&ndash;&gt;-->
<!--&lt;!&ndash;        <img :src="carouselImg1">&ndash;&gt;-->
<!--&lt;!&ndash;      </mu-carousel-item>&ndash;&gt;-->
<!--    </mu-carousel>-->


  </div>
</template>

<script>
import carouselImg2 from '../assets/imgs/d2.jpg';
import carouselImg3 from '../assets/imgs/d3.jpg';
import carouselImg4 from '../assets/imgs/d4.jpg';
import carouselImg5 from '../assets/imgs/da5.jpg';
import carouselImg6 from '../assets/imgs/d6.jpg';
import shuang1 from '../assets/imgs/sh1.jpg';
import shuang2 from '../assets/imgs/sh2.jpg';
import shuang3 from '../assets/imgs/sh3.jpg';
import shui1 from '../assets/imgs/shui1.jpg';
import shui2 from '../assets/imgs/shui2.jpg';
import shui3 from '../assets/imgs/shui3.jpg';
import yuan1 from '../assets/imgs/yuan1.jpg';
import yuan2 from '../assets/imgs/yuan2.jpg';
import yuan3 from '../assets/imgs/yuan3.jpg';
import yuan4 from '../assets/imgs/yuan4.jpg';

export default {
  data () {
    return {

      carouselImg2,
      carouselImg3,
      carouselImg4,
      carouselImg5,
      carouselImg6,
      shuang1,
      shuang2,
      shuang3,
      shui1,
      shui2,
      shui3,
      yuan1,
      yuan2,
      yuan3,
      yuan4,
      id:this.$route.query.id,
      type: 'A'
    }

  },
  methods:{
    // getId(data){
    //   console.log(data)
    // },

    //
    check(){
      if(this.$route.id === 1){
        return true
      }else{
        return false
      }
    }
  },
  created() {
    // console.log(11)
    // this.$bus.$on('sendData',function(id){
    //   console.log(id)
    // })
    // console.log(this.$route.query.id)
   /* console.log(this.id)*/
  }
};
</script>

<style scoped>
.room-container{
  width: 530px;
  /*height: 100px;*/
  margin: 64px auto;
  /*overflow: hidden;*/
}
</style>
