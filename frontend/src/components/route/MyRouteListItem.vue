<template>
    <tr>
      <td v-on:click="moveDetail">{{route.routeId}}</td>
      <td>{{route.title}}</td>
      <td>{{route.userId}}</td>
      <td>{{route.createdAt}}</td>
    </tr>
  </template>
  
  <script>
  export default {
    name: "MyRouteListItem",
    props:{
      route: Object
    },
    methods: {
      moveDetail() {
        this.$router.push('/myroute/detail/' + this.route.routeId)
      }
    }
  };
  </script>
  
  <style></style>