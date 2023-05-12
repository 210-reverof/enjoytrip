<template>
  <div class="sb-nav-fixed">
    <div class="mt-5 pt-5">
      <div class="container px-4">
        <h1 class="mt-4 d-flex justify-content-center">핫플 자랑하기</h1>
        <div
          class="container rounded bg-success bg-opacity-75 text-white text-center fs-2 p-4"
        >
          글작성
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
                  placeholder="제목을 입력하세요."
                  v-model="title"
                />
              </div>
              <div class="pb-4">
                내용
                <textarea
                  class="form-control"
                  id="content"
                  name="content"
                  rows="3"
                  placeholder="내용을 입력하세요."
                  ref="content"
                  v-model="content"
                ></textarea>
              </div>
            <div class=" col-md-1 text-nowrap">
              <a class="btn btn-primary" id="btn-register" @click="checkValue">
                <!-- <i class="fas fa-table me-1"></i> -->
                <i class="fas fa-edit"></i> 글 작성
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
  name: "HotplaceWrite",
  components: {},
  data() {
    return {
        userId:"1234",
        title:"",
        content:"",
    };
  },
  created() {},
  methods: {
    checkValue(){
        let err = true;
        let msg = "";
        err && !this.title && ((msg = "제목 입력해주세요"), (err = false), this.$refs.title.focus());
        err && !this.content && ((msg = "내용 입력해주세요"), (err = false), this.$refs.content.focus());
        if(!err) alert(msg);
        else this.registArticle();
    },
    registArticle() {
      // 비동기
      const url = `http://localhost:8080/enjoytrip/hotplacearticlerest/hotplace`;
      axios.post(url, {
        userId: this.userId,
        title: this.title,
        content: this.content,
        //페이지, 사용자
      }).then(response => this.data = response.data)
      console.log("글작성 하러가자!!!!");
      this.$router.push({name:'hotplace', query: {pgno:'1', key:'', word:''}});
      window.location.reload();
    },
  },
};
</script>

<style scoped></style>