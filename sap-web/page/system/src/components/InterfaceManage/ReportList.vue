<template>
  <div class="buleTable">
    <el-table ref="multipleTable"
              :data="tableData3"
              tooltip-effect="dark"
              style="width: 100%" border>
      <el-table-column prop="name" label="序号"></el-table-column>
      <el-table-column prop="name" label="接口名称"></el-table-column>
      <el-table-column prop="name" label="接口类型"></el-table-column>
      <el-table-column prop="name" label="调用次数"></el-table-column>
      <el-table-column prop="name" label="成功次数"></el-table-column>
      <el-table-column prop="name" label="失败次数"></el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      tableData3: [{
        name: '王小虎'
      },{
        name: '王小虎'
      }]
    }
  },
}
</script>

