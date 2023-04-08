<template>
    <div class="layout">
        <!-- 左侧导航栏 -->
        <div class="menu">
            <Menu></Menu>
        </div>
        <!-- 右侧内容? -->
        <div class="content">
            <Content></Content>
        </div>
    </div>
    
</template>
<script>
import Menu from './menu/index.vue'
import Content from './content/index.vue'

export default{
    // 组件注册
    components:{
        Menu,
        Content
    }
}
</script>

<style lang="less" scoped>
.layout{
    display: flex;
    .menu{
        width: 200px;
        background: #888;
        position: fixed;
        left: 0;
        top: 0;
        bottom: 0;
    }
    .content{
        // flex: 1;
        padding-left: 200px;
    }
}
</style>