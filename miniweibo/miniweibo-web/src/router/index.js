import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from '@/views/layout/index.vue'
import Login from '@/views/login/login.vue'
import Home from '@/views/home/home.vue'


// 懒加载
const Product = ()=>import('@/views/product/index.vue')

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
      },
      {
        path: '/product',
        name: 'product',
        component: Product,
        children:[
          {
            path: 'list',  //访问路径：/product/list 这里不用配 / 不然会从根目录访问
            name : 'list',
            component: () => import('../views/product/list/index.vue')
          },
          {
            path: 'category',  //访问路径：/product/list 这里不用配 / 不然会从根目录访问
            name : 'category',
            component: () => import('../views/product/category/index.vue')
          }
        ]
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
