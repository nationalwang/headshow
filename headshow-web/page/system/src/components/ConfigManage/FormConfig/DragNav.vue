<template>
  <div class="leftNav">
    <ul class="nav_frist_box">
      <li class="nav_frist">
        <a href="javascript:void(0);" :class="firstActive" @click="showOrHideNav">
          <span>费用报销</span>
          <i :class="iconClass"></i>
        </a>
        <ul class="nav_second_box" v-show="isShow">
          <li class="nav_second"
              v-for="item in list"
              :key="item.id"
              draggable="true"
              @dragstart="onDragStart($event, item, navType)"
              @dragend="onDragEnd($event, item, navType)">
            <a>
              <i class="navChildIcon"></i>
              <span>
                {{ item.name }}
              </span>
            </a>
          </li>
        </ul>
      </li>
    </ul>
  </div>
</template>
<script>
export default {
  props: {
    onDragStart: Function,
    onDragEnd: Function,
    navType: Number
  },
  data () {
    return {
      isShow: false,
      firstActive: '',
      iconClass: 'el-icon-caret-top iconArrow',
      index: '',
      list: [
        { name: '现金还款0', id: '1' },
        { name: '现金还款1', id: '2' }
      ]
    }
  },
  methods: {
    showOrHideNav () {
      if (this.isShow) {
        this.firstActive = ''
        this.iconClass = 'el-icon-caret-top iconArrow'
      } else {
        this.firstActive = 'nav_first_active'
        this.iconClass = 'el-icon-caret-bottom iconArrow'
      }
      this.isShow = !this.isShow
    }
  }
}
</script>
