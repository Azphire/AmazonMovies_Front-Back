<template>
  <div id="popular">
    <!-- 标题 -->
    <div class="page-header">
      <h1 class="title">年度电影 <small>获取年度最受欢迎、最不受欢迎电影</small></h1>
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
      </el-col>
      <el-col :span="20" :offset="2">
        <el-card class="box-card">
          <div slot="header">
            <span>最受欢迎查询用时： {{ usingTime1 }}</span>
          </div>
          <div slot="header">
            <span>最不受欢迎查询用时： {{ usingTime2 }}</span>
          </div>
          <div class="tableTitle">
            <span>最受欢迎前三</span>
          </div>
          <div>
            <el-table class="dataTable" ref="multipleTable" :data="result1">
              <el-table-column label="电影名" prop="title"></el-table-column>
              <el-table-column label="导演" prop="director"></el-table-column>
              <el-table-column label="演员" prop="actor"></el-table-column>
              <el-table-column label="制片人" prop="producer"></el-table-column>
              <el-table-column label="上映时间" prop="year"></el-table-column>
              <el-table-column label="时长" prop="runtime"></el-table-column>
              <el-table-column label="类别" prop="gerne"></el-table-column>
              <el-table-column label="语言" prop="language"></el-table-column>
              <el-table-column label="评分" prop="score"></el-table-column>
          </el-table>
          </div>
          <div class="tableTitle">
            <span>最不受欢迎前三</span>
          </div>
          <div>
            <el-table class="dataTable" ref="multipleTable" :data="result2">
              <el-table-column label="电影名" prop="title"></el-table-column>
              <el-table-column label="导演" prop="director"></el-table-column>
              <el-table-column label="演员" prop="actor"></el-table-column>
              <el-table-column label="制片人" prop="producer"></el-table-column>
              <el-table-column label="上映时间" prop="year"></el-table-column>
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
      result1: '',
      result2: '',
      usingTime1: '',
      usingTime2: '',
      valueYear: ''
    }
  },
  methods: {
    searchYear () {
      if(!this.valueYear){
        return;
      }
      var startTime1 = new Date();
       axios.get(this.root + '/movie/MostPopular?year='+ this.valueYear)
      .then(response => {
        this.usingTime1 = new Date() - startTime1 + 'ms';
        this.result1 = response.data;});
      var startTime2 = new Date();
        axios.get(this.root + '/movie/MostUnpopular?year='+ this.valueYear)
      .then(response => {
        this.usingTime2 = new Date() - startTime2 + 'ms';
        this.result2 = response.data;})
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
.tableTitle {
  font-size: 40px;
  margin-top: 20px;
}
</style>
