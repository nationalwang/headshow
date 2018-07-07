<template>
	<div>
		<el-container>
			<el-row style="text-align:right;">
				<router-link :to="{name:'PowerEdit'}">
					<el-button type="primary" icon="el-icon-edit" circle></el-button>
				</router-link>
				<router-link :to="{name:'PowerForm'}">
					<el-button type="success" icon="el-icon-check" circle></el-button>
				</router-link>
				<el-button type="danger" icon="el-icon-delete" circle></el-button>
			</el-row>
			<el-aside width="200px">
				<add-nav :navData = "sideList" :showAdd="true" ></add-nav>
			</el-aside>
			<el-main>
				<router-view></router-view>
			</el-main>
		</el-container>
	</div>
</template>

<script>
	import addNav from '@/components/layout/addItem';
	export default {
		data(){
			return{
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
				]
			}
		},
		components: {
			addNav
		},
		methods: {
			
		}
	}




</script>

<style scoped>
	.el-container{
		position: relative;
	}

	.el-container>.el-row{
		position: absolute;
		right: 0;
		top: 0;
	}

	.el-main{
		padding: 10px;
	}

	.PF_nav li{
		border-top: 1px solid #f7f7f7 ;
		border-bottom: 1px solid #f7f7f7;
		text-align: center;
		padding: 10px;
		box-sizing: border-box;
	}

	.PF_nav li span{
		font-size: 14px;
		color: #666;
	}

	navActive{
		color: #409EFF;
	}
	
	.formContent{
		padding: 10px;
	}

	.tag span{
		margin-left: 8px;
	}
</style>