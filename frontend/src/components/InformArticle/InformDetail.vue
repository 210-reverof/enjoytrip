<template>
    <div class="sb-nav-fixed">
      <div class="mt-5 pt-5">
        <div class="container px-4">
          <h1 class="mt-4 d-flex justify-content-center">공지사항</h1>

          <div
            class="container rounded bg-secondary bg-opacity-25 text-secondary fs-2 p-4 mb-2"
          >
            {{ article.title }}

            <div class="row mt-2">
              <div class="col-1">
                <img
                  src="${root}/res/img/junimg04.png"
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
                @click="
                  $router.push({
                    name: 'inform',
                    query: { pgno: '1', key: '', word: '' },
                  })
                "
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
              @click="
                $router.push({
                  name: 'modify',
                  params: { no: article.articleno },
                })
              "
            >
              글수정
            </button>
            <button
              type="button"
              id="btn-delete"
              class="btn btn-outline-danger mb-3 ms-1"
              @click="
                $router.push({
                  name: 'delete',
                  params: { no: article.articleno },
                })
              "
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
export default {
  name: "InformDetail",
  components: {},
  data() {
    return {
      article: Object,
    };
  },
  created() {
    const url = `http://localhost:8080/enjoytrip/informarticlerest/inform?pgno=${this.$route.query.pgno}&key=${this.$route.query.key}&word=${this.$route.query.word}`;
    axios.get(url).then((res) => {
      // console.log(res)
      this.informarticles = res.data.articles;
      // console.log(this.informarticles);
    });
  },
  methods: {},
};
</script>

<style scoped></style>
