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
            <c:if test="${not empty userinfo}">
              <!-- makinglist로 이동하는 버튼 -->
              <button
                type="button"
                id="btn-mv-register"
                class="btn btn-outline-primary btn-sm"
              >
                글쓰기
              </button>
            </c:if>
            <!-- <button type="button" id="btn-mv-register" class="btn btn-outline-primary btn-sm">
                	글쓰기
              </button> -->
          </div>
          <div class="col-md-7 offset-3">
            <form class="d-flex" id="form-search" action="">
              <input type="hidden" name="action" value="list" />
              <input type="hidden" name="pgno" value="1" />
              <!-- 검색창 -->
              <select
                name="key"
                id="key"
                class="form-select form-select-sm ms-5 me-1 w-50"
                aria-label="검색조건"
              >
                <option selected>검색조건</option>
                <!-- <option value="article_no">글번호</option> -->
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
            </form>
          </div>
        </div>
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
          <tbody>
            <!-- articleItem 따로 만들어서 호출 -->
            <c:forEach var="article" items="${articles}">
              <tr class="text-center">
                <th scope="row">${article.articleNo}</th>
                <td class="text-start">
                  <a
                    href="#"
                    class="article-title link-dark"
                    data-no="${article.articleNo}"
                    style="text-decoration: none"
                  >
                    ${article.title}
                  </a>
                </td>
                <td>${article.userId}</td>
                <td>${article.hit}</td>
                <td>${article.createdAt}</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      <div class="row">${navigation.navigator}</div>
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
import InformArticleListItem from "./InformArticleListItem.vue";
import axios from "axios";
export default {
  name: "InformArticleList",
  components: {
    InformArticleListItem,
  },

  created() {
    
    axios
      .get(
        "http://localhost:8080/enjoytrip/informarticlerest/inform?pgno=1&key&word"
      )
      .then((res) => {
        this.articles = res.data;
      });
  },
};
</script>

<style></style>
