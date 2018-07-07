<template>
  <el-dialog title="字段信息配置"
             :visible.sync="isShow"
             :close-on-click-modal="false"
             :show-close="false">
    <el-form ref="form" :model="data" label-width="150px">
      <el-form-item label="字段名称">
        <el-input v-model="data.name"></el-input>
      </el-form-item>
      <el-form-item label="字段代码">
        <el-input v-model="data.name"></el-input>
      </el-form-item>
      <el-form-item label="字段类型">
        <el-input v-model="data.name"></el-input>
      </el-form-item>
      <el-form-item label="枚举值">
        <el-input v-model="data.name"></el-input>
      </el-form-item>
      <el-form-item label="是否隐藏" prop="region">
        <el-select v-model="data.name" placeholder="请选择是否隐藏">
          <el-option label="是" value="0"></el-option>
          <el-option label="否" value="1"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSave">提 交</el-button>
        <el-button @click="onClose">取 消</el-button>
      </el-form-item>
    </el-form>
  </el-dialog>
</template>

<script>
export default {
  props: {
    data: Object,
    onSubmit: Function,
    onClose: Function,
    isShow: Boolean
  },
  methods: {
    onSave () {
      this.onSubmit()
    }
  }
}
</script>
