<template>
  <div>
    话题房态
    <div id = "ssw"></div>
    <el-input v-model="m"></el-input>
    <el-button @click="send">发送</el-button>
    <el-input v-model="m1"></el-input>
    <el-button @click="send2">发送</el-button>
  </div>
</template>

<script>
let Socket
let Socket2
export default {
  created() {
    console.log('建立websocket连接')
    Socket = new WebSocket("ws://127.0.0.1:8000/1/3/Dicussion/true")
    Socket.onmessage = this.onmessage()
    Socket.onopen = this.onopen()
    Socket.onclose = this.close()

    Socket2 = new WebSocket("ws://127.0.0.1:8000/2/3/Dicussion/false")
    Socket2.onmessage = this.onmessage()
    Socket2.onopen = this.onopen()
    Socket2.onclose = this.close()
  },
  methods: {
    onmessage(notice) {
      console.log(notice)
      if (notice && notice != "") {
        document.getElementById("ssw").innerHTML+=notice
      }
    },
    onopen(Session) {

    },
    send() {
      debugger
      Socket.send("{id:'3','message':'" + this.m + "'}")
    },
    send2() {
      Socket2.send("{id:'3','message':'" + this.m1 + "'}")
    },
    close() {
    }
  },
  data() {
    return {
      m: "",
      m1:""
    }
  },
  name: "RoomState"
}
</script>

<style scoped>

</style>
