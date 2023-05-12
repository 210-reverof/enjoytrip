<template>
  <div class="row justify-content-center">
    <div class="col-lg-8 col-md-10 col-sm-12">
      <h2 class="my-3 py-3 shadow-sm bg-light text-center">
        <mark class="sky">나의 여행 목록</mark>
      </h2>
    </div>
    <div class="col-lg-8 col-md-10 col-sm-12">
      <div class="row align-self-center mb-2">
        <div class="col-md-2 text-start">
          <a href="#" class="btn btn-outline-primary btn-sm">
            여행 경로 추가하기
          </a>
        </div>
      </div>
      <table class="table table-hover">
        <thead>
          <tr class="text-center">
            <th scope="col">경로번호</th>
            <th scope="col">제목</th>
            <th scope="col">작성자</th>
            <th scope="col">생성일</th>
          </tr>
        </thead>
        <tbody>
          <my-route-list-item v-for="route in routes" :key="route.routeId" :route="route"></my-route-list-item>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import MyRouteListItem from "@/components/route/MyRouteListItem.vue";

export default {
  name: "MyRouteList",
  components: {
    MyRouteListItem,
  },
  data() {
    return {
      routes: [],
    };
  },
  created() {
    this.getList();
  },
  methods: {
    movePage() {
      this.$router.push("/myroute/add");
    },
    getList() {
      let config = {
        method: "get",
        url: "http://localhost:8080/enjoytrip/api/route/?userId=ww",
      };

      axios
        .request(config)
        .then((response) => {
            console.log(response.data);
          this.routes = response.data;
        })
    },
  },
};
</script>
