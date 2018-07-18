<template>
  <div class="container">
    <div class="searchBoxLog">
      <el-form :inline="true" :model="formInline" class="demo-form-inline">
        <el-form-item>
          <el-input v-model="formInline.name" placeholder="接口名称"></el-input>
        </el-form-item>
        <el-form-item>
          <el-date-picker v-model="formInline.date"
                          type="datetimerange"
                          range-separator="至"
                          start-placeholder="开始时间"
                          end-placeholder="结束时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" size="small" @click="searchAction">搜索</el-button>
        </el-form-item>
        <el-form-item></el-form-item>
      </el-form>
    </div>
    <div class="interfaceInfo">
      <report-list></report-list>
    </div>
    <div class="pageBox">
      <el-pagination @size-change="handleSizeChange"
                     @current-change="handleCurrentChange"
                     :current-page.sync="currentPage"
                     :page-size="pageSize"
                     layout="prev, pager, next, jumper"
                     :total="total">
      </el-pagination>
    </div>
  </div>
</template>

<script>
import ReportList from '../../components/InterfaceManage/ReportList'

export default {
  components: {
    ReportList
  },
  data() {
    return {
      currentPage: 1,
      pageSize: 10,
      total: 2,
      formInline: {
        name: '',
        date: ''
      }
    }
  },
  methods: {
    handleSizeChange () {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange (val) {
      console.log(`当前页: ${val}`);
    },
    searchAction () {
      console.log(this.formInline)
    }
  }
}
</script>

