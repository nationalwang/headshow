<template>
	<div>
		<el-form  id="ruleForm" :model="ruleForm2" status-icon :rules="rules2" ref="ruleForm2" label-width="100px" >
			<el-form-item label="角色名称" prop="pass">
				<el-input type="text" v-model="ruleForm2.pass" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="角色描述" prop="checkPass">
				<el-input type="text" v-model="ruleForm2.checkPass" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="submitForm('ruleForm2')">提交</el-button>
				<el-button @click="resetForm('ruleForm2')">重置</el-button>
			</el-form-item>
		</el-form>
		<div class="checkBox">
			<ul>
				<li >
					<el-checkbox :indeterminate="isIndeterminate" v-model="checkAll" @change="handleCheckAllChange">城市</el-checkbox>
					<div style="margin: 15px 0;"></div>
					<el-checkbox-group v-model="checkedCities" @change="handleCheckedCitiesChange">
						<el-checkbox v-for="city in cities" :label="city" :key="city">{{city}}</el-checkbox>
					</el-checkbox-group>
				</li>
			</ul>
		</div>
	</div>
</template>

<script>
	
	const cityOptions = ['上海', '北京', '广州', '深圳','成都','佛山','南京','中山','珠海','东莞','无锡','苏州','宁波',
						'福州','厦门','南昌','长沙','汕头','海口','三亚','南宁','贵阳','昆明','拉萨','兰州','西宁','银川'];
	export default {
    	data() {
      	var validatePass = (rule, value, callback) => {
			if (value === '') {
				callback(new Error('请输入角色名称'));
			} else {
			if (this.ruleForm2.checkPass !== '') {
				this.$refs.ruleForm2.validateField('checkPass');
			}
				callback();
			}
      	};
      	var validatePass2 = (rule, value, callback) => {
			if (value === '') {
				callback(new Error('请输入角色描述'));
			} else {
				callback();
			}
     	 };
      	return {
			ruleForm2: {
				pass: '',
				checkPass: '',
				age: ''
			},
			rules2: {
				pass: [
					{ validator: validatePass, trigger: 'blur' }
				],
				checkPass: [
					{ validator: validatePass2, trigger: 'blur' }
				]
			},
			checkAll: false,
			checkedCities: ['上海', '北京'],
			cities: cityOptions,
			isIndeterminate: true
      	};
    },
    methods: {
		submitForm(formName) {
			this.$refs[formName].validate((valid) => {
				if (valid) {
					alert('submit!');
				} else {
				console.log('error submit!!');
					return false;
				}
			});
		},
		resetForm(formName) {
			this.$refs[formName].resetFields();
		},
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
  }
</script>
<style scoped>
	.el-main{
		background: #f7f7f7;
		width: 100%;
		height: 100%;
	}
	#ruleForm{
		width: 60%;
	}
	.checkBox{
		padding: 10px;
	}

	.checkBox>ul{
		padding: 10px;
	}

	.checkBox>ul>li{
		border-radius: 4px;
		border: 1px solid #ececec;
		padding: 10px;
	}

	.el-checkbox{
		margin-left: auto;
		margin-right: 20px;
		margin-bottom: 8px;
	}
</style>
