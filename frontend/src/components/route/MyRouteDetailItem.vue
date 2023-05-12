<template>
  <div class="col">
    <div class="card m-2" style="width: 18rem">
      <img :src="attr.firstImage" class="card-img-top" />
      <div class="card-body">
        <h5 class="card-title">{{attr.title}}</h5>
        <p class="card-text">{{attr.addr1}}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "MyRouteDetailItem",
  props: {
    attr: Object,
  }
};
</script>