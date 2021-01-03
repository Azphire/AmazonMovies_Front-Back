<template>
  <div id="time">
    <!-- 标题 -->
    <div class="page-header">
      <h1 class="title">时间查询 <small>根据年份、月份、季度查询</small></h1>
    </div>
    <el-row>
      <el-col :span="8" :offset="8">
        <!-- 选择框 -->
        <div class="block">
          <span class="demonstration">年</span>
          <el-date-picker v-model="valueYear" type="year" value-format="yyyy" placeholder="选择年">
          </el-date-picker>
          <el-button @click="searchYear">查询</el-button>
        </div>
        <div class="block">
          <span class="demonstration">月</span>
          <el-date-picker v-model="valueMonth" type="month" value-format="yyyy-MM" placeholder="选择月">
          </el-date-picker>
          <el-button @click="searchMonth">查询</el-button>
        </div>
        <div class="block">
          <span class="demonstration">日</span>
          <el-date-picker v-model="valueDate" type="date" value-format="yyyy-MM-dd" placeholder="选择日">
          </el-date-picker>
          <el-button @click="searchDate">查询</el-button>
        </div>
        <div class="block">
          <span class="demonstration">时间段</span>
          <el-date-picker
            v-model="valueSpan"
            type="daterange"
            value-format="yyyy-MM-dd"
            range-separator="至"
            start-placeholder="开始日期"
            end-placeholder="结束日期">
          </el-date-picker>
          <el-button @click="searchSpan">查询</el-button>
        </div>
      </el-col>
      <el-col :span="20" :offset="2">
        <el-card class="box-card">
          <div slot="header">
            <span>总数： {{ total }}</span>
          </div>
          <div slot="header">
            <span>统计查询用时： {{ usingTime2 }}</span>
          </div>
          <div slot="header">
            <span>详情示例用时： {{ usingTime1 }}</span>
          </div>
          <div>
            <span>详情：</span>
          </div>
          <div>
            <el-table class="dataTable" ref="multipleTable" :data="result">
              <el-table-column label="电影名" prop="title"></el-table-column>
              <el-table-column label="导演" prop="director"></el-table-column>
              <el-table-column label="演员" prop="actor"></el-table-column>
              <el-table-column label="制片人" prop="producer"></el-table-column>
              <el-table-column label="上映时间" prop="release"></el-table-column>
              <el-table-column label="时长" prop="runtime"></el-table-column>
              <el-table-column label="类别" prop="gerne"></el-table-column>
              <el-table-column label="语言" prop="language"></el-table-column>
              <el-table-column label="评分" prop="score"></el-table-column>
          </el-table>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  data () {
    return {
      total: '',
      result: '',
      usingTime1: '',
      usingTime2: '',
      valueYear: '',
      valueMonth: '',
      valueDate: '',
      valueSpan: []
    }
  },
  methods: {
    searchYear () {
      if(!this.valueYear){
        return;
      }
      var startTime1 = new Date();
       axios.get(this.root + '/movie/year?year='+ this.valueYear)
      .then(response => {
        this.usingTime1 = new Date() - startTime1 + 'ms';
        this.result = response.data;});
      var startTime2 = new Date();
        axios.get(this.root + '/movie/CountByYear?year='+ this.valueYear)
      .then(response => {
        this.usingTime2 = new Date() - startTime2 + 'ms';
        this.total = response.data;})
    },
    searchMonth () {
      if(!this.valueMonth){
        return;
      }
      var startTime1 = new Date();
       axios.get(this.root + '/movie/month?month='+ this.valueMonth)
      .then(response => {
        this.usingTime1 = new Date() - startTime1 + 'ms';
        this.result = response.data;});
      var startTime2 = new Date();
        axios.get(this.root + '/movie/CountByMonth?month='+ this.valueMonth)
      .then(response => {
        this.usingTime2 = new Date() - startTime2 + 'ms';
        this.total = response.data;})
    },
    searchDate () {
      if(!this.valueDate){
        return;
      }
      var startTime1 = new Date();
       axios.get(this.root + '/movie/date?date='+ this.valueDate)
      .then(response => {
        this.usingTime1 = new Date() - startTime1 + 'ms';
        this.result = response.data;});
      var startTime2 = new Date();
        axios.get(this.root + '/movie/CountByDate?date='+ this.valueDate)
      .then(response => {
        this.usingTime2 = new Date() - startTime2 + 'ms';
        this.total = response.data;})
    },
    searchSpan () {
      if(!this.valueSpan){
        return;
      }
      var startTime1 = new Date();
       axios.get(this.root + '/movie/span?start='+ this.valueSpan[0] + "&end=" + this.valueSpan[1])
      .then(response => {
        this.usingTime1 = new Date() - startTime1 + 'ms';
        this.result = response.data;});
      var startTime2 = new Date();
        axios.get(this.root + '/movie/CountBySpan?start='+ this.valueSpan[0] + "&end=" + this.valueSpan[1])
      .then(response => {
        this.usingTime2 = new Date() - startTime2 + 'ms';
        this.total = response.data;})
    }
  }
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
  width: 1600px;
}
.block {
  margin: 20px;
}
</style>
