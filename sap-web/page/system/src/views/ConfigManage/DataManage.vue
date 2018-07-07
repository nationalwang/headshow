<template>
  <div class="container">
    <el-row>
      <el-col :span="5">
        <div class="leftBox">
          <div class="title textCenter">流程目录</div>
          <div>
            <left-nav :on-change="childChang"></left-nav>
            <left-nav :on-change="childChang"></left-nav>
          </div>
        </div>
      </el-col>
      <el-col :span="19">
        <div class="rightBox">
          <div class="title textLeft">元数据列表</div>
          <div class="rightTable">
            <data-list :on-change="onDataUpdateShowOrHide"></data-list>
          </div>
          <div class="title textLeft borderTop">字段列表</div>
          <div class="rightTable">
            <fieId-list :on-change="onFieIdUpdateShowOrHide"></fieId-list>
          </div>
        </div>
      </el-col>
    </el-row>
    <data-update :data="updateData"
                 :is-show="isShow"
                 :on-submit="onUpdateData"
                 :on-close="onDataUpdateShowOrHide"></data-update>
    <fieId-update :data="fieIdData"
                  :is-show="fieIdIsShow"
                  :on-submit="onFieIdUpdateData"
                  :on-close="onFieIdUpdateShowOrHide"></fieId-update>
  </div>
</template>

<script>
import LeftNav from '../../components/ConfigManage/LeftNav'
import DataList from '../../components/ConfigManage/DataManage/DataList'
import DataUpdate from '../../components/ConfigManage/DataManage/DataUpdate'
import FieIdList from '../../components/ConfigManage/DataManage/FieIdList'
import FieIdUpdate from '../../components/ConfigManage/DataManage/FieIdUpdate'

export default {
  components: {
    LeftNav,
    DataList,
    DataUpdate,
    FieIdList,
    FieIdUpdate
  },
  data () {
    return {
      updateData: {
        name: 1
      },
      isShow: false,
      fieIdData: {
        name: 1
      },
      fieIdIsShow: false
    }
  },
  methods: {
    childChang () {
      // 选中流程项，处理逻辑
    },
    onDataUpdateShowOrHide () {
      // 元数据修改弹窗显示OR隐藏
      this.isShow = !this.isShow
    },
    onUpdateData () {
      // 修改元数据保存
    },
    onFieIdUpdateShowOrHide () {
      // 字段信息修改弹窗显示OR隐藏
      this.fieIdIsShow = !this.fieIdIsShow
    },
    onFieIdUpdateData () {
      // 修改字段信息保存
    }
  }
}
</script>
