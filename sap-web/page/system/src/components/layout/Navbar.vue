<template>
    <el-row>
        <el-col :span="20">
            <div class="logo-box">表单管理系统</div>
        </el-col>
        <el-col :span="4">
            <div class="user-box">
                <i class="icon icon-user"></i>
                <span>XXXX</span>
                <i class="icon icon-exit"></i>
            </div>
        </el-col>
      </el-row>
</template>

<script>

export default {
}
</script>
<style>
.el-header {
    padding: 0 40px 0 20px;
    background-color: #3e94e1;
}
.el-row, .el-col, .el-row>div, .el-col>div {
    height: 100%;
}
.logo-box, .user-box {
    line-height: 60px;
    font-size: 22px;
    font-weight: bold;
    color: #fff;
}
.user-box {
    font-weight: normal;
    text-align: right;
}
.user-box span {
    margin: 0 16px;
    font-size: 14px;
}
.icon-user {
    background: url('../../assets/icon-user-white.png') no-repeat;
    background-size: 100% 100%;
    vertical-align: middle;
}
.icon-exit {
    background: url('../../assets/icon-user-pull.png') no-repeat;
    background-size: 100% 100%;
    vertical-align: middle;
}
</style>
