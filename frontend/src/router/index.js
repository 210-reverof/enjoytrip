import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import SearchView from '@/views/SearchView.vue'
import MyRouteView from '@/views/MyRouteView.vue'
import HotPlaceView from '@/views/HotPlaceView.vue'
import ShareView from '@/views/ShareView.vue'
import InformView from '@/views/InformView.vue'

// inform
import InformList from "@/components/inform/InformList.vue";
import InformDetail from "@/components/inform/InformDetail.vue";
import InformWrite from "@/components/inform/InformWrite.vue";
import InformModify from "@/components/inform/InformModify.vue";

// share
import ShareList from "@/components/share/ShareList.vue";
import ShareDetail from "@/components/share/ShareDetail.vue";
import ShareWrite from "@/components/share/ShareWrite.vue";
import ShareModify from "@/components/share/ShareModify.vue";

// hotplace
import HotplaceList from "@/components/hotplace/HotplaceList.vue";
import HotplaceDetail from "@/components/hotplace/HotplaceDetail.vue";
import HotplaceWrite from "@/components/hotplace/HotplaceWrite.vue";
import HotplaceModify from "@/components/hotplace/HotplaceModify.vue";


// Route
import MyRouteList from "@/components/route/MyRouteList.vue";
import MyRouteAdd from "@/components/route/MyRouteAdd.vue";
import MyRouteDetail from "@/components/route/MyRouteDetail.vue";

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
    component: HotPlaceView,
    redirect: '/hotplace/list',
    children: [
      {
        path: 'list',
        name: 'hotplacelist',
        component: HotplaceList,
      },
      {
        path: 'write',
        name: 'hotplacewrite',
        component: HotplaceWrite,
      },
      {
        path: 'detail/:no',
        name: 'hotplacedetail',
        component: HotplaceDetail,
      },
      {
        path: 'modify/:no',
        name: 'hotplacemodify',
        component: HotplaceModify,
      },
    ]
  },
  {
    path: '/share',
    name: 'share',
    component: ShareView,
    redirect: '/share/list',
    children: [
      {
        path: 'list',
        name: 'sharelist',
        component: ShareList,
      },
      {
        path: 'write',
        name: 'sharewrite',
        component: ShareWrite,
      },
      {
        path: 'detail/:no',
        name: 'sharedetail',
        component: ShareDetail,
      },
      {
        path: 'modify/:no',
        name: 'sharemodify',
        component: ShareModify,
      },
    ]
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
