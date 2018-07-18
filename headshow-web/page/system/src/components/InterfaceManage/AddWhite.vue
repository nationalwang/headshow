<template>
  <el-dialog title="新增ip白名单"
             :visible.sync="isShow"
             :close-on-click-modal="false"
             :show-close="false">
    <el-form ref="form" :model="data" label-width="150px">
      <el-form-item label="ip地址">
        <el-input v-model="data.name"></el-input>
      </el-form-item>
      <el-form-item label="是否启用">
        <el-radio v-model="data.name" label="0">启用</el-radio>
        <el-radio v-model="data.name" label="1">禁用</el-radio>
      </el-form-item>
      <el-form-item label="备注">
        <el-input type="textarea" v-model="data.desc"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSumbit">提 交</el-button>
        <el-button @click="onClose">取 消</el-button>
      </el-form-item>
    </el-form>
  </el-dialog>
</template>

<script>
export default {
  props: {
    data: Object,
    isShow: Boolean,
    onClose: Function,
    onSumbit: Function
  }
}
</script>
