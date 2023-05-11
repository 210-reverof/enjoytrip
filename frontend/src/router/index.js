import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import SearchView from '@/views/SearchView.vue'
import MyRouteView from '@/views/MyRouteView.vue'
import HotPlaceView from '@/views/HotPlaceView.vue'
import ShareView from '@/views/ShareView.vue'
import InformView from '@/views/InformView.vue'

// Inform
import InformList from "@/components/InformArticle/InformList.vue";
import InformDetail from "@/components/InformArticle/InformDetail.vue";
import InformWrite from "@/components/InformArticle/InformWrite.vue";
import InformModify from "@/components/InformArticle/InformModify.vue";

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
    path: '/inform',
    name: 'inform',
    component: InformView,
    redirect: '/inform/list',
    children: [
      {
        path: 'list',
        name: 'informlist',
        component: InformList,
      },
      {
        path: 'write',
        name: 'informwrite',
        component: InformWrite,
      },
      {
        path: 'detail/:no',
        name: 'informdetail',
        component: InformDetail,
      },
      {
        path: 'modify/:no',
        name: 'informmodify',
        component: InformModify,
      },
    ]
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
