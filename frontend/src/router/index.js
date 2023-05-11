import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import SearchView from '@/views/SearchView.vue'
import MyRouteView from '@/views/MyRouteView.vue'
import HotPlaceView from '@/views/HotPlaceView.vue'
import ShareView from '@/views/ShareView.vue'
import ConfirmView from '@/views/ConfirmView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/search',
    name: 'search',
    component: SearchView
  },
  {
    path: '/myroute',
    name: 'myroute',
    component: MyRouteView
  },
  {
    path: '/hotplace',
    name: 'hotplace',
    component: HotPlaceView
  },
  {
    path: '/share',
    name: 'share',
    component: ShareView
  },
  {
    path: '/confirm',
    name: 'confirm',
    component: ConfirmView
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
