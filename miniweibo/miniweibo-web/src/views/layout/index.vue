<template>
    <div class="layout">
        layout页面
        <!-- 左侧导航栏 -->
        <div class="menu">
            <Menu :isCollapse="isCollapse"></Menu>
        </div>
        <!-- 右侧内容? -->
        <div class="content" :class="{small:isCollapse}">
            <Content :isCollapse="isCollapse" @changeShow="changeShow" ></Content>
        </div>
    </div>
    
</template>
<script>
import Menu from './menu/index.vue'
import Content from './content/index.vue'

export default{
    name : 'home',
    // 组件注册
    components:{
        Menu,
        Content
    },
    data(){
        return{
            isCollapse:false
        }
    },
    methods:{
        changeShow(){
            this.isCollapse=!this.isCollapse;
        }
    }
}
</script>

<style lang="less" scoped>
.layout{
    // display: flex;
    .menu{
        // width: 200px;
        background: #112f50;
        position: fixed;
        left: 0;
        top: 0;
        bottom: 0;
    }
    .content{
        // flex: 1;
        padding-left: 200px;
    }

    // 折叠时候的样式
    .small{
        padding-left: 64px;
    }
}
</style>