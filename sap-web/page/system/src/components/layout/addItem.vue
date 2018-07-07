<template>
    <ul>
        <li 
            v-for="(item , index) in navData "
            @click="changeVal()"
        >
            <span>{{item.name}}</span>
        </li>
        
        <router-link @click="addItem" v-if="showAdd" class="addInp" :to="{name:'addPower'}" tag="li">
            <i v-show="!showInp" class="el-icon-circle-plus-outline"></i>
            <input 
                v-focus
                ref="addBtn"
                @blur="Out"
                @keydown.enter="Out"
                v-model="addVal"
                v-show="showInp" 
                type="button" 
                placeholder="请输入名称"
            >
        </router-link>
    </ul>
</template>

<script>
export default {
    data(){
        return{
            showInp:false,
            focusState:false,
            addVal:''
        }
    },
    props:{
        navData:Array,
        showAdd:{
            type:Boolean,
            default:false
        }
    },
    created(){
        //console.log(this.navData)
    },
    methods:{
        addItem(){
            this.showInp = !this.showInp;
            this.$refs.addBtn.focus();
        },
        addText(){
            
        },
        Out(){
            if(this.addVal == ''){
                this.showInp = !this.showInp;
                return false;
            }
            let val = {
                "name":this.addVal
            }
            this.navData.push(val)
            this.addVal = '';
            this.showInp = !this.showInp;
        }
    },
    directives: {  
        focus: function (el) {  
            setTimeout(()=>{
                el.focus()
            },100)
        }
    }
}
</script>


<style scoped>
    ul{
        height: 100%;
        border-right: 1px solid #ececec;
    }
    li{
        box-sizing: border-box;
        padding: 10px;
        text-align: center;
        color: #666;
        font-size: 14px;
        border-bottom: 1px solid #f5f5f5;
        cursor: pointer;
        height: 40px;
    }
    .addInp{
        font-size: 20px;
    }
    .addInp input{
         text-align: center;
         height: 100%;
         width: 100%;
         outline: none;
         font-size: 14px;
         color: #666;
     }
</style>
