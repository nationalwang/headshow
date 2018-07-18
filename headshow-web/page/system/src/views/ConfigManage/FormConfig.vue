<template>
  <div class="container drag-container clearfix">
        <div class="leftBox">
          <div class="title textCenter">流程目录</div>
          <div>
            <drag-nav :on-drag-start="handleDragStart"
                      :on-drag-end="handleDragEnd"
                      :nav-type="0"></drag-nav>
            <drag-nav :on-drag-start="handleDragStart"
                      :on-drag-end="handleDragEnd"
                      :nav-type="1"></drag-nav>
          </div>
        </div>
        <div class="rightBox">
          <div class="title textLeft">元数据列表</div>
          <div class="select-box">
            <div class="demo-input-suffix">
              区域名称：
              <el-input placeholder="请输入区域名称" style="width: 150px;" v-model="areaName"></el-input>
              区域类型：
              <el-select v-model="areaType" placeholder="请选择区域类型" style="width: 150px;">
                <el-option label="form表单" value="0"></el-option>
                <el-option label="表格" value="1"></el-option>
              </el-select>
              <el-button type="primary" @click="addFormOrBox">添加</el-button>
            </div>
          </div>
          <div v-for="(item, index) in data" :key="index">
            <div v-if="item.type == 0">
              <table-form :is-form-drag-down="isFormDragDown"
                          :on-update="updataIsTableFormDragDown"
                          :on-add-tr="addFormTr"
                          :on-detele="deteleFormOrBox"
                          :on-detele-td="onDeteleTd"
                          :data="item"
                          :form-index="index"></table-form>
            </div>
            <div v-else>
              <table-box :is-box-drag-down="isBoxDragDown"
                         :on-detele="deteleFormOrBox"
                         :on-detale-tag="deteleBoxTag"
                         :on-update="updataIsBoxDragDown"
                         :data="item"
                         :form-index="index"></table-box>
            </div>
          </div>
        </div>
  </div>
</template>

<script>
import DragNav from '../../components/ConfigManage/FormConfig/DragNav'
import TableForm from '../../components/ConfigManage/FormConfig/TableForm'
import TableBox from '../../components/ConfigManage/FormConfig/TableBox'

export default {
  components: {
    DragNav,
    TableForm,
    TableBox
  },
  data () {
    return {
      areaName: '',
      areaType: '',
      isFormDragDown: null, // 表单鼠标移入松开
      isBoxDragDown: null, // 表格鼠标移入松开
      checkData: null,
      navType: null, // 菜单类型 0：表单 1：表格
      list: [
        { name: '现金还款', id: '1' },
        { name: '现金还款', id: '2' }
      ],
      data: []
      // data: [
      //   { type: 0, name: '', detail: [ [ { name: '', id: '', value: '' }, { name: '', id: '', value: '' } ] ] },
      //   { type: 1, name: '', detail: [ { name: '', id: '' } ] }
      // ]
    }
  },
  created () {
  },
  methods: {
    addFormOrBox () { // 添加表单Or表格
      if (!this.areaName) {
        this.$message({
          duration: 1000,
          message: '请输入区域名称',
          type: 'error'
        })
        return false
      }
      if (!this.areaType) {
        this.$message({
          duration: 1000,
          message: '请选择区域类型',
          type: 'error'
        })
        return false
      }
      let temp = {
        type: Number(this.areaType),
        name: this.areaName,
        detail: []
      }
      this.data.push(temp)
    },
    handleDragStart (e, item, navType) { // 菜单按下事件
      this.checkData = item
      this.navType = navType
      // this.isFormDragDown = true
      // this.isBoxDragDown = true
    },
    handleDragEnd (e, item) { // 菜单按下松开事件
      this.isFormDragDown = true
      this.isBoxDragDown = true
    },
    updataIsTableFormDragDown (formIndex, index, i) { // 表单松开添加事件
      this.isFormDragDown = null
      if (this.navType !== 0) {
        return false
      }
      if (this.data[formIndex].detail[index][i].id !== '') {
        this.$message({
          duration: 1000,
          message: '方格已被占，不可放入',
          type: 'error'
        })
        return false
      }
      let count = 0
      let detail = this.data[formIndex].detail
      for (let d = 0; d < detail.length; d++) {
        // if ((detail[d].filter(item => item.id === this.checkData.id)).length > 0) {
        //   this.$message({
        //     duration: 1000,
        //     message: '已存在，请勿重复添加',
        //     type: 'error'
        //   })
        //   count++
        //   break
        // }
        for (let j = 0; j < detail[d].length; j++) {
          if (detail[d][j].id === this.checkData.id) {
            this.$message({
              duration: 1000,
              message: '已存在，请勿重复添加',
              type: 'error'
            })
            count++
            break
          }
        }
      }
      if (count === 0) {
        this.data[formIndex].detail[index][i].id = this.checkData.id
        this.data[formIndex].detail[index][i].name = this.checkData.name
      }
    },
    addFormTr (index) { // 表单添加行
      let temp = [
        { name: '', id: '', value: '' }, { name: '', id: '', value: '' }
      ]
      this.data[index].detail.push(temp)
    },
    onDeteleTd (formIndex, index, i) { // 删除表单指定Td
      this.data[formIndex].detail[index][i].id = ''
      this.data[formIndex].detail[index][i].name = ''
      this.data[formIndex].detail[index][i].value = ''
    },
    deteleFormOrBox (index) { // 删除指定表单Or表格
      this.data.splice(index, 1)
    },
    updataIsBoxDragDown (formIndex) { // 表格松开添加事件
      this.isBoxDragDown = null
      if (this.navType !== 1) {
        return false
      }
      let detail = this.data[formIndex].detail
      let count = 0
      if (detail.length !== 0) {
        if ((detail.filter(item => item.id === this.checkData.id)).length > 0) {
          this.$message({
            duration: 1000,
            message: '已存在，请勿重复添加',
            type: 'error'
          })
          count++
        }
      }
      // if (detail.length !== 0) {
      //   for (let d = 0; d < detail.length; d++) {
      //     if (detail[d].id === this.checkData.id) {
      //       this.$message({
      //         duration: 1000,
      //         message: '已存在，请勿重复添加',
      //         type: 'error'
      //       })
      //       count++
      //       break
      //     }
      //   }
      // }
      if (count === 0) {
        var temp = {
          id: this.checkData.id,
          name: this.checkData.name
        }
        this.data[formIndex].detail.push(temp)
      }
    },
    deteleBoxTag (formIndex, index) { // 删除表格指定tag
      this.data[formIndex].detail.splice(index, 1)
    }
  }
}
</script>

<style>
.drag-container {
  box-shadow: none;
  border: none;
}
.drag-container .leftBox {
  position: fixed;
  width: 20%;
  border: 1px solid #d5d5d5;
  padding-bottom: 6px;
}
.drag-container .rightBox {
  width: 72%;
  float: right;
  border: 1px solid #d5d5d5;
}
.demo-input-suffix {
  padding: 8px 12px;
}
.select-box .el-input, .select-box .el-select, .select-box .el-button {
  margin-right: 8px;
}
</style>
