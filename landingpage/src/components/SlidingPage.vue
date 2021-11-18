<template>
  <swiper
    :direction="'vertical'"
    :mousewheel="true"
    :autoHeight="true"
    :speed="600"
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
import SwiperCore, { Autoplay, Pagination, Mousewheel } from 'swiper/core';

SwiperCore.use([Autoplay, Pagination, Mousewheel]);

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

<style scoped>
.swiper {
  display: flex;
}
</style>
