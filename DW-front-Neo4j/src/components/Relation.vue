<template>
  <div id="time">
    <!-- 标题 -->
    <div class="page-header">
      <h1 class="title">关系查询 <small>根据导演与演员的关系查询</small></h1>
    </div>
    <el-row gutter="20">
      <el-col :span="6" :offset="2">
        <!-- 选择框 -->
        <div class="block">
          <span class="demonstration"
            >导演-演员查询：查询某导演经常合作的演员</span
          >
          <el-input v-model="ActorByD" placeholder="请输入导演"></el-input>
          <el-button @click="searchActorByD">查询</el-button>
        </div>
        <div class="block">
          <span class="demonstration"
            >演员-演员查询：查询某演员经常合作的演员</span
          >
          <el-input v-model="ActorByA" placeholder="请输入演员"></el-input>
          <el-button @click="searchActorByA">查询</el-button>
        </div>
        <div class="block">
          <span class="demonstration"
            >演员-导演查询：查询某演员经常合作的导演</span
          >
          <el-input v-model="DirectorByA" placeholder="请输入演员"></el-input>
          <el-button @click="searchDirectorByA">查询</el-button>
        </div>
        <div class="block">
          <span class="demonstration"
            >导演-导演查询：查询某导演经常合作的导演</span
          >
          <el-input v-model="DirectorByD" placeholder="请输入导演"></el-input>
          <el-button @click="searchDirectorByD">查询</el-button>
        </div>
      </el-col>
      <el-col :span="4" :offset="1">
        <div class="block">
          <span class="demonstration">最少合作次数</span>
          <el-input v-model="count1" placeholder="请输入最小合作次数"></el-input>
        </div>
        <el-card class="box-card" width="400px">
          <div slot="header">
            <span>查询用时： {{ usingTime1 }}</span>
          </div>
          <div>
            <span>详情：</span>
          </div>
          <div>
            <el-table class="dataTable" ref="multipleTable" :data="result1">
              <el-table-column label="合作者" prop="name"></el-table-column>
              <el-table-column label="合作次数" prop="count"></el-table-column>
          </el-table>
          </div>
        </el-card>
      </el-col>
      <el-col :span="7" :offset="1">
        <div class="block">
          <span class="demonstration"
            >导演-演员查询：查询最常合作的导演-演员组合</span>
          <el-button @click="searchAD">查询</el-button>
        </div>
        <div class="block">
          <span class="demonstration"
            >演员-演员查询：查询最常合作的演员-演员组合</span>
          <el-button @click="searchAA">查询</el-button>
        </div>
        <div class="block">
          <span class="demonstration"
            >导演-导演查询：查询最常合作的导演-导演组合</span>
          <el-button @click="searchDD">查询</el-button>
        </div>
        <div class="block">
          <span class="demonstration">最少合作次数</span>
          <el-input v-model="count2" placeholder="请输入最小合作次数"></el-input>
        </div>
        <el-card class="box-card" width="600px">
          <div slot="header">
            <span>查询用时： {{ usingTime2 }}</span>
          </div>
          <div>
            <span>详情：</span>
          </div>
          <div>
            <el-table class="dataTable" ref="multipleTable" :data="result2">
              <el-table-column :label="this.label1" prop="name1"></el-table-column>
              <el-table-column :label="this.label2" prop="name2"></el-table-column>
              <el-table-column label="合作次数" prop="count"></el-table-column>
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
      total1: '',
      total2: '',
      result1: [],
      result2: [],
      usingTime1: '',
      usingTime2: '',
      ActorByA: 'Robbie Coltrane',
      ActorByD: 'David Yates',
      DirectorByA: 'Robbie Coltrane',
      DirectorByD: 'David Yates',
      count1: 2,
      count2: 10,
      label1: '',
      label2: '',
    }
  },
  methods: {
    searchActorByA () {
      if(!this.ActorByA){
        return;
      }
      if(!this.count1){
        this.count1 = 0;
      }
      this.result1 = [];
      var startTime1 = new Date();
       axios.get(this.root + '/coop/ActorsByActor?actor='+ this.ActorByA + '&count=' + this.count1)
      .then(response => {
        this.usingTime1 = new Date() - startTime1 + 'ms';
        response.data.forEach(element => {
          var coop = new Object();
          coop.name = element.actor1;
          coop.count = element.count;
          this.result1.push(coop);
        });});
    },
    searchActorByD () {
      if(!this.ActorByD){
        return;
      }
      if(!this.count1){
        this.count1 = 0;
      }
      this.result1 = [];
      var startTime1 = new Date();
       axios.get(this.root + '/coop/ActorsByDirector?director='+ this.ActorByD + '&count=' + this.count1)
      .then(response => {
        this.usingTime1 = new Date() - startTime1 + 'ms';
        response.data.forEach(element => {
          var coop = new Object();
          coop.name = element.actor1;
          coop.count = element.count;
          this.result1.push(coop);
        });});
    },
    searchDirectorByA () {
      if(!this.DirectorByA){
        return;
      }
      if(!this.count1){
        this.count1 = 0;
      }
      this.result1 = [];
      var startTime1 = new Date();
       axios.get(this.root + '/coop/DirectorsByActor?actor='+ this.DirectorByA + '&count=' + this.count1)
      .then(response => {
        this.usingTime1 = new Date() - startTime1 + 'ms';
        response.data.forEach(element => {
          var coop = new Object();
          coop.name = element.director1;
          coop.count = element.count;
          this.result1.push(coop);
        });});
    },
    searchDirectorByD () {
      if(!this.DirectorByD){
        return;
      }
      if(!this.count1){
        this.count1 = 0;
      }
      this.result1 = [];
      var startTime1 = new Date();
       axios.get(this.root + '/coop/DirectorsByDirector?director='+ this.DirectorByD + '&count=' + this.count1)
      .then(response => {
        this.usingTime1 = new Date() - startTime1 + 'ms';
        response.data.forEach(element => {
          var coop = new Object();
          coop.name = element.director1;
          coop.count = element.count;
          this.result1.push(coop);
        });});
    },
    searchDD () {
      if(!this.count2){
        this.count2 = 0;
      }
      this.result2 = [];
      this.label1 = "导演";
      this.label2 = "导演";
      var startTime2 = new Date();
       axios.get(this.root + '/coop/dd?count=' + this.count2)
      .then(response => {
        this.usingTime2 = new Date() - startTime2 + 'ms';
        response.data.forEach(element => {
          var coop = new Object();
          coop.name1 = element.director1;
          coop.name2 = element.director2;
          coop.count = element.count;
          this.result2.push(coop);
        });});
    },
    searchAA () {
      if(!this.count2){
        this.count2 = 0;
      }
      this.result2 = [];
      this.label1 = "演员";
      this.label2 = "演员";
      var startTime2 = new Date();
       axios.get(this.root + '/coop/aa?count=' + this.count2)
      .then(response => {
        this.usingTime2 = new Date() - startTime2 + 'ms';
        response.data.forEach(element => {
          var coop = new Object();
          coop.name1 = element.actor1;
          coop.name2 = element.actor2;
          coop.count = element.count;
          this.result2.push(coop);
        });});
    },
    searchAD () {
      if(!this.count2){
        this.count2 = 0;
      }
      this.result2 = [];
      this.label1 = "演员";
      this.label2 = "导演";
      var startTime2 = new Date();
       axios.get(this.root + '/coop/ad?count=' + this.count2)
      .then(response => {
        this.usingTime2 = new Date() - startTime2 + 'ms';
        response.data.forEach(element => {
          var coop = new Object();
          coop.name1 = element.actor1;
          coop.name2 = element.director1;
          coop.count = element.count;
          this.result2.push(coop);
        });});
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
.block {
  margin: 20px;
}
</style>
