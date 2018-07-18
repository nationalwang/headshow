<template>
  <div class="container" v-loading="loading" element-loading-text="数据加载中...">
    <el-row>
      <el-col :span="5">
        <div class="leftBox">
          <div class="title textCenter">
            模块目录
            <i class="el-icon-circle-plus-outline addModuleBtn" @click="doAddModule"></i>
          </div>
          <div v-if="moduleList.length > 0">
            <left-nav v-for="(item, index) in moduleList" 
                      :key="index"
                      :data="item"
                      :on-change="childChang"
                      :on-change-first="onShowChild"
                      :on-detele-process="onDeteleProcess"
                      :on-detele-module="onDeteleModule">
              <template slot="add-process-box" scope="props">
                <div class="add-process-box" @click="doAddProcess(props.data.id, props.data.module_name)">
                  新增流程<i class="el-icon-circle-plus-outline"></i>
                </div>
              </template>
            </left-nav>
          </div>
          <div class="navEmpty" v-else>暂无数据</div>
        </div>
      </el-col>
      <el-col :span="19">
        <div class="rightBox">
          <div class="title textLeft">流程目录</div>
          <div v-if="checkProcessId">
            <div class="rightForm">
              <process-add-form :data="detail"
                                :is-edit-process="isEditProcess">
                <template slot="add-process-btn-box">
                  <el-button type="primary" v-if="!isEditProcess" size="small" @click="goEditProcess">编辑</el-button>
                  <el-button type="primary" v-if="isEditProcess" size="small" @click="onSaveProcess(detail)">保存</el-button>
                  <el-button v-if="isEditProcess" size="small" @click="goEditProcess">取消编辑</el-button>
                </template>
              </process-add-form>
            </div>
            <div class="title textLeft borderTop">
              <span class="name">节点列表</span>
              <span class="btnCommon titleBtn">
                <el-button type="primary" @click="doAddNode(null)">新增节点</el-button>
              </span>
            </div>
            <div class="rightTable mt0">
              <process-list :on-update="doAddNode"
                            :data="nodeList"
                            :on-detele-node="onDeteleNode"></process-list>
            </div>
          </div>
          <div v-else class="emptyBox">
            <div>
              <img src="../../assets/empty.png" alt="">
              <div class="emptyText">请先选择流程</div>
            </div>
          </div>
        </div>
      </el-col>
    </el-row>

    <!-- 新增模块弹窗 -->
    <add-module :data="moduleData"
                :is-loading="isAddModuleLoading"
                :is-show="isShowAddModule"
                :on-submit="onSaveModule"
                :on-close="onClose"></add-module>

    <!-- 新增流程弹窗 -->
    <div>
      <el-dialog title="新增流程"
                :visible.sync="isShowProcess"
                :close-on-click-modal="false"
                :show-close="false">
        <process-add-form :data="addProcessDetail"
                          :is-edit-process="true">
          <template slot="add-process-btn-box">
            <el-button type="primary" size="small" @click="onSaveProcess(addProcessDetail)" :loading="isAddProcessLoading">提 交</el-button>
            <el-button size="small" @click="onClose">取 消</el-button>
          </template>
        </process-add-form>
      </el-dialog>
    </div>
    
    <!-- 新增节点弹窗 -->
    <add-node :data="nodeData"
              :is-show="isShowNode"
              :on-submit="onSaveNode"
              :on-close="onClose"
              :is-add-node-loading="isAddNodeLoading"></add-node>
  </div>
</template>

<script>
import api from '../../api/api.js'
import LeftNav from '../../components/ConfigManage/LeftNav'
import ProcessAddForm from '../../components/ConfigManage/ProcessManage/ProcessAddForm'
import ProcessList from '../../components/ConfigManage/ProcessManage/ProcessList'
import AddModule from '../../components/ConfigManage/ProcessManage/AddModule'
import AddNode from '../../components/ConfigManage/ProcessManage/AddNode'
import '../../../static/css/configManage.css'

