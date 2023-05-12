<template>
  <div class="sb-nav-fixed">
    <div class="mt-5 pt-5">
      <div class="container px-4">
        <h1 class="mt-4 d-flex justify-content-center">핫플 자랑하기</h1>
        <div
          class="container rounded bg-success bg-opacity-75 text-white text-center fs-2 p-4"
        >
          글수정
        </div>
        <div class="container">
            <div class="pt-4 pb-4">
                제목
                <input
                  type="text"
                  class="form-control"
                  id="title"
                  name="title"
                  ref="title"
                  v-model="article.title"
                />
              </div>
              <div class="pb-4">
                내용
                <textarea
                  class="form-control"
                  id="content"
                  name="content"
                  rows="3"
                  ref="content"
                  v-model="article.content"
                ></textarea>
              </div>
            <div class=" col-md-1 text-nowrap">
              <a class="btn btn-primary" id="btn-modify" @click="checkValue">
                <!-- <i class="fas fa-table me-1"></i> -->
                <i class="fas fa-edit"></i> 글 수정
              </a>
            </div>
            <div class=" col-md-1 ms-2 text-nowrap">
              <a class="btn btn-danger" href="" @click="$router.push({name:'hotplace', query: {pgno:'1', key:'', word:''}})">
                <!-- <i class="fas fa-table me-1"></i> -->
                <i class="fas fa-edit"></i> 목록
              </a>
            </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
    name: "HotplaceModify",
    components: {},
    data() {
        return {
            article: {
            }
        };
    },
    methods: {
    checkValue(){
        let err = true;
        let msg = "";
        err && !this.article.title && ((msg = "제목 입력해주세요"), (err = false), this.$refs.title.focus());
        err && !this.article.content && ((msg = "내용 입력해주세요"), (err = false), this.$refs.content.focus());
        if(!err) alert(msg);
        else {
            console.log(this.article)
            this.registArticle();
        }
    },
    registArticle() {
      // 비동기
      console.log(this.article);
      const url = `http://localhost:8080/enjoytrip/hotplacearticlerest/hotplace`;
      axios.put(url, {
        articleNo: this.$route.params.no,
        userId: this.article.userId,
        title: this.article.title,
        content: this.article.content,
        //페이지, 사용자
      }).then(response => this.data = response.data)
      this.$router.push({name:'hotplace', query: {pgno:'1', key:'', word:''}});
      window.location.reload();
    },
  },
    created() {
        const url = `http://localhost:8080/enjoytrip/hotplacearticlerest/hotplace/${this.$route.params.no}`;
        axios.get(url).then((res) => {
        this.article = res.data.article;
        console.log(res)
    });
  },
};
</script>

<style scoped></style>