<template>
  <div class="myroute">
    <p>내 여행 계획</p>
    <my-route-list></my-route-list>
  </div>
</template>

<script>
import MyRouteList from '@/assets/route/MyRouteList.vue';

export default {
  name: 'MyRouteView',
  components: {
    MyRouteList
  }
}
</script>
