<template>
  <el-form ref="form" :model="data" label-width="200px">
    <el-form-item label="当前模块">
      <el-input v-model="data.module_name" :disabled="true"></el-input>
    </el-form-item>
    <el-form-item label="流程名称">
      <el-input v-model="data.flow_name" :disabled="!isEditProcess"></el-input>
    </el-form-item>
    <el-form-item label="k2流程模板ID">
      <el-input v-model="data.k2_process_code" :disabled="!isEditProcess"></el-input>
    </el-form-item>
    <el-form-item label="备注">
      <el-input type="textarea" v-model="data.remark" :disabled="!isEditProcess"></el-input>
    </el-form-item>
    <el-form-item>
      <slot name="add-process-btn-box"></slot>
    </el-form-item>
  </el-form>
</template>

<script>
export default {
  props: {
    data: Object,
    onSubmit: Function,
    isEditProcess: Boolean
  }
}
</script>
