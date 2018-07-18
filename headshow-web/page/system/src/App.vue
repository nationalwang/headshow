<template>
	<div id="app">
		<div v-if="checkLogin()">
			<el-container class="appContent">
				<el-header>
					<navbar></navbar>
				</el-header>
				<el-container>
					<el-aside width="200px" class="leftNav">
						<sidebar></sidebar>
					</el-aside>
					<el-container>
						<el-main>
							<top-tabs></top-tabs>
							<app-main class="app-main"></app-main>
						</el-main>
						<!-- <el-footer>
							<footer-bar></footer-bar>
						</el-footer> -->
					</el-container>
				</el-container>
			</el-container>
		</div>
		<div v-else>
			<login></login>
		</div>
	</div>
</template>

<script>
import Navbar from './components/layout/Navbar'
import Sidebar from './components/layout/Sidebar'
import AppMain from './components/layout/AppMain'
import FooterBar from './components/layout/FooterBar'
import Login from './views/Login/Login'
import TopTabs from './components/layout/TopTabs'

export default {
  components: {
    Navbar,
    Sidebar,
    AppMain,
    FooterBar,
    Login,
    TopTabs
  },
  methods: {
    checkLogin () {
      return true
    }
  }
}
</script>

<style scoped>
#app,#app>div,
.appContent{
	height: 100%;
	width: 100%;
	overflow: hidden;
}

.appContent{

}

.appContent>header{

}
.appContent>section{
	flex-grow: 1;
	height: 1px;
}

.leftNav{
	box-shadow: 0px 1px 11px #ccc;
}

.el-main {
  padding: 0;
  min-height: 80vh;
  display: flex;
  flex-direction: column;
}

.app-main{
	height: 100%;
	flex-grow: 1;
	overflow: auto;
}

</style>
