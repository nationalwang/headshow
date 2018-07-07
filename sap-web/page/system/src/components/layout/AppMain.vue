<template>
	<div class="">
		<Levelbar class=""></Levelbar>
		<transition
			mode="out-in"
			enter-active-class="fadeIn"
			leave-active-class="fadeOut"
			appear
		>
			<router-view class="animated"></router-view>
		</transition>
	</div>
</template>

<script>
import Levelbar from './Levelbar'

export default {
  components: {
    Levelbar
  }
}
</script>

<style scoped>
	.animated{
		/* height: 100%; */
	}

	.animated>>>.el-container{
		height: 100%;
	}
</style>


