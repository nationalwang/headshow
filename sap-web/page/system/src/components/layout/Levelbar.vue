<template>
  <div class="levelbar-box">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item v-for="l in list" v-bind:key="l.name" v-if="list.length > 0" :to="{ path: l.name }">
        {{l.meta.label}}
      </el-breadcrumb-item>
    </el-breadcrumb>
  </div>
</template>

<script>
export default {
  data () {
    return {
      list: null
    }
  },
  created () {
    this.getList()
  },
  watch: {
    $route () {
      this.getList()
    }
  },
  methods: {
    getList () {
      let matched = this.$route.matched.filter(item => item.name)
      let first = matched[0]
      if (first && (first.name !== 'Home' || first.path !== '')) {
        matched = [{ name: 'Home', path: '/', meta: {label: '首页'} }].concat(matched)
      }
      this.list = matched
    }
  }
}
</script>

<style>
.levelbar-box {
  padding: 14px 20px;
}
.el-breadcrumb__item {
  font-size: 12px;
}
</style>
