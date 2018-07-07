<template>
  <div class="loginBox">
    <div class="loginTitle">登录</div>
    <div class="loginInfo">
      <el-form label-width="50px">
        <el-form-item label="账号">
          <el-input v-model="name" placeholder="请输入帐号"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="name" placeholder="请输入密码"></el-input>
        </el-form-item>
        <div class="loginBtn">
         <el-button type="primary" @click="onSubmit">登录</el-button>
        </div>
      </el-form>
    </div>
  </div>
</template>

<script>
import '../../../static/css/login.css'

export default {
  data () {
    return {
      name: '',
      pwd: ''
    }
  },
  methods: {
    onSubmit () {
      console.log('submit!')
    }
  }
}
</script>
