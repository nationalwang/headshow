<template>
  <div class="container">
    <div class="searchBox">
      <el-button type="primary" size="small" @click="doAddWhite">新增</el-button>
      <el-button type="primary" size="small" @click="doDeteleWhite" :disabled="isBtnDisabled">删除</el-button>
      <el-button size="small" @click="doOpen" :disabled="isBtnDisabled">启用</el-button>
      <el-button size="small" @click="doClose" :disabled="isBtnDisabled">警用</el-button>
    </div>
    <div class="interfaceInfo">
      <white-list :on-select-data="updateSelectList"
                  :on-do-open="doOpen"
                  :on-do-close="doClose"
                  :on-do-detele-white="doDeteleWhite"
                  :on-do-add-white="doAddWhite"></white-list>
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

    <add-white :data="whieDetail"
               :is-show="isShowAddWhite"
               :on-sumbit="saveWhite"
               :on-close="onClose"></add-white>
  </div>
</template>

<script>
import WhiteList from '../../components/InterfaceManage/WhiteList'
import AddWhite from '../../components/InterfaceManage/AddWhite'

export default {
  components: {
    WhiteList,
    AddWhite
  },
  data () {
    return {
      currentPage: 1,
      pageSize: 10,
      total: 2,
      selectionList: [],
      isBtnDisabled: true, // 按钮是否禁用
      whieDetail: { // 新增白名单obj
        name: 1
      },
      isShowAddWhite: false, // 是否显示新增白名单弹窗
    }
  },
  methods: {
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
    doDeteleWhite () { // 删除白名单
      this.showDeteleTips('此操作将删除选中白名单, 是否继续?', (that) => {
        that.$message({
          duration: 1500,
          type: 'success',
          message: '删除成功!'
        })
      })
    },
    doOpen () { // 启用白名单
      this.showDeteleTips('此操作将启用选中白名单, 是否继续?', (that) => {
        that.$message({
          duration: 1500,
          type: 'success',
          message: '启用成功!'
        })
      })
    },
    doClose () { // 禁用白名单
      this.showDeteleTips('此操作将禁用选中白名单, 是否继续?', (that) => {
        that.$message({
          duration: 1500,
          type: 'success',
          message: '禁用成功!'
        })
      })
    },
    doAddWhite () { // 显示新增白名单弹窗
      this.isShowAddWhite = true
    },
    saveWhite () { // 新增白名单保存
    },
    onClose () { // 关闭弹窗
      this.isShowAddWhite = false
    },
    showDeteleTips (text, callback) { // 删除提示
      this.$confirm(text, '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => { // 确认删除
        callback(this)
      }).catch(() => { // 取消删除
      })
    }
  }
}
</script>

