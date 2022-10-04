<template>
<div>
<!--  <div class="hello">-->
<!--    <div id="chart1"></div>-->
<!--  </div>-->


      <div style="width:500px;height:500px;float: left" ref="chart"></div>


      <div style="width:500px;height:500px; float: left" ref="chart1"></div>
  <div style="height: 500px"></div>
  <div style="width:800px;height:500px; " ref="chart2"></div>




</div>
</template>

<script>
export default {
  name: "ManageIndex",
  data () {
    return {
    }
  },
  methods: {
    initCharts () {
      let myChart1 = this.$echarts.init(this.$refs.chart1);
      let myChart = this.$echarts.init(this.$refs.chart);
      let myChart2 = this.$echarts.init(this.$refs.chart2);
      console.log(this.$refs.chart)
      // 绘制图表
      myChart.setOption({
        title: {
          text: '今日房型入住情况',
          subtext: '入住数量',
          left: 'center'
        },
        tooltip: {
          trigger: 'item'
        },
        legend: {
          orient: 'vertical',
          left: 'left'
        },
        series: [
          {
            name: '入住房间数量',
            type: 'pie',
            radius: '50%',
            data: [
              { value: 52, name: '临时房' },
              { value: 23, name: '商务房' },
              { value: 16, name: '亲子房' },
              { value: 10, name: '双床房' },
              { value: 23, name: '大床房' }
            ],
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }
        ]
      });
      myChart1.setOption({
        title: {
          text: '日利润情况',
          left: 'center'
        },
        tooltip: {
          trigger: 'item'
        },
        legend: {
          top: '5%',
          left: 'center'
        },
        series: [
          {
            name: '利润情况',
            type: 'pie',
            radius: ['40%', '70%'],
            avoidLabelOverlap: false,
            label: {
              show: false,
              position: 'center'
            },
            emphasis: {
              label: {
                show: true,
                fontSize: '40',
                fontWeight: 'bold'
              }
            },
            labelLine: {
              show: false
            },
            data: [
              { value: 1048, name: '临时房' },
              { value: 735, name: '商务房' },
              { value: 580, name: '家庭房' },
              { value: 484, name: '双床房' },
              { value: 300, name: '大床房' }
            ]
          }
        ]
      });
      myChart2.setOption({
        title: {
          text: '本周营业情况'
        },
        tooltip: {
          trigger: 'axis'
        },
        legend: {
          data: ['临时房', '商务房', '亲子房', '双床房', '大床房']
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        toolbox: {
          feature: {
            saveAsImage: {}
          }
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: ['周一', '周二', '周三', '周四', '周五', '周六', '周天']
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            name: '临时房',
            type: 'line',
            stack: 'Total',
            data: [15, 11, 10, 13, 9, 20, 26]
          },
          {
            name: '商务房',
            type: 'line',
            stack: 'Total',
            data: [9, 14, 17, 13, 15, 2, 5]
          },
          {
            name: '亲子房',
            type: 'line',
            stack: 'Total',
            data: [5, 6, 5, 7, 9, 10, 8]
          },
          {
            name: '双床房',
            type: 'line',
            stack: 'Total',
            data: [8, 15, 9, 9, 10, 11, 16]
          },
          {
            name: '大床房',
            type: 'line',
            stack: 'Total',
            data: [10, 13, 15, 12, 21, 20, 18]
          }
        ]
      });
    }
  },
  mounted() {
    this.initCharts();
  }
}

</script>

<style scoped>
</style>
