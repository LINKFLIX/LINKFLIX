<template>
  <swiper
    :spaceBetween="30"
    :centeredSlides="true"
    :pagination="{
      clickable: true,
    }"
    :navigation="true"
  >
    <swiper-slide>
      <SlideFirst />
    </swiper-slide>
    <swiper-slide>
      <SlideSecond />
    </swiper-slide>
    <swiper-slide>
      <SlideThird />
    </swiper-slide>
    <swiper-slide>
      <SlideFourth />
    </swiper-slide>
  </swiper>
</template>

<script lang="ts">
import SlideFirst from './SlideFirst.vue';
import SlideSecond from './SlideSecond.vue';
import SlideThird from './SlideThird.vue';
import SlideFourth from './SlideFourth.vue';
import { defineComponent } from 'vue';
import { Swiper, SwiperSlide } from 'swiper/vue';
import 'swiper/swiper-bundle.min.css';
import 'swiper/swiper.min.css';
import 'swiper/components/pagination/pagination.min.css';
import 'swiper/components/navigation/navigation.min.css';
import SwiperCore, { Autoplay, Pagination, Navigation } from 'swiper/core';

SwiperCore.use([Autoplay, Pagination, Navigation]);

export default defineComponent({
  name: 'HelloWorld',
  components: {
    Swiper,
    SwiperSlide,
    SlideFirst,
    SlideSecond,
    SlideThird,
    SlideFourth,
  },
  methods: {
    onSwiper(swiper: any) {
      console.log(swiper);
    },
    onSlideChange() {
      console.log('slide change');
    },
  },
});
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.swiper-container {
  width: 100%;
  height: 100%;
}

.swiper-slide {
  text-align: center;
  font-size: 18px;
  background: #fff;
  display: flex;
  justify-content: center;
  align-items: center;
}

.swiper-slide img {
  display: block;
  width: 100%;
  height: 100%;
  object-fit: cover;
}
</style>
