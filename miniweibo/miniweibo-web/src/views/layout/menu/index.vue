<template>
    <div>
        <el-menu :default-active="$route.path" class="el-menu-vertical-demo" background-color="#112f50" text-color="#fff"
            active-text-color="#ffd04b" router :collapse="isCollapse">
            <el-menu-item>
                <span slot="title">Miniweibo管理系统</span>
            </el-menu-item>
            <el-menu-item index="/">
                <i class="el-icon-menu"></i>
                <span slot="title">首页</span>
            </el-menu-item>

            <el-submenu index="/product">
                <template slot="title">
                    <i class="el-icon-s-order"></i>
                    <span>产品管理</span>
                </template>
                <el-menu-item-group>
                    <el-menu-item index="/product/list">产品列表</el-menu-item>
                    <el-menu-item index="/product/category">产品分类</el-menu-item>
                </el-menu-item-group>
                 
            </el-submenu>
            <el-menu-item index="2">
                <i class="el-icon-menu"></i>
                <span slot="title">导航二</span>
            </el-menu-item>
            <el-menu-item index="3" disabled>
                <i class="el-icon-document"></i>
                <span slot="title">导航三</span>
            </el-menu-item>
            <el-menu-item index="/login">
                <i class="el-icon-setting"></i>
                <span slot="title">系统管理</span>
            </el-menu-item>
        </el-menu>
    </div>
</template>
<script>
export default {
    props:['isCollapse'],
    data(){
        return{
            // isCollapse:false
        }
    }
}
</script>

<style lang="less" scoped>
.el-menu {
    border-right: 0;
}

/deep/.is-active {
    background: #1e78bf !important;
    color: #fff;
}
.el-menu-vertical-demo:not(.el-menu--collapse) {
    // 不折叠的宽度
    width: 200px;
    min-height: 400px;
  }

</style>