<template>
  <div class="home">
    <div class="container text-center">
      <carousel-img></carousel-img>
      <our-area-img></our-area-img>
    </div>  
  </div>
</template>

<script>
import CarouselImg from '@/components/home/CarouselImg.vue';
import OurAreaImg from '@/components/home/OurAreaImg.vue';
export default {
  name: 'HomeView',
  components: {
    CarouselImg,
    OurAreaImg
  }
}
</script>
