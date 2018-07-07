<template>
  <el-tabs v-model="activeValue" type="card" closable @tab-click="tabChange" @edit="handleTabsEdit">
    <el-tab-pane :key="index"
                 v-for="(item, index) in tabsList"
                 :label="item.label"
                 :name="item.name">
    </el-tab-pane>
  </el-tabs>
</template>

<script>
import { mapState } from 'vuex'

export default {
  data () {
    return {
      activeValue: 'Home'
    }
  },
  computed: {
    ...mapState({
      tabsList: state => state.tabs.list.tabsList,
      editableTabsValue: state => state.tabs.list.value
    })
  },
  created () {
    this.watchRoute()
  },
  watch: {
    editableTabsValue () {
      this.activeValue = this.editableTabsValue
    },
    "$route": "watchRoute"
  },
  methods: {
    watchRoute () { // 监听路由变化
      let name = this.$route.name
      let label = this.$route.meta.label
      var temp = {
        name: name,
        label: label
      }
      let tabsList = this.$store.state.tabs.list.tabsList.slice()
      if (tabsList.filter(tab => tab.name === name).length === 0) {
        tabsList.push(temp)
        this.$store.dispatch('tabs/getList', {type: 'ADD', name: '', obj: tabsList, index: name})
      } else {
        this.$store.dispatch('tabs/getList', {type: 'ADD', name: '', obj: tabsList, index: name})
      }
    },
    tabChange () {
      this.$router.push({ name: this.activeValue })
    },
    handleTabsEdit (targetName, action) {
      if (action === 'remove') {
        if (targetName !== 'Home') {
          let tabs = this.tabsList
          let activeName = this.editableTabsValue
          if (activeName === targetName) {
            tabs.forEach((tab, index) => {
              if (tab.name === targetName) {
                let nextTab = tabs[index + 1] || tabs[index - 1]
                if (nextTab) {
                  activeName = nextTab.name
                }
              }
            })
          }
          this.$store.dispatch('tabs/getList', {type: 'DETELE', name: targetName, index: activeName})
          this.$router.push({ name: activeName })
        }
      }
    }
  }
}
</script>

<style scopde>
.el-tabs__header {
  margin: 0;
  box-shadow: 0px 1px 11px rgba(107 107, 107, .42)
}
.el-tabs__nav .el-tabs__item:first-child .el-icon-close {
  display: none;
}
</style>
