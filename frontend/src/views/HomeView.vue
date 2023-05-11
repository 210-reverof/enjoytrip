<template>
  <div class="home">
    <div class="container text-center">
      <carousel-img></carousel-img>
      <our-area-img></our-area-img>
      <hr/>
      <hot-place-img></hot-place-img>
    </div>  
  </div>
</template>

<script>
import CarouselImg from '@/components/home/CarouselImg.vue';
import OurAreaImg from '@/components/home/OurAreaImg.vue';
import HotPlaceImg from '@/components/home/HotPlaceImg.vue';

export default {
  name: 'HomeView',
  components: {
    CarouselImg,
    OurAreaImg,
    HotPlaceImg
  }
}
</script>
