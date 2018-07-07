<template>
	<el-menu class="el-menu-vertical-demo" :unique-opened="uniqueOpened">
		<el-submenu :index="toString(indexs)" v-for="(items ,indexs) in list" :key="indexs">
			<template slot="title">
				<i class="el-icon-menu"></i>
				<span>{{items.name}}</span>
			</template>
			<el-menu-item-group>
				<el-menu-item v-for="(item ,index) in items.arr" :key="index" :index="indexs+'-'+(index+1)">
					<span @click="go(item.name, item.meta.label)">{{item.meta.label}}</span>
				</el-menu-item>
			</el-menu-item-group>
		</el-submenu>
		<el-submenu index="3">
			<template slot="title">
				<span>角色权限管理</span>
			</template>
			<el-menu-item-group>
				<el-menu-item index="3-1">
					<span @click="go( 'PowerForm' , '角色权限管理' )">
						角色权限管理
					</span>
				</el-menu-item>
			</el-menu-item-group>
		</el-submenu>
	</el-menu>
</template>

<script>
import configManage from '../../router/configManage'
import interfaceManage from '../../router/interfaceManage'

export default {
  data () {
    return {
      uniqueOpened: true,
      list: []
    }
  },
  created () {
    this.setNavList()
  },
  methods: {
    toString (index) {
      return index.toString()
    },
    setNavList () {
      let arr = [{name: '表单管理',arr: [...configManage]},{name: '接口管理',arr: [...interfaceManage]}]
      this.list = arr
    },
    go (name, label) {
		this.$router.push({ name: name })
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
    }
  }
}
</script>
<style scoped>
.el-menu-vertical-demo{
	height: 100%;
	overflow: auto;
}
.el-aside {
  border-right: solid 1px #e6e6e6
}
.el-menu {
  border-right: none;
  overflow-x: hidden;
}
.is-opened .el-submenu__title,
.is-opened .el-icon-menu,
.is-opened .el-icon-arrow-down {
  color: #3e94e1;
}
.el-submenu__title {
  height: 48px;
  line-height: 48px;
}
.el-submenu__title,
.el-submenu.is-active .el-submenu__title {
  border-bottom: 1px solid #d5d5d5;
}
.el-menu-item-group__title {
  padding: 0;
}
.el-menu-item-group ul {
  border-bottom: 1px solid #d5d5d5;
}
.el-submenu .el-menu-item {
  padding: 0!important;
  height: 44px;
  line-height: 44px;
}
.el-menu-item span {
  display: block;
  padding-left: 40px;
}
.el-menu-item.is-active a {
    color: #409eff;
}
</style>
