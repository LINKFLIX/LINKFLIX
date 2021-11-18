<template>
  <SlideTemplate>
    <template v-slot:subtitle> LINKFLIX? </template>
    <template v-slot:description>
      <div>
        넷플릭스에서 현재 시청 중인 영상의 제품을 바로 확인할 수 있는 크롬 확장
        프로그램
      </div>
      <div>Link + Netflix의 합성어로 넷플릭스와 연결된 서비스임을 의미</div>
    </template>

    <template v-slot:image-container>
      <swiper
        :spaceBetween="20"
        :centeredSlides="true"
        :slidesPerView="3"
        :loop="true"
      >
        <swiper-slide>
          <img
            src="https://w.namu.la/s/4acb2ead656c5ff7bf12a414dd0b719e2c707612a740a2aa5872565a3cd09b610a39dfeae15c06706b81098ec44bc393dfcbafe903c7404eb6280de2641ec5496d55620c3f0005eef3e76de56e162b622350456c211454ea9d223fa3f038477983caa3dbd048700677cc9e475eaa5350"
            alt="갯마을차차차"
            style="width: 80%; margin-left: 30%; margin-right: 30%"
          />
        </swiper-slide>
        <swiper-slide>
          <img
            src="https://w.namu.la/s/c8497e89ea0df1a739a5d81b172ff083df2cb94bf0470154ea9f6963a24234f13d949a6fa1c6f80c6e42094bb1d5515b56fd93b10f95077968796cad878c8e859a6c16e37ce29a68c7656f151e3ce95e41ec4d8e408eb8d7074790750e295a7987d89ec23fb80ed039a83da2daf54a6c"
            alt="오징어게임"
            style="width: 80%; margin-left: 30%; margin-right: 30%"
          />
        </swiper-slide>
        <swiper-slide>
          <img
            src="https://w.namu.la/s/00ea3302678c6d6e2fdd3fdb07bf5f9374776d97c28ac711f51a350a3cc95ecc2ab01f158369088c9d8f78d334c5883d9ac4421fae058ab882c49ed8d8cf0709f8f8307ab1f21fc05a13ddc25130913fc4ba183ff4a991b0c38b3a4751bd8c11"
            alt="킹덤"
            style="width: 80%; margin-left: 30%; margin-right: 30%"
          />
        </swiper-slide>
        <swiper-slide>
          <img
            src="https://w.namu.la/s/be4b5f93d882f07eed700cfbbff75cf0cf8838041770891f0da80afe53c700b39579a3e7357c0accf4455a7afa4fd7e8860ddb2db229f0df2375078cdea5a702cc3e732b8abae324284fc7211d0e4dc72827df20c5fbb38c629218ec2c39615543a692e1d73e185bbdb614809701eb96"
            alt="기생충"
            style="width: 80%; margin-left: 30%; margin-right: 30%"
          />
        </swiper-slide>
      </swiper>
    </template>
  </SlideTemplate>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

import { Swiper, SwiperSlide } from 'swiper/vue';
import 'swiper/swiper-bundle.min.css';
import 'swiper/swiper.min.css';
import 'swiper/components/pagination/pagination.min.css';
import 'swiper/components/navigation/navigation.min.css';
import SwiperCore, { Autoplay, Pagination, Navigation } from 'swiper/core';
import SlideTemplate from './SlideTemplate.vue';

SwiperCore.use([Autoplay, Pagination, Navigation]);
export default defineComponent({
  components: { SlideTemplate, Swiper, SwiperSlide },
});
</script>

<style scoped>
.swiper-slide {
  overflow: visible;
}

.swiper-slide-active {
  transform: scale(1.2);
}
</style>
