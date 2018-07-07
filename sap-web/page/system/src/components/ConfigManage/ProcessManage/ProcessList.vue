<template>
  <div class="buleTable">
    <el-table :data="data" border style="width: 100%">
      <el-table-column prop="id" label="序号" width="50"></el-table-column>
      <el-table-column prop="k2_process_id" label="流程名称"></el-table-column>
      <el-table-column prop="k2_node_id" label="节点名称"></el-table-column>
      <el-table-column prop="node_pagename" label="对应的页面名字"></el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button @click="onUpdate(scope.row)" type="text" size="small">编辑</el-button>
          <el-button @click="onDeteleNode(scope.row.id)" type="text" size="small" style="color: red;">删除</el-button>
          <!-- <el-button type="text" size="small">配置表单模版</el-button> -->
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  props: {
    onUpdate: Function,
    onDeteleNode: Function,
    data: Array
  }
}
</script>
