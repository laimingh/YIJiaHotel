<template>
  <div>
    用户管理
    <el-upload
      action=""
      :auto-upload="false"
      list-type="picture-card"
      :on-preview="handlePictureCardPreview"
      :file-list="fileList"
      :on-change="handleChange">
      <i class="el-icon-plus"></i>
    </el-upload>

    <div>

<!--      <label for="code" class="login_label pwd_label"></label>-->
<!--      <input type="text" maxlength="4" class="ipt1" v-model="code"  placeholder="验证码"/>-->
<!--      <img class="code" src="code" onclick="this.src='code?d=' + new Date()">-->

    </div>

    <div class="pojo">
      <img :src="this.code" @click="getCode()">
<!--      <img src="localhost:8080/code" onclick="this.src/code">-->
    </div>
  </div>
</template>

<script>
import {addOrder,getOrder} from "@/api/image";

export default {
  name: "UserConfig",
  data(){
    return{
      fileList: [],
      dialogImageUrl: '',
      pictureVisible: false,
      isSuccess: false,
      uploading: false,
      account:"",
      pwd:"",
      code:"",
      status:[false,false,false],
      info:"",
      re:""

    }
  },
  methods:{
    // 删除图片
    // async deleteImage(id) {
    //   try{
    //     await this.$confirm('确认删除文件,是否继续?', '提示', {type: 'warning'});
    //     await this.$http.delete(`${this.$ctx}/image/${id}`)
    //     await this.search()
    //     this.$message.success("删除成功")
    //   }catch (e){
    //     console.log(e)
    //     this.$message.success("删除失败")
    //   }
    // },

    // updateImage(image){
    //   this.editImage=image;
    //   this.isAdd=false
    //   this.dialogVisible=true;
    // },
    // editClose () {
    //   this.$refs['editImage'].resetFields();
    //   this.editImage = new Image();
    //   this.fileList = [];
    // },


    async handlePictureCardPreview (file) {
      let res = await this.getBase64(file.raw);
      this.dialogImageUrl=res
      this.pictureVisible=true;
    },

    async handleChange(file, fileList){
      if (!this.uploading){
        this.uploading=true
      }else {
        return;
      }
      console.log(this)
      const isJPG = file.raw.type === 'image/jpeg';
      const isPNG = file.raw.type === 'image/png';
      const isGIF = file.raw.type === 'image/gif';
      const isSVG = file.raw.type === 'image/svg+xml';
      if(!isJPG && !isPNG && !isGIF && !isSVG){
        this.fileList=[]
        this.$message.error('请上传jpg、png、gif、svg类型的图片');

      }else {
        let res = await this.getBase64(file.raw);
        console.log(res)
        this.editImage={
          name: file.name.substring(0, file.name.indexOf(".")),
          image: res,
        };
        this.fileList = fileList;
        try {
          // let data = Object.assign(this.editImage, {boardId: 1})
          // addOrder(data).then(res => {
          //   console.log( res.data);
          //
          // }).catch(err => {
          //   this.$toast.error(err)
          // })
          // await this.$http.post(`${this.$ctx}/aa`,data)
          // this.$message.success("上传成功")
          this.$message.success("上传成功")
          // alert("上传成功")
        } catch (e) {

          this.$message.success("上传失败")
        }
        finally {
          this.uploading=false
        }

      }
    },

    getBase64(file) {
      return new Promise(function(resolve, reject) {
        let reader = new FileReader();
        let imgResult = "";
        reader.readAsDataURL(file);
        reader.onload = function() {
          imgResult = reader.result;
        };
        reader.onerror = function(error) {
          reject(error);
        };
        reader.onloadend = function() {
          resolve(imgResult);
        };
      });
    },
    getCode(){
      getOrder().then(res => {
        console.log( res);
        this.code=window.URL.createObjectURL(res);
        console.log(1)
        console.log(this.code)

      }).catch(err => {
        this.$toast.error(err)
      })




    }

    // openAddWin () {
    //   this.isAdd=true;
    //   this.dialogVisible=true;
    // },

    // async copyLink(id){
    //   let res = await ImageRes.getUrl({id: id});
    //   this.$copyToClipboard(res.body);
    // },
    //
    // async load(){
    //   if(!this.noMore){
    //     this.loadingMore = true
    //     await this.search(false)
    //   }
    // },
    // async search(isNeedReset=true) {
    //   if(isNeedReset){
    //     // 重置参数
    //     this.page=1
    //     this.areaLoding=false
    //     this.loading=false
    //     this.loadingMore=false
    //     this.noMore=false
    //     this.disableLoadMore=true
    //   }
    //
    //   // 开始加载数据
    //   this.loading = true
    //   // 加载更多时无需区域加载
    //   this.areaLoding = !this.loadingMore
    //   let res = await this.$http.get(`${this.$ctx}/image`, {params: {page: this.page, size: this.size, boardId: this.root.board.boardId}})
    //   let pages = Math.floor((res.body.total + this.size - 1) / this.size)
    //   this.imgData=this.imgData.slice(0, (this.page-1) * this.size)
    //   if(this.page <= pages){
    //     this.imgData.push(...res.body.rows)
    //   }
    //
    //   if(this.page < pages){
    //     this.page+=1
    //     this.disableLoadMore = false
    //   } else {
    //     // 无数据
    //     this.disableLoadMore = true
    //     this.noMore=true
    //   }
    //
    //   this.loadingMore=false
    //   this.areaLoding=false
    //   // 加载数据完成
    //   this.loading = false
    // },
    //


    // async save(){
    //   this.saveBtnLoading=true;
    //   this.$refs['editImage'].validate(async valid => {
    //     if(valid){
    //       try{
    //         await this.$http.put(`${this.$ctx}/image`,this.editImage);
    //         this.dialogVisible=false
    //         this.$message.success("保存成功");
    //         await this.search(true);
    //
    //       }catch (e){
    //         this.$message.error("系统错误，保存图片信息失败");
    //       }finally {
    //         this.saveBtnLoading=false;
    //       }
    //     }else {
    //       this.saveBtnLoading=false;
    //     }
    //   })
    // },


  },
  created() {
    this.getCode();
  }
}
</script>

<style scoped>
.pojo{
  width: 500px;
  height: 500px;

}

</style>
