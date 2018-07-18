<template>
  <el-dialog title="节点编辑"
             :visible.sync="isShow"
             :close-on-click-modal="false"
             :show-close="false">
    <el-form ref="form" :model="data" label-width="150px">
      <el-form-item label="流程名称">
        <el-input v-model="data.processName" :disabled="true"></el-input>
      </el-form-item>
      <el-form-item label="节点名称">
        <el-input v-model="data.k2_node_id"></el-input>
      </el-form-item>
      <el-form-item label="对应的页面名字">
        <el-input v-model="data.node_pagename"></el-input>
      </el-form-item>
      <el-form-item label="备注">
        <el-input type="textarea" v-model="data.remark"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">提 交</el-button>
        <el-button @click="onClose">取 消</el-button>
      </el-form-item>
    </el-form>
  </el-dialog>
</template>

<script>
export default {
  props: {
    isShow: Boolean,
    data: Object,
    onSubmit: Function,
    onClose: Function,
    isAddNodeLoading: Boolean
  }
}
</script>

