<template>
  <SlideTemplate>
    <template v-slot:subtitle>LINKFLIX?</template>
    <template v-slot:description>
      <div>
        LINK + NETFLIX의 합성어로, 넷플릭스 영상에 등장하는
        <b>제품과 당신을 연결</b>시켜주는 서비스입니다.
      </div>
    </template>
    <template v-slot:image-container>
      <swiper
        :effect="'coverflow'"
        :grabCursor="true"
        :centeredSlides="true"
        :slidesPerView="3"
        :loop="true"
        :coverflowEffect="{
          rotate: 50,
          stretch: 0,
          depth: 100,
          modifier: 1,
          slideShadows: true,
        }"
        :autoplay="{
          delay: 2500,
        }"
      >
        <swiper-slide>
          <img :src="chachachaImage" alt="갯마을차차차" class="w-100 shadow" />
        </swiper-slide>
        <swiper-slide>
          <img :src="squadGameImage" alt="오징어게임" class="w-100 shadow" />
        </swiper-slide>
        <swiper-slide>
          <img :src="sweetHomeImage" alt="스위트홈" class="w-100 shadow" />
        </swiper-slide>
        <swiper-slide>
          <img :src="parasiteImage" alt="기생충" class="w-100 shadow" />
        </swiper-slide>
      </swiper>
    </template>
  </SlideTemplate>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import SlideTemplate from './SlideTemplate.vue';
import { Swiper, SwiperSlide } from 'swiper/vue';
import SwiperCore, { EffectCoverflow, Autoplay } from 'swiper/core';
SwiperCore.use([EffectCoverflow, Autoplay]);

export default defineComponent({
  components: { SlideTemplate, Swiper, SwiperSlide },
  data() {
    return {
      chachachaImage: require('../assets/cha-cha-cha.jpeg'),
      parasiteImage: require('../assets/parasite.png'),
      squadGameImage: require('../assets/squad-game.jpeg'),
      sweetHomeImage: require('../assets/sweet-home.jpeg'),
    };
  },
});
</script>

<style scoped>
.SlideTemplate {
  margin-top: 15%;
}
</style>
