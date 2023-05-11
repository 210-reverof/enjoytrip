<template>
    <div class="modal" :class="{'is-active': visible}">
      <div class="modal-background"></div>
      <div class="modal-card">
        <header class="modal-card-head">
          <p class="modal-card-title">로그인</p>
          <button class="delete" aria-label="close" @click="$emit('close')"></button>
        </header>
        <section class="modal-card-body">
          <div class="field">
            <label class="label">ID</label>
            <div class="control">
              <input class="input" type="text" placeholder="아이디를 입력하세요">
            </div>
          </div>
          <div class="field">
            <label class="label">비밀번호</label>
            <div class="control">
              <input class="input" type="password" placeholder="비밀번호를 입력하세요">
            </div>
          </div>
        </section>
        <footer class="modal-card-foot">
          <button class="button is-success">로그인</button>
          <button class="button" @click="$emit('close')">취소</button>
        </footer>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: "LoginModal",
    props: {
        visible: {
            type: Boolean,
            required: true
        }
    },
    created() {
        console.log(this.visible);
    }
  };
  </script>