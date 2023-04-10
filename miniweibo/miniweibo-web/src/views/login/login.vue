<template>
    <div class="clearfix" id="login_wrap">
        <div id="login">
            <h2 class="title">登陆页</h2>
            <div class="login--account">
                <span>账号：</span>
                <input type="text" placeholder="账号" name="account" v-model.trim="username" />
            </div>
            <div class="login--password">
                <span>密码</span>
                <input type="password" placeholder="请输入密码" name="password" v-model.trim="password" />
            </div>
            <p class="login--btn">
                <el-button id="loginBtn" type="primary" >登陆</el-button>
            </p>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            username: "",
            password: "",
        };
    },
    methods: {
        
    }
}
</script>

<style scoped lang="less">
.title {
    text-align: center;
    font-size: 22px;
}

#login_wrap {
    position: relative;
    background: rgba(64, 64, 194, 0.1);
    height: 100%;
    background-image: url('http://s1.ax1x.com/2023/04/09/ppHI738.jpg'); 
    background-size: 100% 100%;
    >div {
        background: #fff;
        width: 420px;
        height: 300px;
        padding: 30px 40px;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);

        >div {
            padding: 10px 0;
            border-bottom: 1px solid #ddd;

            &.login--account {
                margin: 25px 0 30px;
            }
            span {
                color: #666;
                display: inline-block;
                width: 84px;
                font-size: 20px;
            }
            input{
                background: none;
                font-size: 16px;
                border: none;
                height: 30px;
                width: 280px;
                padding-left: 12px;
                box-sizing: border-box;
                color: #666;
                &.error{
                    border: 1px solid #f00;
                }
                &::-webkit-input-placeholder{
                    color: #aaa;
                }
            }
        }

        p{
            text-align: right;
            &.login--btn{
                button {
                    width: 100%;
                    height: 50px;
                    font-size: 18px;
                    margin-top: 30px;
                }
            }
            a {
                color: #fff;
                display: inline-block;
                padding: 0 15px;
                font-size: 14px;
            }
        }
    }
}

.login{
    background-image: url('http://s1.ax1x.com/2023/04/09/ppHI738.jpg'); 
}
</style>