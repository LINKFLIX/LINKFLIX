<template>
  <SlideTemplate>
    <template v-slot:subtitle>Easy to use</template>
    <template v-slot:description>
      <div>
        <div class="mb-3">
          <span>LINKFLIX를 설치하면 넷플릭스 비디오 UI에 </span>
          <span
            class="d-inline-flex border border-1 rounded p-1 me-1"
            style="width: 2rem"
          >
            <CartIcon></CartIcon>
          </span>
          <span>버튼이 생깁니다. </span>
        </div>
        <div>
          <span
            class="d-inline-flex border border-1 rounded p-1 me-1"
            style="width: 2rem"
          >
            <CartIcon></CartIcon>
          </span>
          <span
            >을 누르면 영상 속 제품을 <b>쉽고 편하게</b> 찾을 수 있습니다.</span
          >
        </div>
      </div>
    </template>
    <template v-slot:image-container>
      <swiper
        :centeredSlides="true"
        :loop="true"
        :autoplay="{
          delay: 2500,
        }"
      >
        <swiper-slide>
          <img src="../img/ep1_0.png" />
        </swiper-slide>
        <swiper-slide>
          <img src="../img/ep1_1.png" />
        </swiper-slide>
        <swiper-slide>
          <img src="../img/ep1_2.png" />
        </swiper-slide>
      </swiper>
    </template>
  </SlideTemplate>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import { Swiper, SwiperSlide } from 'swiper/vue';
import SlideTemplate from './SlideTemplate.vue';
import CartIcon from './CartIcon.vue';

export default defineComponent({
  components: {
    SlideTemplate,
    Swiper,
    SwiperSlide,
    CartIcon,
  },
});
</script>

<style scoped>
.swiper-slide img {
  width: 100%;
  height: 100%;
}
</style>
