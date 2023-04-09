import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from '@/views/layout/index.vue'
import Login from '@/views/login/index.vue'
import Home from '@/views/home/home.vue'

Vue.use(VueRouter)

const routes = [
  {
    path:'/',
    name: 'home',
    component: Layout,
    children:[
      {
        path: '/',
        name: 'home',
        component: Home
      }
    ]

    // component: () => import('../views/layout/index.vue')
  },
  {
    path:'/login',
    name: 'login',
    component: Login
    // component: () => import('../views/login/index.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
