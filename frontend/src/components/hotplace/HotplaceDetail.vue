<template>
    <div class="sb-nav-fixed">
      <div class="mt-5 pt-5">
        <div class="container px-4">
          <h1 class="mt-4 d-flex justify-content-center">핫플 자랑하기</h1>

          <div
            class="container rounded bg-secondary bg-opacity-25 text-secondary fs-2 p-4 mb-2"
          >
            {{ article.articleNo }} | {{ article.title }}

            <div class="row mt-2">
              <div class="col-1">
                <img
                  src=""
                  class="rounded-circle w-100"
                  alt="noimg"
                />
              </div>
              <div class="col fs-4 text-dark">
                {{ article.userId }}<br />
                {{ article.createdAt }} {{ article.hit }}
              </div>
            </div>
            <div
              class="container rounded bg-white bg-opacity-50 fs-4 text-center"
            >
              {{ article.content }}<br />
            </div>
          </div>
          <div class="d-flex justify-content-end">
            <div class="text-nowrap ms-2">
              <a
                class="btn btn-outline-primary"
                @click="$router.push({name:'hotplace', query: {pgno:'1', key:'', word:''}})"
              >
                <!-- <i class="fas fa-table me-1"></i> -->
                <i class="fas fa-edit"></i> 글목록
              </a>
            </div>
            <!-- <v-if="" test="${not empty userinfo}">
                <c:if test="${userinfo.id eq article.userId}"> -->
            <button
              type="button"
              id="btn-mv-modify"
              class="btn btn-outline-success mb-3 ms-1"
              @click="$router.push({name: 'hotplacemodify', params: { no: article.articleNo }})"
            >
              글수정
            </button>
            <button
              type="button"
              id="btn-delete"
              class="btn btn-outline-danger mb-3 ms-1"
              v-on:click="deleteArticle"
            >
              글삭제
            </button>
            <!-- </c:if>
            </c:if> -->
          </div>
        </div>
      </div>
    </div>
</template>

<script>
import axios from "axios";

export default {
  name: "HotplaceDetail",
  components: {},
  data() {
    return {
      article: {}
    };
  },
 methods: {
    // checkNo: function(){
    //   no = CheckNo.data.no;
    // },
    deleteArticle: function(){
      axios.delete(`http://localhost:8080/enjoytrip/hotplacearticlerest/hotplace/${this.$route.params.no}`)
      .then((res) => {this.article = res.data})
      .then(this.$router.push({name:'hotplace', query: {pgno:'1', key:'', word:''}}))
      .then(window.location.reload());
    }
  },
  created() {
    const url = `http://localhost:8080/enjoytrip/hotplacearticlerest/hotplace/${this.$route.params.no}`;
    axios.get(url).then((res) => {
      console.log(res)
      this.article = res.data.article;
    });
  },
};
</script>

<style scoped></style>
