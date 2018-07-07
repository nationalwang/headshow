<template>
	<div>
		<el-header class="headerBar">
			<span class="Profile">
				<img src="http://img.netbian.com/file/2018/0418/29b05368c9d48a8105c7545dcb839cf2.jpg" alt="">
			</span>
			<ul class="myInfo">
				<li class="proName">
					{{form.name}}
				</li>
				<li>
					<p>说明说明说明说明说明说明说明描述描述描述描述描述描述描述描述描述描述详情详情详情详情详情详情</p>
				</li>
			</ul>
		</el-header>


		<el-form ref="form" :model="form" label-width="80px">
			<el-form-item label="人员管理">
				<div class="tag">
					<el-tag
						:key="tag"
						v-for="tag in dynamicTags"
						closable
						:disable-transitions="false"
						@close="handleClose(tag)">
						{{tag}}
					</el-tag>
					<el-input
						class="input-new-tag"
						v-if="inputVisible"
						v-model="inputValue"
						ref="saveTagInput"
						size="small"
						@keyup.enter.native="handleInputConfirm"
						@blur="handleInputConfirm"
					>
					</el-input>
					<el-button v-else class="button-new-tag" size="small" @click="showInput">添加</el-button>
				</div>
			</el-form-item>
			<el-form-item label="已有权限">
				<div class="tag">
					<el-tag
						v-for="tag in tags"
						:key="tag.name"
						closable
						:type="tag.type"
					>
						{{tag.name}}
					</el-tag>
				</div>
			</el-form-item>
			<el-form-item label="全部权限">
				<div class="tag">
					<el-tag
						v-for="tag in tags"
						:key="tag.name"
						:closable="Closable"
						:type="tag.type"
					>
						{{tag.name}}
					</el-tag>
				</div>
			</el-form-item>
			<el-form-item label="活动名称">
				<el-input v-model="form.name"></el-input>
			</el-form-item>
			<el-form-item label="活动区域">
				<el-select v-model="form.region" placeholder="请选择活动区域">
				<el-option label="区域一" value="shanghai"></el-option>
				<el-option label="区域二" value="beijing"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="活动时间">
				<el-col :span="11">
				<el-date-picker type="date" placeholder="选择日期" v-model="form.date1" style="width: 100%;"></el-date-picker>
				</el-col>
				<el-col class="line" :span="2">-</el-col>
				<el-col :span="11">
				<el-time-picker type="fixed-time" placeholder="选择时间" v-model="form.date2" style="width: 100%;"></el-time-picker>
				</el-col>
			</el-form-item>
			<el-form-item label="即时配送">
				<el-switch v-model="form.delivery"></el-switch>
			</el-form-item>
			<el-form-item label="活动性质">
				<el-checkbox-group v-model="form.type">
				<el-checkbox label="美食/餐厅线上活动" name="type"></el-checkbox>
				<el-checkbox label="地推活动" name="type"></el-checkbox>
				<el-checkbox label="线下主题活动" name="type"></el-checkbox>
				<el-checkbox label="单纯品牌曝光" name="type"></el-checkbox>
				</el-checkbox-group>
			</el-form-item>
			<el-form-item label="特殊资源">
				<el-radio-group v-model="form.resource">
				<el-radio label="线上品牌商赞助"></el-radio>
				<el-radio label="线下场地免费"></el-radio>
				</el-radio-group>
			</el-form-item>
			<el-form-item label="活动形式">
				<el-input type="textarea" v-model="form.desc"></el-input>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" >确定修改</el-button>
				<el-button>取消</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>

<script>
	export default {
		data(){
			return{
				index:0,
				formName:"组织名称",
				Closable:true,
				sideList:[
					{
						"name":"第1项"
					},
					{
						"name":"第2项"
					},
					{
						"name":"第3项"
					}
				],
				tags: [
					{ name: '标签一', type: 'scsds' },
					{ name: '标签二', type: 'success' },
					{ name: '标签三', type: 'success' },
					{ name: '标签四', type: 'warning' },
					{ name: '标签五', type: 'danger' }
				],
				form: {
					name: '碧桂园开发部',
					region: '',
					date1: '',
					date2: '',
					delivery: false,
					type: [],
					resource: '',
					desc: ''
				},
				dynamicTags: ['张三', '李四', '黄五'],
				inputVisible: false,
				inputValue: ''
			}
		},
		methods: {
			changeName(){
				
			},
			handleClose(tag) {
				this.dynamicTags.splice(this.dynamicTags.indexOf(tag), 1);
			},

			showInput() {
				this.inputVisible = true;
				this.$nextTick(_ => {
					this.$refs.saveTagInput.$refs.input.focus();
				});
			},

			handleInputConfirm() {
				let inputValue = this.inputValue;
				if (inputValue) {
					this.dynamicTags.push(inputValue);
				}
					this.inputVisible = false;
					his.inputValue = '';
			},
			editThis(){
				
			}
		}
	}


</script>

<style scoped>
	.el-header{
		background: transparent;
	}
	.el-tag{
		margin-right:8px; 
	}

	.headerBar{
		background: transparent;
		height:120px !important;
		padding:20px !important;
		display: flex;
		align-items: center;
	}
	.headerBar>div{
		height: 100%;
		padding: 10px;
		width: 0px;
		flex-grow: 1;
	}
	.headerBar>div>h1{
		padding-left: 8px;
		font-size: 16px;
		color: #333
	}

	.headerBar>div>.el-tag{
		margin-left: 8px;
	}

	.myInfo{
		height: 100%;
		margin-left: 20px;
	}

	.proName{
		height: 22px;
		box-sizing: border-box;

	}

	.myInfo li{
		font-size: 16px;
		color: #333;
	}

	.myInfo p{
		width: 100%;
		font-size: 14px;
		color: #666;
	}

	.Profile{
		display: inline-block;
		height: 80px;
		width: 80px;
		overflow: hidden;
		border-radius: 6px;
	}
	.Profile img{
		height: 100%;
		width: auto;
	}

</style>