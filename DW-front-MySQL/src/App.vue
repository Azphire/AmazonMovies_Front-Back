<template>
  <div id="app">
    <div class="title">
      亚马逊电影数据分析平台-MySQL
      <el-row>
        <el-col offset="4" :span = "16">
          <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
            <el-menu-item index="1"><router-link to="/visual">可视化</router-link></el-menu-item>
            <el-menu-item index="2"><router-link to="/time">时间查询</router-link></el-menu-item>
            <el-menu-item index="3"><router-link to="/title">电影名查询</router-link></el-menu-item>
            <el-menu-item index="4"><router-link to="/director">导演查询</router-link></el-menu-item>
            <el-menu-item index="5"><router-link to="/actor">演员查询</router-link></el-menu-item>
            <el-menu-item index="6"><router-link to="/relation">关系查询</router-link></el-menu-item>
            <el-menu-item index="7"><router-link to="/catalog">分类查询</router-link></el-menu-item>
            <el-menu-item index="8"><router-link to="/comment">评论查询</router-link></el-menu-item>
            <el-menu-item index="9"><router-link to="/multi">组合查询</router-link></el-menu-item>
            <el-menu-item index="10"><router-link to="/popular">年度电影</router-link></el-menu-item>
          </el-menu>
        </el-col>
      </el-row>
    </div>
    <router-view></router-view>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        activeIndex: '1'
      };
    },
    methods: {
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      }
    }
  }
</script>
<style>
#app {
  font-family: Helvetica, sans-serif;
  text-align: center;
}
.title {
  font-size: 50px;
}
</style>
