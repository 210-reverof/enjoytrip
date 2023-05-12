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

// Route
import MyRouteList from "@/components/route/MyRouteList.vue";
import MyRouteAdd from "@/components/route/MyRouteAdd.vue";
import MyRouteDetail from "@/components/route/MyRouteDetail.vue";

// Search
import SearchArea from "@/components/search/SearchArea.vue";

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
    component: SearchView,
    redirect: '/search/area',
    children: [
      {
        path: 'area',
        name: 'searcharea',
        component: SearchArea,
      }
    ]
  },
  {
    path: '/myroute',
    name: 'myroute',
    component: MyRouteView,
    redirect: '/myroute/list',
    children: [
      {
        path: 'list',
        name: 'myroutelist',
        component: MyRouteList,
      },
      {
        path: 'add',
        name: 'myrouteadd',
        component: MyRouteAdd,
      },
      {
        path: 'detail/:routeId',
        name: 'myroutedetail',
        component: MyRouteDetail,
      }
    ]
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
