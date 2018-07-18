<template>
  <el-dialog title="新增接口"
             :visible.sync="isShow"
             :close-on-click-modal="false"
             :show-close="false">
    <el-form ref="form" :model="data" label-width="150px">
      <el-form-item label="接口名称">
        <el-input v-model="data.name"></el-input>
      </el-form-item>
      <el-form-item label="方法名称">
        <el-input v-model="data.name"></el-input>
      </el-form-item>
      <el-form-item label="接口类型">
        <el-input v-model="data.name"></el-input>
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

