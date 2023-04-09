<template>
    <div>
        <div class="header">
            <div class="open">
                <span v-if="!isCollapse" class="el-icon-s-fold" @click="changeMenu"></span>
                <span v-if="isCollapse" class="el-icon-s-unfold" @click="changeMenu"></span>

            </div>
        </div>
        <router-view></router-view>
    </div>
</template>
<script>

export default {
    props:['isCollapse'],
    methods:{
        changeMenu(){
            this.$emit('changeShow')
        }
    }
}
</script>

<style lang="less" scoped>
.header{
    height: 50px;
    background: #1e78bf;
    color: #fff;
    line-height: 50px;
    .open{
        font-size: 30px;
        cursor: pointer;
    }
}
</style>