<template>
  <div class="container">
    <div class="searchBox">
      <el-button type="primary" size="small" @click="doAddInterface">新增</el-button>
      <!-- <el-button type="primary" size="small" @click="doAddInterface" :disabled="isBtnDisabled">修改</el-button> -->
      <el-button type="primary" size="small" @click="doDeteleInterface" :disabled="isBtnDisabled">删除</el-button>
      <!-- <el-button size="small" @click="doOpen" :disabled="isBtnDisabled">启用</el-button>
      <el-button size="small" @click="doClose" :disabled="isBtnDisabled">警用</el-button> -->
      <el-button size="small" @click="goLogList('ALL')">查看日志</el-button>
      <div class="seachIpt">
        <el-input placeholder="请输入接口名称" v-model="searchVal" @blur="searchAction" @keyup.13.native="searchAction" clearable>
          <i slot="prefix" class="el-input__icon el-icon-search"></i>
        </el-input>
      </div>
    </div>
    <div class="interfaceInfo">
      <interface-list :on-select-data="updateSelectList"
                      :on-do-open="doOpen"
                      :on-do-close="doClose"
                      :on-save-process="goLogList"
                      :on-do-detele-interface="doDeteleInterface"
                      :on-do-add-interface="doAddInterface"></interface-list>
    </div>
    <div class="pageBox">
      <el-pagination @size-change="handleSizeChange"
                     @current-change="handleCurrentChange"
                     :current-page.sync="currentPage"
                     :page-size="pageSize"
                     layout="prev, pager, next, jumper"
                     :total="total">
      </el-pagination>
    </div>
    <div>
      <add-interface :data="interfaceDetail"
                     :is-show="isShowAddInterface"
                     :on-sumbit="saveInterface"
                     :on-close="onClose"></add-interface>
    </div>
  </div>
</template>

<script>
import InterfaceList from '../../components/InterfaceManage/InterfaceList'
import AddInterface from '../../components/InterfaceManage/AddInterface'
import '../../../static/css/interfaceManage.css'

export default {
  components: {
    InterfaceList,
    AddInterface
  },
  data () {
    return {
      currentPage: 1,
      pageSize: 10,
      total: 2,
      searchVal: null, // 搜索值
      isBtnDisabled: true, // 按钮是否禁用
      selectionList: [], // 存放选中接口数组
      isShowAddInterface: false, // 显示新增接口弹窗
      interfaceDetail: { // 新增接口obj
        name: '接口'
      }
    }
  },
  methods: {
    goLogList (type, id) { // 查看日志
      let ids = [1,2,3]
      if (type === 'ONE') { // 单独查看
        ids = [id]
      } else { // 批量查看
        ids = this.selectionList
      }
      console.log(ids, this.selectionList)
		  this.$router.push({ name: 'InterfaceLog', params: { id: ids} })
    },
    handleSizeChange () {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange (val) {
      console.log(`当前页: ${val}`);
    },
    updateSelectList (data) {
      this.selectionList = data
      if (data.length > 0) {
        this.isBtnDisabled = false
      } else {
        this.isBtnDisabled = true
      }
      console.log(this.selectionList)
    },
    searchAction () { // 回车搜索事件
      console.log(this.searchVal)
    },
    doDeteleInterface () { // 删除接口
      this.showDeteleTips('此操作将删除选中接口, 是否继续?', (that) => {
        that.$message({
          duration: 1500,
          type: 'success',
          message: '删除成功!'
        })
      })
    },
    doOpen () { // 启用接口
      this.showDeteleTips('此操作将启用选中接口, 是否继续?', (that) => {
        that.$message({
          duration: 1500,
          type: 'success',
          message: '启用成功!'
        })
      })
    },
    doClose () { // 禁用接口
      this.showDeteleTips('此操作将禁用选中接口, 是否继续?', (that) => {
        that.$message({
          duration: 1500,
          type: 'success',
          message: '禁用成功!'
        })
      })
    },
    onClose () { // 关闭所有弹窗
      this.isShowAddInterface = false
    },
    doAddInterface () { // 显示新增接口弹窗
      this.isShowAddInterface = true
    },
    saveInterface () { // 接口编辑弹窗保存
    },
    showDeteleTips (text, callback) { // 删除提示
      this.$confirm(text, '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => { // 确认删除
        callback(this)
      }).catch(() => { // 取消删除
      });
    }
  }
}
</script>
