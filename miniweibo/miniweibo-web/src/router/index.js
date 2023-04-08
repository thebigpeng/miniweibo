import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from '@/views/layout/index.vue'
import Login from '@/views/login/index.vue'

Vue.use(VueRouter)

const routes = [
  {
    path:'/',
    compoment: Layout,
  },
  {
    path:'/login',
    name: 'login',
    compoment: Login,
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
