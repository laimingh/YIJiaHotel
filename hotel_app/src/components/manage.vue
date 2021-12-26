<template>

  <div>
    <div style="text-align:center;width: 100%">房间管理</div>
    <div class="rooms">
    <div>房间1</div>
    <div>房间2</div>
    </div>
    </div>
</template>

<script>
export default {
  name: "manage"
}
</script>

<style scoped>
.rooms div{
  float: left;
  width: 200px;
  height: 300px;
  background: #4caf50;
  margin-right: 20px;
}
</style>
