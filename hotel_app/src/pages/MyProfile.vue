<template>
    <div id="myProfile">
      <mu-container class="profilePaper">
        <mu-row style="margin-left: -10px ; margin-bottom:30px">
          <mu-appbar class="profileAppBar" color="primary">
            <mu-icon value="contacts" slot="left"></mu-icon>
            我的个人资料
          </mu-appbar>
        </mu-row>
        <mu-row>
          <mu-col span="12">


            <mu-card class="ProfileCard" raised>
              <mu-card-header :title="'用户名： ' + userInfo.username" :sub-title="'用户ID号:  ' + userInfo.userId">
                <mu-avatar slot="avatar">
                  <mu-icon value="person"></mu-icon>
                </mu-avatar>
              </mu-card-header>
              <mu-card-text>
                <mu-list>
                  <mu-list-item>
                    <mu-list-item-action><mu-icon value="person_pin"></mu-icon></mu-list-item-action>
                    <mu-list-item-title>昵称： {{ userInfo.name }}</mu-list-item-title>
                  </mu-list-item>
                  <mu-list-item>
                    <mu-list-item-action><mu-icon value="fingerprint"></mu-icon></mu-list-item-action>
                    <mu-list-item-title>身份证号码： {{ userInfo.idcard }}</mu-list-item-title>
                  </mu-list-item>
                  <mu-list-item>
                    <mu-list-item-action><mu-icon value="phone"></mu-icon></mu-list-item-action>
                    <mu-list-item-title>手机号： {{ userInfo.phone }}</mu-list-item-title>
                  </mu-list-item>
                  <mu-list-item>
                    <mu-list-item-action><mu-icon value="email"></mu-icon></mu-list-item-action>
                    <mu-list-item-title>电子邮箱：{{ userInfo.email }}</mu-list-item-title>
                  </mu-list-item>
                  <mu-list-item>
                    <mu-list-item-action><mu-icon value="location_on"></mu-icon></mu-list-item-action>
                    <mu-list-item-title>地址： {{ userInfo.address }}</mu-list-item-title>
                  </mu-list-item>
                  <mu-list-item>
                    <mu-list-item-action><mu-icon value="today"></mu-icon></mu-list-item-action>
                    <mu-list-item-title>加入时间： {{ userInfo.createTime | formatDate }}</mu-list-item-title>
                  </mu-list-item>
                </mu-list>

              </mu-card-text>
              <mu-card-actions>
                <!--<mu-button flat>Action 1</mu-button>-->
                <!--<mu-button flat>Action 2</mu-button>-->
              </mu-card-actions>
            </mu-card>
          </mu-col>
        </mu-row>
        <mu-button class="edit-button" round color="primary"   @click="editUserInfo()"
        >
          修改基本信息
        </mu-button>

      </mu-container>
    </div>
</template>

<script>
  import Cookies from 'js-cookie'

  import { getUserInfo } from "@/api/user"
    export default {
        name: "MyProfile",
      data(){
          return{
            //username: Cookies.get("username"),
            userInfo: {

            },
        }
      },
      created: function(){
          this.fetchData()
          // console.log(this.userInfo.userId)
      },
      methods:{
        navigateTo(val){
          this.$router.push(val);
        },
          fetchData(){
            getUserInfo().then(res => {
              this.userInfo = res.data;
              console.log(this.userInfo)
            }).catch(err => {
              this.$toast.error(err)
            })
          },
      /*  update(){
          this.$confirm('确定要修改信息吗？', '提示', {
            type: 'warning'
          }).then(({ result }) => {
            if (result) {
              updateUserById(this.userId)
              this.$router.back()
            } else {
              this.$toast.message('点击了取消');
            }
          });
        }*/

      //  编辑用户的信息
        editUserInfo(){
          // this.navigateTo('/updateUserdetails?id=' + this.userInfo.userId)
          this.$router.push({
            path:'/updateUserdetails',
            query:{
              id:this.userInfo.userId,
              // name:this
              name: this.userInfo.name,
              gender: this.userInfo.gender,
              phone: this.userInfo.phone,
              email:this.userInfo.email,
              address:this.userInfo.address,
              idcard:this.userInfo.idcard
            }
          })
        }


      },
    }
</script>

<style scoped>
  .profileAppBar{
    height: 40px;
    width: auto!important;
    border-radius: 35px;
    margin: 10px;
    color: #fff;
    padding: 10px;
  }
  .profilePaper{
    padding: 10px;
  }
  .ProfileCard{

    width: 100%;
    margin: 0 auto;
  }

  .edit-button{
    margin-top: 20px;
  }
</style>
