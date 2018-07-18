<template>
  <div class="sTable">
    <table>
      <thead>
        <tr>
          <td width="8%">序号</td>
          <td width="15%">数据名称</td>
          <td width="15%">数据库表名</td>
          <td width="15%">数据类型</td>
          <td width="10%">创建人</td>
          <td width="15%">创建时间</td>
          <td width="21%">操作</td>
        </tr>
      </thead>
      <tbody>
        <tr class="metadataTr">
          <td>序号</td>
          <td>数据名称</td>
          <td>数据库表名</td>
          <td>数据类型</td>
          <td>创建人</td>
          <td>创建时间</td>
          <td class="operation-box">
            <a href="javascript:;" @click="onDataUpdate" class="blue">编辑</a>
            <a href="javascript:;" onclick="doDeteleMetadata();" class="red">删除</a>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  props: {
    onChange: Function
  },
  methods: {
    onDataUpdate () {
      this.onChange()
    }
  }
}
</script>