export default {
  components: {
    LeftNav,
    ProcessAddForm,
    ProcessList,
    AddModule,
    AddNode
  },
  data () {
    return {
      loading: true, // 显示loading
      moduleList: {}, // 模块列表
      detail: {}, // 流程详情
      addProcessDetail: { // 流程新增obj
        flow_name: null,
        module_id: null,
        module_name: null,
        k2_process_code: null,
        remark: null
      },
      isShowAddModule: false, // 显示新增模块弹窗
      isAddModuleLoading: false, // 新增模块弹窗确认按钮锁定
      isShowProcess: false, // 显示新增流程弹窗
      isAddProcessLoading: false, // 新增流程确认按钮锁定
      isEditProcess: false, // 流程编辑是否可以编辑
      isShowNode: false, // 显示新增节点弹窗
      isAddNodeLoading: false, // 新增节点确认按钮锁定
      checkModuleId: null, // 选中模块ID
      checkModuleIndex: null, // 选中模块数组下标
      moduleData: { // 新增模块obj
        module_name: null,
        module_code: 1
      },
      checkProcessId: null, // 选中流程ID
      checkProcessName: null, // 选中流程名字
      nodeData: { // 新增节点obj
        processName: null,
        k2_process_id: null,
        k2_node_id: null,
        node_pagename: null,
        remark: null
      },
      nodeList: [] // 节点数组列表
    }
  },
  created () {
    this.getModuleList()
  },
  methods: {
    getModuleList () { // 获取模块列表
      api.configManage.getModuleList().then((response) => {
        this.loading = false
        if (response.data.code === '0') {
          let d = response.data.data
          let data = []
          d.forEach((item, index) => {
            let temp = {
              isShow: false,
              arr: item,
              index: index,
              firstActive: '',
              iconClass: 'el-icon-caret-top iconArrow',
              child: []
            }
            data.push(temp)
          })
          this.moduleList = data
        } else {
          this.$message({
            duration: 1500,
            message: '抱歉,暂时获取不到模块列表',
            type: 'error'
          })
        }
      }).catch((err) => {
        this.loading = false
        this.$message({
          duration: 1500,
          message: '系统错误, 无法获取模块列表',
          type: 'error'
        })
      })
    },
    onShowChild (index, moduleId) { // 显示子流程
      if (this.moduleList[index].isShow) {
        this.moduleList[index].firstActive = ''
        this.moduleList[index].iconClass = 'el-icon-caret-top iconArrow'
      } else {
        this.moduleList[index].firstActive = 'nav_first_active'
        this.moduleList[index].iconClass = 'el-icon-caret-bottom iconArrow'
        this.checkModuleId = moduleId
        this.checkModuleIndex = index
        this.getProcessList(index, moduleId)
      }
      this.moduleList.forEach((item, i) => {
        if (i !== index) {
          this.moduleList[i].firstActive = ''
          this.moduleList[i].iconClass = 'el-icon-caret-top iconArrow'
          this.moduleList[i].isShow = false
        }
      })
      this.moduleList[index].isShow = !this.moduleList[index].isShow
    },
    getProcessList () { // 获取模版下全部流程列表
      let moduleId = this.checkModuleId
      let index = this.checkModuleIndex
      this.loading = true
      api.configManage.getProcessList(moduleId).then((response) => {
        this.loading = false
        if (response.data.code === '0') {
          let d = response.data.data
          this.moduleList[index].child = d
        } else {
          this.$message({
            duration: 1500,
            message: '抱歉,暂时获取不到流程列表',
            type: 'error'
          })
        }
      }).catch((err) => {
        this.loading = false
        this.$message({
          duration: 1500,
          message: '系统错误, 无法获取流程列表',
          type: 'error'
        })
      })
    },
    childChang (id, name) { // 选中流程项，处理逻辑
      this.checkProcessId = id
      this.checkProcessName = name
      this.nodeData.processName = name
      this.nodeData.k2_process_id = id
      this.loading = true
      this.getProcessDetail()
      this.getNodeList()
    },
    getProcessDetail () { // 选中流程项,显示流程详情
      let id = this.checkProcessId
      api.configManage.getProcessDetail(id).then((response) => {
        this.loading = false
        if (response.data.code === '0') {
          let d = response.data.data
          // let nameStr = d.module_name + "("++")"
          let detail = {
            flow_name: d.flow_name,
            module_id: d.module_id,
            module_name: d.module_name,
            k2_process_code: d.k2_process_code,
            remark: d.remark
          }
          this.detail = detail
        } else {
          this.$message({
            duration: 1500,
            message: '抱歉,暂时获取不到流程列表',
            type: 'error'
          })
        }
      }).catch((err) => {
        this.loading = false
        this.$message({
          duration: 1500,
          message: '系统错误, 无法获取流程列表',
          type: 'error'
        })
      })
    },
    getNodeList () { // 选中流程项,获取节点列表
      let id = this.checkProcessId
      api.configManage.getNodeList(id).then((response) => {
        this.loading = false
        if (response.data.code === '0') {
          let d = response.data.data
          this.nodeList = d
        } else {
          this.$message({
            duration: 1500,
            message: '抱歉,暂时获取不到节点列表',
            type: 'error'
          })
        }
      }).catch((err) => {
        this.loading = false
        this.$message({
          duration: 1500,
          message: '系统错误, 无法获取节点列表',
          type: 'error'
        })
      })
    },
    onClose () { // 关闭弹窗
      this.isShowAddModule = false
      this.isShowProcess = false
      this.isShowNode = false
      this.isAddModuleLoading = false
      this.isAddProcessLoading = false
      this.moduleData.module_name = null
      this.addProcessDetail.module_name = null
      this.addProcessDetail.k2_process_code = null
      this.addProcessDetail.remark = null
      this.nodeData.k2_node_id = null
      this.nodeData.node_pagename = null
      this.nodeData.remark = null
    },
    doAddModule () { // 显示模块新增弹窗
      this.isShowAddModule = true
    },
    onSaveModule () { // 模块新增修改保存
      if (this.moduleData.module_name !== '') {
        if (!this.isAddModuleLoading) {
          this.isAddModuleLoading = true
          api.configManage.saveModule(this.moduleData).then((response) => {
            if (response.data.code === '0') {
              this.isAddModuleLoading = false
              this.isShowAddModule = false
              this.getModuleList()
              this.$message({
                duration: 1500,
                message: '创建成功',
                type: 'success'
              })
            } else {
              this.isAddModuleLoading = false
              this.$message.error(response.data.msg)
            }
          }).catch((err) => {
            this.isAddModuleLoading = false
            this.$message({
              duration: 1500,
              message: '抱歉，出错了',
              type: 'error'
            })
          })
        } else {
          this.$message({
            duration: 1500,
            message: '提交中,请稍等...'
          })
        }
      } else {
        this.$message({
          duration: 1500,
          message: '模块名称不能为空',
          type: 'warning',
        })
      }
    },
    onDeteleModule (id,e) { // 删除模块
      e.cancelBubble = true
      this.showDeteleTips('此操作将删除该模块及其子流程, 是否继续?', function(that) {
        api.configManage.delmodulebyid(id).then((response) => {
          if (response.data.code === '0') {
            that.getModuleList()
            that.$message({
              duration: 1500,
              type: 'success',
              message: '删除成功!'
            })
          } else {
            that.$message.error(response.data.msg)
          }
        }).catch(() => {
          that.$message({
            duration: 1500,
            message: '抱歉，保存出错了',
            type: 'error'
          })
        })
      })
    },
    onDeteleProcess (id, e) { // 删除流程
      e.cancelBubble = true
      this.showDeteleTips('此操作将删除该流程及其子节点, 是否继续?', function(that) {
        api.configManage.delflowbyid(id).then((response) => {
          if (response.data.code === '0') {
            that.getProcessList()
            that.$message({
              duration: 1500,
              type: 'success',
              message: '删除成功!'
            })
          } else {
            that.$message.error(response.data.msg)
          }
        }).catch(() => {
          that.$message({
            duration: 1500,
            message: '抱歉，出错了',
            type: 'error'
          })
        })
      })
    },
    doAddProcess (moduleId, moduleName) { // 显示新增流程弹窗
      this.addProcessDetail.module_id = moduleId
      this.addProcessDetail.module_name = moduleName
      this.isShowProcess = true
    },
    goEditProcess () { // 显示or隐藏编辑按钮
      this.isEditProcess = !this.isEditProcess
    },
    onSaveProcess (data) { // 流程修改保存
      // let data = this.addProcessDetail
      console.log(data)
      if (!data.flow_name) {
        this.$message({
          duration: 1500,
          message: '流程名称不能为空',
          type: 'warning',
        })
        return false
      }

      if (!data.k2_process_code) {
        this.$message({
          duration: 1500,
          message: 'k2流程模板ID不能为空',
          type: 'warning',
        })
        return false
      }
      if (!this.isAddProcessLoading) {
        this.isAddProcessLoading = true
        api.configManage.saveflow(data).then((response) => {
          if (response.data.code === '0') {
            this.isAddProcessLoading = false
            this.isShowProcess = false
            this.addProcessDetail = {
              module_name: null,
              k2_process_code: null,
              remark: null
            }
            this.getProcessList()
            this.$message({
              duration: 1500,
              message: '创建成功',
              type: 'success'
            })

          } else {
            this.isAddProcessLoading = false
            this.$message.error(response.data.msg)
          }
        }).catch((err) => {
          this.isAddProcessLoading = false
          this.$message({
            duration: 1500,
            message: '抱歉，出错了',
            type: 'error'
          })
        })
      } else {
        this.$message({
          duration: 1500,
          message: '提交中,请稍等...'
        })
      }
    },
    doAddNode (data) { // 显示新增节点弹窗
      if (data) {
        this.nodeData.k2_node_id = data.k2_node_id
        this.nodeData.node_pagename = data.node_pagename
        this.nodeData.remark = data.remark
      }
      this.isShowNode = true
    },
    onSaveNode () { // 节点编辑保存
      let data = this.nodeData
      if (!data.k2_node_id) {
        this.$message({
          duration: 1500,
          message: '节点名称不能为空',
          type: 'warning',
        })
        return false
      }
      if (!data.node_pagename) {
        this.$message({
          duration: 1500,
          message: '对应的页面名字不能为空',
          type: 'warning',
        })
        return false
      }
      if (!this.isAddNodeLoading) {
        this.isAddNodeLoading = true
        api.configManage.savenode(data).then((response) => {
          if (response.data.code === '0') {
            this.isAddNodeLoading = false
            this.isShowNode = false
            this.nodeData = {
              k2_node_id: null,
              node_pagename: null,
              remark: null
            }
            this.getNodeList()
            this.$message({
              duration: 1500,
              message: '创建成功',
              type: 'success'
            })

          } else {
            this.isAddNodeLoading = false
            this.$message.error(response.data.msg)
          }
        }).catch((err) => {
          this.isAddNodeLoading = false
          this.$message({
            duration: 1500,
            message: '抱歉，出错了',
            type: 'error'
          })
        })
      } else {
        this.$message({
          duration: 1500,
          message: '提交中,请稍等...'
        })
      }
    },
    onDeteleNode (id) { // 删除节点
      this.showDeteleTips('此操作将删除该节点, 是否继续?', function(that) {
        api.configManage.delnodebyid(id).then((response) => {
          if (response.data.code === '0') {
            that.getNodeList()
            that.$message({
              duration: 1500,
              type: 'success',
              message: '删除成功!'
            })
          } else {
            that.$message.error(response.data.msg)
          }
        }).catch(() => {
          that.$message({
            duration: 1500,
            message: '抱歉，出错了',
            type: 'error'
          })
        })
      })
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
