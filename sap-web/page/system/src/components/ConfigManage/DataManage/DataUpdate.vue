<template>
  <el-dialog title="元数据编辑"
             :visible.sync="isShow"
             :close-on-click-modal="false"
             :show-close="false">
    <el-form ref="form" :model="data" label-width="150px">
      <el-form-item label="元数据名称">
        <el-input v-model="data.name"></el-input>
      </el-form-item>
      <el-form-item label="数据库表名称">
        <el-input v-model="data.name"></el-input>
      </el-form-item>
      <el-form-item label="数据类型" prop="region">
        <el-select v-model="data.name" placeholder="请选择数据类型">
          <el-option label="主表" value="0"></el-option>
          <el-option label="明细表" value="1"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="备注">
        <el-input type="textarea" v-model="data.desc"></el-input>
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
