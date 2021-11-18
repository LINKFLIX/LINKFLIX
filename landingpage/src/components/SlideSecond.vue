<template>
  <div class="container">
    <div class="row">
      <div class="col-4" style="text-align: left">
        <div style="font-weight: 900; font-size: 90px; margin-bottom: 100px">
          <p>MENUAL</p>
        </div>
        <div style="font-size: 30px; font-weight: 600">
          <p style="margin-bottom: 35px">버튼만 누르면</p>
          <p style="margin-bottom: 35px">영상 속 제품을 쉽고 편하게</p>
          <p style="margin-bottom: 36px">구매하실 수 있습니다</p>
        </div>
      </div>
      <div class="col-8">
        <swiper
          :spaceBetween="30"
          :centeredSlides="true"
          :navigation="false"
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
      </div>
    </div>

  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import { Swiper, SwiperSlide } from 'swiper/vue';
import 'swiper/swiper-bundle.min.css';
import 'swiper/swiper.min.css';
import 'swiper/components/pagination/pagination.min.css';
import SwiperCore, { Autoplay, Pagination } from 'swiper/core';

SwiperCore.use([Autoplay, Pagination]);
export default defineComponent({
  name: 'slideSecond',
  components: {
    Swiper,
    SwiperSlide,
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
.title {
  list-style: none;
  padding-left: 0px;
  font-size: 20px;
  font-weight: 700;
}
.eplist {
  list-style: none;
  padding-left: 0px;
  font-size: 15px;
  font-weight: 500;
}
li {
  float: left;
}
.panel {
  list-style: none;
}
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
