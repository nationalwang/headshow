<template>
	<div>
		<el-checkbox :indeterminate="isIndeterminate" v-model="checkAll" @change="handleCheckAllChange">全选</el-checkbox>
		<div style="margin: 15px 0;"></div>
		<el-checkbox-group v-model="checkedCities" @change="handleCheckedCitiesChange">
			<el-checkbox v-for="city in cities" :label="city" :key="city">{{city}}</el-checkbox>
		</el-checkbox-group>
	</div>
</template>
<script>
  const cityOptions = ['销售订单系统', '未完成订单', '未开单菜单', '已开单菜单'];
  export default {
    data() {
      return {
        checkAll: false,
        checkedCities: ['销售订单系统', '未完成订单'],
        cities: cityOptions,
        isIndeterminate: true
      };
    },
    methods: {
      handleCheckAllChange(val) {
        this.checkedCities = val ? cityOptions : [];
        this.isIndeterminate = false;
      },
      handleCheckedCitiesChange(value) {
        let checkedCount = value.length;
        this.checkAll = checkedCount === this.cities.length;
        this.isIndeterminate = checkedCount > 0 && checkedCount < this.cities.length;
      }
    }
  };
</script>


<!--<template>
	<div>
		<el-checkbox 
			@change="changeItems(items)" 
			v-model="checkAll" 
		>表单功能</el-checkbox>
		<el-checkbox-group v-for="items in dataList" :indeterminate="isIndeterminate" >
			<div style="margin: 15px 0;"></div>
			<el-checkbox 
				v-for="item in items" 
				v-model="item.checked" 
				@change="changeItem"
				:disabled="item.disabled"
			>{{item.name}}</el-checkbox>
		</el-checkbox-group>
	</div>
</template>
<script>
  export default {
    data() {
		return {
			checkAll:false,
			dataList:[],
			isIndeterminate:false
		}
    },
    methods: {
		changeItems(val){
			if(val){
				console.log(val+'-----111');
				for( var item  in val ){
					val[item].checked = true;
				}
			}else{
				console.log(val+'-----222');
				for( var item  in val ){
					val[item].checked = false;
				}
			}
		},
		changeItem(val){
			console.log(val)
		}
	},
	created(){
		this.dataList = [
			[
				{
					name:'销售订单系统',
					checked: false,
					disabled:false
				},
				{
					name:'未完成订单',
					checked: true,
					disabled:false
				},
				{
					name:'未开单菜单',
					checked: true,
					disabled:false
				},
				{
					name:'已开单菜单',
					checked: false,
					disabled:false
				}
			],
			[
				{
					name:'销售订单系统',
					checked: false,
					disabled:true
				},
				{
					name:'未完成订单',
					checked: true,
					disabled:false
				},
				{
					name:'未开单菜单',
					checked: true,
					disabled:false
				},
				{
					name:'已开单菜单',
					checked: false,
					disabled:false
				}
			]
		];
	}
  };
</script>-->