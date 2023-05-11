<template>
  <tr>
    <!-- <router-link :to="'/board/detail/' + i">{{i}}번 게시글</router-link> -->
    <!-- <a :href="'#' + i" @click="$router.push({name: 'boardview', params: {no: i}})">{{i}}번 게시글</a> -->
    <td><a href="#" @click="$router.push({name: 'boardview', params: {no: article.articleno}})">{{article.articleno}}</a></td>
    <td>{{article.subject}}</td>
    <td>{{article.userid}}</td>
    <td>{{article.hit}}</td>
    <td>{{article.regtime}}</td>
  </tr>
</template>

<script>
export default {
  name: "InformArticleListItem",
  props:{
    article: Object
  }
};
</script>

<style></style>