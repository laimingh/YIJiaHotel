<template>
  <div class="feedBack-container">
    <mu-card class="login-card" raised>
        <mu-card-title title="意见反馈" sub-title="欢迎填写您的宝贵意见！"></mu-card-title>

        <mu-card-text>

          <mu-container>
            <mu-form :model="form" class="mu-demo-form" :label-position="labelPosition" label-width="100">

          <mu-form-item  v-if="!form.switch" label="姓名" help-text="" prop="name" :rules="rules.notNull">
            <mu-text-field v-model="validateForm.name"></mu-text-field>
          </mu-form-item>

          <mu-form-item label="联系方式" help-text="" prop="phone" :rules="rules.notNull" >
            <mu-text-field v-model="validateForm.phone"></mu-text-field>
          </mu-form-item>


            <mu-form-item prop="switch" label="是否匿名">
              <mu-switch v-model="form.switch"></mu-switch>
            </mu-form-item>

              <mu-form-item prop="date" label="反馈日期">
                <mu-date-input v-model="form.date" type="dateTime" actions></mu-date-input>
              </mu-form-item>

              <mu-form-item prop="radio" label="选一个吧">
                <mu-radio v-model="form.radio" value="male" label="好评！"></mu-radio>
                <mu-radio v-model="form.radio" value="female" label="差评！"></mu-radio>
              </mu-form-item>

              <mu-form-item prop="checkbox" label="选择标签">
                <mu-checkbox v-model="form.checkbox" value="eat" label="服务态度"></mu-checkbox>
                <mu-checkbox v-model="form.checkbox" value="sleep" label="房间卫生"></mu-checkbox>
                <mu-checkbox v-model="form.checkbox" value="run" label="酒店价格"></mu-checkbox>
                <mu-checkbox v-model="form.checkbox" value="movie" label="其他"></mu-checkbox>
              </mu-form-item>

              <el-upload
                class="upload-demo"
                action="https://jsonplaceholder.typicode.com/posts/"
                :on-preview="handlePreview"
                :on-remove="handleRemove"
                :file-list="fileList"
                list-type="picture">
                <el-button size="small" type="primary">点击上传</el-button>
                <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过10Mb</div>
              </el-upload>


              <mu-form-item prop="textarea" label="我要反馈">
                <mu-text-field multi-line :rows="3" :rows-max="6" v-model="form.textarea"></mu-text-field>
              </mu-form-item>

              <mu-card-actions>
                <mu-form-item>
                  <mu-button color="secondary" @click="submit">提交</mu-button>
                  <mu-button @click="clear">重置</mu-button>
                </mu-form-item>
              </mu-card-actions>

            </mu-form>
          </mu-container>
        </mu-card-text>
    </mu-card>
  </div>

</template>

<script>
export default {
  name: "Feedback",
  data () {
    return {
      validateForm: {
        username: null,
        password: '',
        password2: '',
        name: '',
        gender: '男',
        phone: '',
        email: '',
        address: ''
      },
      labelPosition: 'left',
      fileList: [{name: 'food.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'}, {name: 'food2.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'}],
      form: {
        input: '',
        select: '',
        date: '',
        radio: '',
        checkbox: [],
        switch: false,
        slider: 30,
        textarea: ''
      },
      rules: {
        notNull: [
          { validate: (val) => !!val, message: '请输入信息', trigger: 'blur' },
        ]
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
        console.log(result)
        if (result == false) {
          this.$toast.warning("请输入必填项！")
          return
        }else {

        }
      });
    },
    clear () {
      this.$refs.form.clear();
      this.validateForm = {
        username: '',
        password: '',
        password2: '',
        name: '',
        gender: '男',
        phone: '',
        email: '',
        address: ''
      };
    },

    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePreview(file) {
      console.log(file);
    }
  }

}
</script>

<style scoped>
.feedBack-container{
  width: 100%;
  background-image: linear-gradient(270deg,#8146b4,#6990f6);
  padding: 8px;
}
.mu-demo-form {
  width: 100%;
  /*max-width: 460px;*/
}
.login-card{
  width: 100%;
  max-width: 80%;
  margin: 50px auto;
}
.mu-demo-form {
  width: 100%;

  max-width: 460px;
}
</style>
