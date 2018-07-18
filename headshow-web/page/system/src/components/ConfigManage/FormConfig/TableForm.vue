<template>
  <div class="sTable infoTable">
    <div class="title textLeft borderB0">
      <span class="name">{{data.name}}</span>
      <span class="titleBtn">
        <el-button type="primary" @click="onAddTr(formIndex)">添加行</el-button>
        <el-button type="primary" @click="onDetele(formIndex)">删除区域</el-button>
      </span>
    </div>
    <div class="">
      <table>
        <tbody class="infoTableItme">
          <tr v-for="(item, index) in data.detail" :key="index">
            <td v-for="(t, i) in item"
                :key="i"
                @mousemove="mousemove(formIndex, index, i)">
              <div v-if="t.name !== ''">
                <span>{{t.name}}：</span>
                <el-input placeholder="请输入区域名称" style="width: 150px;" v-model="t.value"></el-input>
                <i class="icon-close el-icon-circle-close" @click="onDeteleTd(formIndex, index, i)"></i>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    isFormDragDown: Boolean,
    onUpdate: Function,
    onAddTr: Function,
    onDetele: Function,
    onDeteleTd: Function,
    data: Object,
    formIndex: Number
  },
  methods: {
    mousemove (formIndex, index, i) {
      if (this.isFormDragDown) {
        setTimeout(() => {
          this.onUpdate(formIndex, index, i)
        }, 10)
      }
    }
  }
}
</script>
