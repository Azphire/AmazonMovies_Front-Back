<template>
  <div id="time">
    <!-- 标题 -->
    <div class="page-header">
      <h1 class="title"> 可视化 <small>查询时间可视化</small></h1>
    </div>
    <el-row>
      <el-col :span="2" :offset="9">
        <div><el-button @click="runQuery">运行查询</el-button></div>
      </el-col>
      <el-col :span="2" :offset="2">
        <div><el-button @click="initEchart">生成可视化</el-button></div>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="18" :offset="2">
        <div id="echart" style="width: 1600px;height:600px;"></div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
var echarts = require('echarts');
export default {
  data () {
    return {
      usingTime:{
      timeYear: 0,
      timeMonth: 0,
      timeDate: 0,
      timeSeason: 0,
      timeTitle: 0,
      timeDirector: 0,
      timeActor: 0,
      timeType: 0,
      timeScore: 0,
      timeComment: 0,
      timeMulti: 0,
      }
    }
  },
  methods: {
    runQuery() {
      var startTime1 = new Date();
        axios.get(this.root + '/movie/CountByYear?year=2010')
      .then(response => {
        this.usingTime.timeYear = new Date() - startTime1;});

      var startTime2 = new Date();
        axios.get(this.root + '/movie/CountByMonth?month=2010-01')
      .then(response => {
        this.usingTime.timeMonth = new Date() - startTime2;});

      var startTime3 = new Date();
        axios.get(this.root + '/movie/CountByDate?date=2020-07-06')
      .then(response => {
        this.usingTime.timeDate = new Date() - startTime3;});
        
      var startTime4 = new Date();
        axios.get(this.root + '/movie/CountBySpan?start=2010-01-01&end=2010-04-30')
      .then(response => {
        this.usingTime.timeSeason = new Date() - startTime4;});

      var startTime5 = new Date();
        axios.get(this.root + '/movie/CountByTitle?title=Harry Potter and the Half Blood Prince')
      .then(response => {
        this.usingTime.timeTitle = new Date() - startTime5;});

      var startTime6 = new Date();
        axios.get(this.root + '/movie/CountByDirector?director=David Yates')
      .then(response => {
        this.usingTime.timeDirector = new Date() - startTime6;});
    
      var startTime7 = new Date();
        axios.get(this.root + '/movie/CountByActor?actor=Robbie Coltrane')
      .then(response => {
        this.usingTime.timeActor = new Date() - startTime7;});

      var startTime8 = new Date();
        axios.get(this.root + '/movie/CountByType?type=Adventure')
      .then(response => {
        this.usingTime.timeType = new Date() - startTime8;});
      
      var startTime9 = new Date();
        axios.get(this.root + '/movie/CountByScore?score=3')
      .then(response => {
        this.usingTime.timeScore = new Date() - startTime9;});

      var startTime10 = new Date();
        axios.get(this.root + '/movie/CountByComment?ratio=0.8')
      .then(response => {
        this.usingTime.timeComment = new Date() - startTime10;});
      
      var startTime11 = new Date();
        axios.get(this.root + '/movie/CountByMulti?type=Action&score=3&year=1998&director=Mark Roper')
      .then(response => {
        this.usingTime.timeMulti = new Date() - startTime11;});
    },
    initEchart() {
      var myData = [];
      myData.push(this.usingTime.timeYear);
      myData.push(this.usingTime.timeMonth);
      myData.push(this.usingTime.timeDate);
      myData.push(this.usingTime.timeSeason);
      myData.push(this.usingTime.timeTitle);
      myData.push(this.usingTime.timeDirector);
      myData.push(this.usingTime.timeActor);
      myData.push(this.usingTime.timeType);
      myData.push(this.usingTime.timeScore);
      myData.push(this.usingTime.timeComment);
      myData.push(this.usingTime.timeMulti);
      console.log(myData);
        // 基于准备好的dom，初始化echarts实例
      var myChart = echarts.init(document.getElementById('echart'));

      // 指定图表的配置项和数据
      var option = {
          xAxis: {
              type: 'category',
              data: ['年份统计', '月份统计', '日期统计', '季度统计', '标题统计', '导演统计', '演员统计', '类别统计', '评分统计', '评论倾向统计','组合统计']
          },
          yAxis: {
              type: 'value',
              name: '单位：毫秒'
          },
          series: [{
              data: myData,
              type: 'bar'
          }],
          textStyle: {fontSize : "20"},
          dataZoom: {
            type: "inside",
            yAxisIndex: [0],
            filterMode: 'none'
          },
      };

      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option);
    }
  },
}
</script>

<style scoped>
.page-header .title {
  text-align: center;
}
.text {
  font-size: 14px;
}
.item {
  margin-bottom: 18px;
}
.clearfix:before,
.clearfix:after {
  display: table;
  content: '';
}
.clearfix:after {
  clear: both;
}
.box-card {
  width: 480px;
}
</style>
