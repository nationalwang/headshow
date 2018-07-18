<template>
  <el-dialog title="新增模块"
             :visible.sync="isShow"
             :close-on-click-modal="false"
             :show-close="false">
    <el-form ref="form" :model="data" label-width="150px">
      <el-form-item label="模块名称">
        <el-input v-model="data.module_name"></el-input>
      </el-form-item>
      <el-form-item label="备注">
        <el-input type="textarea" v-model="data.desc"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit" :loading="isLoading">提 交</el-button>
        <el-button @click="onClose" :loading="isLoading">取 消</el-button>
      </el-form-item>
    </el-form>
  </el-dialog>
</template>

<script>
export default {
  props: {
    isShow: Boolean,
    isLoading: Boolean,
    data: Object,
    onSubmit: Function,
    onClose: Function
  }
}
</script>

