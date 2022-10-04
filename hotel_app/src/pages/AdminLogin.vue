<template>
  <div class="login-container" >
    <mu-card class="login-card" raised>
      <mu-form ref="form" :model="validateForm" class="mu-demo-form">
        <mu-card-title sub-title="管理员登录" title="一家大酒店"></mu-card-title>
        <mu-card-text>
          <mu-form-item label="管理员" help-text="" prop="username" :rules="usernameRules">
            <mu-text-field v-model="validateForm.username" prop="username"></mu-text-field>
          </mu-form-item>
          <mu-form-item label="密码" prop="password" :rules="passwordRules">
            <mu-text-field type="password" v-model="validateForm.password" prop="password" @keyup.enter="submit"></mu-text-field>
          </mu-form-item>
          <mu-form-item >
            <mu-button flat @click="navigateTo('/forgetPassword')">忘记密码？</mu-button>
            <mu-button flat @click="navigateTo('/register')">立即注册</mu-button>
          </mu-form-item>
        </mu-card-text>
        <mu-card-actions>
          <mu-form-item>
            <mu-button color="secondary" @click="submit">登录</mu-button>
<!--            <mu-button @click="navigateTo('/')">先随便逛逛</mu-button>-->
          </mu-form-item>
        </mu-card-actions>
      </mu-form>
    </mu-card>
  </div>
</template>

<script>
import { adminLogin,getRegisterInfoByRegistername } from "@/api/user/";
import Cookies from 'js-cookie'

export default {
  name: "adminLogin",
  data () {
    return {
      usernameRules: [
        { validate: (val) => !!val, message: '必须填写用户名'},
      ],
      passwordRules: [
        { validate: (val) => !!val, message: '必须填写密码'},
      ],
      validateForm: {
        username: 'lisi',
        password: '123456'
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
    login() {
      adminLogin(this.validateForm.username,this.validateForm.password).then(res => {
        var response = res;
        console.log(res);
        /*console.log(${map});*/
        // console.log(this.validateForm.username);
        if (response.data !== null){
          Cookies.set('username',this.validateForm.username)
          Cookies.set('session',response.data.sessionId)
          Cookies.set('user_id',response.data.userId)
          this.navigateTo('/about')
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

<style scoped>
.login-container{
  width: 100%;

  background-image: linear-gradient(270deg,#b7ba6b,#b7ba6b);
  padding: 8px;
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
