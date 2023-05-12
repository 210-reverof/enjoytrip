<template>
  <div>
    <div class="sb-nav-fixed">
      <div class="mt-5 pt-5">
        <div class="container px-4">
          <h1 class="mt-4 d-flex justify-content-center">
            여행 경로 추천해요!
          </h1>
          <div
            class="container rounded bg-secondary bg-opacity-25 text-secondary fs-2 p-4 mb-2"
          >
            {{ route.title }}
            <div class="row mt-2">
              <div class="col fs-4 text-dark">
                {{ route.userId }}<br />
                {{ route.createdAt }}
              </div>
            </div>
            <div
              class="container rounded bg-white bg-opacity-50 fs-4 text-center"
            >
              <div id="route-panel" class="row row-cols-1 row-cols-md-3 g-4">
                <my-route-detail-item
                  v-for="attr in route.attractions"
                  :key="attr.contentId"
                  :attr="attr"
                ></my-route-detail-item>
              </div>
            </div>
            <div class="d-flex justify-content-end">
              <div class="text-nowrap ms-2">
                <router-link to="/myroute" class="btn btn-outline-primary">
                  글목록
                </router-link>
                <router-link to="/myroute" class="btn btn-outline-success">
                글수정
                </router-link>
                <router-link to="/myroute" class="btn btn-outline-danger">
                글삭제
                </router-link>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import MyRouteDetailItem from "./MyRouteDetailItem.vue";

export default {
  name: "MyRouteDetail",
  components: {
    MyRouteDetailItem,
  },
  data() {
    return {
      route: "",
    };
  },
  created() {
    this.getDetail();
  },
  methods: {
    getDetail() {
      let config = {
        method: "get",
        url:
          "http://localhost:8080/enjoytrip/api/route/" +
          this.$route.params.routeId,
      };

      axios.request(config).then((response) => {
        this.route = response.data;
      });
    },
  },
};
</script>
