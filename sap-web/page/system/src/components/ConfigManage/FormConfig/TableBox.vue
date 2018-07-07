<template>
  <div class="detailTable">
    <div class="title borderB0">
      <span class="name">2312</span>
      <span class="titleBtn">
        <el-button type="primary" @click="onDetele(formIndex)">删除区域</el-button>
      </span>
    </div>
    <div class="detailList" @mousemove="mousemove(formIndex)">
      <el-tag v-for="(item, index) in data.detail"
              :key="index"
              closable
              :type="item.id"
              @close="handleClose(item, formIndex, index)">
        {{item.name}}
      </el-tag>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    isBoxDragDown: Boolean,
    onUpdate: Function,
    onDetele: Function,
    onDetaleTag: Function,
    data: Object,
    formIndex: Number
  },
  methods: {
    handleClose (tag, formIndex, index) {
      this.onDetaleTag(formIndex, index)
    },
    mousemove (formIndex) {
      if (this.isBoxDragDown) {
        setTimeout(() => {
          this.onUpdate(formIndex)
        }, 10)
      }
    }
  }
}
</script>

<style>
.detailList .el-tag {
  margin: 0 4px;
}
</style>
