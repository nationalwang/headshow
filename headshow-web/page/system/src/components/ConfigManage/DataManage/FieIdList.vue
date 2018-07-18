<template>
  <div class="sTable">
    <table>
      <thead>
        <tr>
          <td width="16%">字段名称</td>
          <td width="16%">字段代码</td>
          <td width="16%">字段类型</td>
          <td width="16%">枚举值</td>
          <td width="16%">是否隐藏</td>
          <td width="16%">操作</td>
        </tr>
      </thead>
      <tbody>
        <tr class="metadataTr">
          <td>字段名称</td>
          <td>字段代码</td>
          <td>字段类型</td>
          <td>枚举值</td>
          <td>是否隐藏</td>
          <td class="operation-box">
            <a href="javascript:;" @click="onChange" class="blue">编辑</a>
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
  }
}
</script>
