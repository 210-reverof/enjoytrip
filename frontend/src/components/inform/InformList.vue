<template>
  <div>
    <div class="row justify-content-center">
      <div class="col-lg-8 col-md-10 col-sm-12">
        <h2 class="my-3 py-3 shadow-sm bg-light text-center">
          <mark class="sky">공 지 사 항</mark>
        </h2>
      </div>
      <div class="col-lg-8 col-md-10 col-sm-12">
        <div class="row align-self-center mb-2">
          <div class="col-md-2 text-start">
            <!-- makinglist로 이동하는 버튼 -->
            <!-- <c:if test="${not empty userinfo}">
              <button
                type="button"
                id="btn-mv-register"
                class="btn btn-outline-primary btn-sm"
              >
                글쓰기
              </button>
            </c:if> -->
            <button
              type="button"
              id="btn-mv-register"
              class="btn btn-outline-primary btn-sm"
              @click="$router.push({name:'informwrite'})"
            >
              글쓰기
            </button>
            <!-- <button type="button" id="btn-mv-register" class="btn btn-outline-primary btn-sm">글쓰기 </button> -->
          </div>
          <div class="col-md-7 offset-3">
              <!-- 검색창 -->
            <!-- <form class="d-flex" id="form-search" action="">
              <select
                name="key"
                id="key"
                class="form-select form-select-sm ms-5 me-1 w-50"
                aria-label="검색조건"
              >
                <option selected>검색조건</option>
                <option value="title">제목</option>
                <option value="user_id">작성자</option>
              </select>
              <div class="input-group input-group-sm">
                <input
                  type="text"
                  name="word"
                  id="word"
                  class="form-control"
                  placeholder="검색어..."
                />
                <button id="btn-search" class="btn btn-dark" type="button">
                  검색
                </button>
              </div>
            </form> -->
          </div>
        </div>
        <div v-if="informarticles.length">
          <table class="table table-hover">
            <thead>
              <tr class="text-center">
                <th scope="col">글번호</th>
                <th scope="col">제목</th>
                <th scope="col">작성자</th>
                <th scope="col">조회수</th>
                <th scope="col">작성일</th>
              </tr>
            </thead>
            <tbody v-for="(article, i) in informarticles" :key="i">
              <tr class="text-center">
                <th scope="row">{{ article.articleNo }}</th>
                <td class="text-start">
                  <a
                    href="#"
                    class="article-title link-dark"
                    style="text-decoration: none"
                    @click="$router.push({name: 'informdetail', params: {no: article.articleNo}})"
                  >
                    {{ article.title }}
                  </a>
                </td>
                <td>{{ article.userId }}</td>
                <td>{{ article.hit }}</td>
                <td>{{ article.createdAt }}</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
      <!-- <div class="row">${navigation.navigator}</div> -->
    </div>
  </div>
  <!-- 다른 값들 넘길때 페이지번호, 검색어 등 같이 넘기기 -->
  <!-- <form id="form-param" method="get" action="">
      <input type="hidden" name="pgno" id="pgno" value="${pgno}">
      <input type="hidden" name="key" value="${key}">
      <input type="hidden" name="word" value="${word}">
    </form>
    <form id="form-no-param" method="get" action="${root}/informarticle/view">
      <input type="hidden" name="pgno" value="${pgno}">
      <input type="hidden" name="key" value="${key}">
      <input type="hidden" name="word" value="${word}">
      <input type="hidden" id="articleno" name="articleno" value="">
    </form> -->
</template>

<script>
import axios from "axios";

export default {
  name: "InformList",
  components: {},
  data() {
    return {
      informarticles: [],
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
};
</script>

<style></style>
