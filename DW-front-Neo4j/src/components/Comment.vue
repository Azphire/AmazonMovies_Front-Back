<template>
  <div id="time">
    <!-- 标题 -->
    <div class="page-header">
      <h1 class="title">评论查询 <small>根据评论与评分查询</small></h1>
    </div>
    <el-row>
      <el-col :span="4" :offset="10">
        <!-- 输入框 -->
        <div class="block">
          <span class="demonstration">评分查询-输入要查询的评分下限</span>
          <el-input v-model="score" placeholder="请输入评分"></el-input>
          <el-button @click="searchScore">查询</el-button>
        </div>
        <div class="block">
          <span class="demonstration">评论查询-输入要查询的正向占比</span>
          <el-input v-model="ratio" placeholder="请输入比例"></el-input>
          <el-button @click="searchComment">查询</el-button>
        </div>
      </el-col>
    </el-row>
    <el-row>
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
      score: 3.5,
      ratio: 0.6
    }
  },
  methods: {
    searchScore () {
      if(!this.score){
        return;
      }
      var startTime1 = new Date();
       axios.get(this.root + '/movie/score?score='+ this.score)
      .then(response => {
        this.usingTime1 = new Date() - startTime1 + 'ms';
        this.result = response.data;});
      var startTime2 = new Date();
        axios.get(this.root + '/movie/CountByScore?score='+ this.score)
      .then(response => {
        this.usingTime2 = new Date() - startTime2 + 'ms';
        this.total = response.data;})
    },
    searchComment () {
      if(!this.ratio){
        return;
      }
      var startTime1 = new Date();
       axios.get(this.root + '/movie/comment?ratio='+ this.ratio)
      .then(response => {
        this.usingTime1 = new Date() - startTime1 + 'ms';
        this.result = response.data;});
      var startTime2 = new Date();
        axios.get(this.root + '/movie/CountByComment?ratio='+ this.ratio)
      .then(response => {
        this.usingTime2 = new Date() - startTime2 + 'ms';
        this.total = response.data;})
    },
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
  width: 1600px;
}
.block {
  margin: 20px;
}
</style>
