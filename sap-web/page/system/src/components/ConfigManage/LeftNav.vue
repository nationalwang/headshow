<template>
  <div class="leftNav">
    <ul class="nav_frist_box">
      <li class="nav_frist">
        <a href="javascript:void(0);" :class="data.firstActive" @click="onChangeFirst(data.index, data.arr.id)">
          <span>{{data.arr.module_name}}</span>
          <i :class="data.iconClass"></i>
          <i class="el-icon-error" @click="onDeteleModule(data.arr.id, $event)"></i>
        </a>
        <ul class="nav_second_box" v-show="data.isShow">
          <li class="nav_second" :class="childNavClass(index)" 
                                 v-for="(item, index) in data.child"
                                 :key="index"
                                 @click="clickChlidNav(index, item.id, item.flow_name)">
            <a href="javascript:void(0);" :title="item.flow_name">
              <i class="navChildIcon"></i>
              <span>{{item.flow_name}}</span>
              <i class="el-icon-error" @click="onDeteleProcess(item.id, $event)"></i>
            </a>
          </li>
          <li>
            <slot name="add-process-box" :data="data.arr"></slot>
          </li>
        </ul>
      </li>
    </ul>
  </div>
</template>
<script>
export default {
  props: {
    data: Object,
    onChange: Function,
    onChangeFirst: Function,
    onDeteleProcess: Function,
    onDeteleModule: Function
  },
  data () {
    return {
      index: ''
    }
  },
  methods: {
    clickChlidNav (index, id, name) {
      this.index = index
      this.onChange(id, name)
    },
    childNavClass (index) {
      if (index === this.index) {
        return {'nav_second_active': true}
      } else {
        return {}
      }
    }
  }
}
</script>
