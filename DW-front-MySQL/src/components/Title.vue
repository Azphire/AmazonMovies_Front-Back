<template>
  <div id="time">
    <!-- 标题 -->
    <div class="page-header">
      <h1 class="title">电影名查询 <small>根据电影名查询</small></h1>
    </div>
    <el-row>
      <el-col :span="4" :offset="10">
        <!-- 查询框 -->
        <div class="block">
          <span class="demonstration">产品查询-输入电影名查询所有版本</span>
          <el-input
            v-model="title"
            placeholder="请输入电影名"
          ></el-input>
          <el-button @click="searchTitle">查询</el-button>
        </div>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="16" :offset="4">
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
              <el-table-column label="asin" prop="asin"></el-table-column>
              <el-table-column label="格式" prop="format"></el-table-column>
              <el-table-column label="版本" prop="version"></el-table-column>
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
      title: 'Harry Potter and the Half Blood Prince'
    }
  },
  methods: {
    searchTitle () {
      if(!this.title){
        return;
      }
      var startTime1 = new Date();
       axios.get(this.root + '/movie/title?title='+ this.title)
      .then(response => {
        this.usingTime1 = new Date() - startTime1 + 'ms';
        this.result = response.data;});
      var startTime2 = new Date();
        axios.get(this.root + '/movie/CountByTitle?title='+ this.title)
      .then(response => {
        this.usingTime2 = new Date() - startTime2 + 'ms';
        this.total = response.data;})
    },
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
.box-card {
  width: 1200px;
}
.block {
  margin: 20px;
}
</style>
