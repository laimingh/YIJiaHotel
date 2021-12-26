<template>
  <div>
    <div class="head">
      <span  class="head-item" style="font-size: 18px;margin-left: 20px;"> <img src="https://pic.imgdb.cn/item/61c025e22ab3f51d91f4d257.png" height="60px" width="60px">酒店安全中心</span>
      <span class="head-item">
         <mu-button flat @click="navigateTo('/login')" style="color: white">返回登录</mu-button>
      </span>
    </div>

    <mu-card class="login-card" raised>
      <mu-form ref="form" :model="validateForm" class="mu-demo-form">
        <mu-card-title  title="找回密码"></mu-card-title>
        <mu-card-text>
          <mu-form-item label="请输入用户名" help-text="" prop="username" :rules="usernameRules">
            <mu-text-field v-model="validateForm.username" prop="username"></mu-text-field>
          </mu-form-item>
          <mu-form-item label="请输入身份证号" prop="password" :rules="passwordRules">
            <mu-text-field type="password" v-model="validateForm.password" prop="password" @keyup.enter="submit"></mu-text-field>
          </mu-form-item>
        </mu-card-text>
        <mu-card-actions>
          <mu-form-item>
            <mu-button color="secondary" @click="queryPassword">密码查询</mu-button>
            <mu-button color="secondary" @click="">修改密码</mu-button>
          </mu-form-item>
        </mu-card-actions>
      </mu-form>
    </mu-card>
  </div>
</template>

<script>

import { userLogin,getUserInfoByUsername,getPasswordByIdCard } from "@/api/user/";
import Cookies from "js-cookie";

export default {
  name: "forgetPassword",
  data () {
    return {
      usernameRules: [
        { validate: (val) => !!val, message: '必须填写用户名'},
      ],
      passwordRules: [
        { validate: (val) => !!val, message: '必须填写密码'},
      ],
      validateForm: {
        username: 'zhangsan',
        password: ''
      },
      userId: null,
      btnLoading: false
    }
  },
  methods: {
    navigateTo(val){
      this.$router.push(val);
    },
    submit () {
      this.$refs.form.validate().then((result) => {
        if (result == false){
          this.$toast.warning("请填入账户密码！")
          return
        } else {
          this.login()
        }
      });
    },
    clear () {
      this.$refs.form.clear();
      this.validateForm = {
        username: '',
        password: ''
      };
    },
    queryPassword(){
      getPasswordByIdCard(this.validateForm.username,this.validateForm.password).then(res=>{
        var response = res;
        console.log(res);
        if (response.data !== null){
          Cookies.set('username',this.validateForm.username)
          Cookies.set('session',response.data.sessionId)
          Cookies.set('user_id',response.data.userId)
          this.$alert(response.data.psd, '您的密码', {
            confirmButtonText: '确定',
            callback: action => {
              this.$message({
                type: 'info',
                message: `action: ${ action }`
              });
            }
          })
        }else if (response.code !== 1000) {
          this.$toast.error(response.message)
        }
      }).catch(err =>{
        console.log(err)
      })
    },
    login() {
      userLogin(this.validateForm.username,this.validateForm.password).then(res => {
        var response = res;
        console.log(res);
        /*console.log(${map});*/
        // console.log(this.validateForm.username);
        if (response.data !== null){
          Cookies.set('username',this.validateForm.username)
          Cookies.set('session',response.data.sessionId)
          Cookies.set('user_id',response.data.userId)
          this.navigateTo('/')
        }else if (response.code !== 1000) {
          this.$toast.error(response.message)
        }
      }).catch(err => {
        console.log(err)
      })
    },
  }
}
</script>

<style scoped >
.container{
  margin: 0px 0px;
  width: 100%;
}
.head{
  display: flex;
  justify-content: space-between;
  background-image: linear-gradient(270deg,#8146b4,#6990f6);
  height: 80px;
  width: 100%;
  margin-left: 0 ;
  /*margin-right: 40px;*/
}
.head-item{
  color: white;
  line-height: 80px;
}
.mu-demo-form {
  width: 100%;
  /*max-width: 460px;*/
}
.login-card{
  width: 100%;
  max-width: 400px;
  margin: 50px auto;
}

</style>
