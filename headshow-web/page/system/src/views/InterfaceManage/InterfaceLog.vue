<template>
  <div class="container">
    <div class="searchBoxLog">
      <el-form :inline="true" :model="formInline" class="demo-form-inline">
        <el-form-item>
          <el-input v-model="formInline.name" placeholder="接口名称"></el-input>
        </el-form-item>
        <el-form-item>
          <el-input v-model="formInline.ip" placeholder="ip地址"></el-input>
        </el-form-item>
        <el-form-item>
          <el-select v-model="formInline.state" placeholder="日志状态">
            <el-option label="正常" value="0"></el-option>
            <el-option label="异常" value="1"></el-option>
          </el-select>
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
      </el-form>
    </div>
    <div class="interfaceInfo buleTable">
      <el-table :data="tableData5" style="width: 100%" @expand-change="expandChange" border>
        <el-table-column type="expand">
          <template slot-scope="props">
            <div class="childTable">
              <el-table :data="tableData5" style="width: 100%" @expand-change="expandChange">
                <el-table-column label="方法名称" prop="name"></el-table-column>
                <el-table-column label="接口地址" prop="name"></el-table-column>
                <el-table-column label="传递参数" prop="name"></el-table-column>
                <el-table-column label="返回结果" prop="name"></el-table-column>
              </el-table>
            </div>
          </template>
        </el-table-column>
        <el-table-column label="接口名称" prop="name"></el-table-column>
        <el-table-column label="调用结果" prop="name"></el-table-column>
        <el-table-column label="调用时间" prop="name"></el-table-column>
        <el-table-column label="耗时(ms)" prop="name"></el-table-column>
        <el-table-column label="ip地址" prop="name"></el-table-column>
      </el-table>
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
export default {
  data() {
    return {
      currentPage: 1,
      pageSize: 10,
      total: 2,
      formInline: {
        name: '',
        ip: '',
        state: '',
        date: ''
      },
      interfaceIds: [],
      tableData5: [{
          id: '12987122',
          name: '好滋好味鸡蛋仔',
          category: '江浙小吃、小吃零食',
          desc: '荷兰优质淡奶，奶香浓而不腻',
          address: '上海市普陀区真北路',
          shop: '王小虎夫妻店',
          shopId: '10333'
        }, {
          id: '12987123',
          name: '好滋好味鸡蛋仔',
          category: '江浙小吃、小吃零食',
          desc: '荷兰优质淡奶，奶香浓而不腻',
          address: '上海市普陀区真北路',
          shop: '王小虎夫妻店',
          shopId: '10333'
        }]
    }
  },
  created () {
    this.interfaceIds = this.$route.params.id
  },
  methods: {
    searchAction() { // 搜索事件
      console.log(this.formInline)
      // var startDate = this.formInline.date[0]
      // var endDate = this.formInline.date[0]
      // let startTime = startDate.getFullYear()+'-'+(startDate.getMonth()+1)+'-'+startDate.getDate()+' '+ startDate.getHours()+':'+startDate.getMinutes()+':'+startDate.getSeconds()
      // let endTime = endDate.getFullYear()+'-'+(endDate.getMonth()+1)+'-'+endDate.getDate()+' '+ endDate.getHours()+':'+endDate.getMinutes()+':'+endDate.getSeconds()
    },
    handleSizeChange () {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange (val) {
      console.log(`当前页: ${val}`);
    },
    expandChange (row, expandedRows) {
    }
  }
}
</script>

