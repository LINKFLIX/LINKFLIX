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
          <img
            src="https://w.namu.la/s/4acb2ead656c5ff7bf12a414dd0b719e2c707612a740a2aa5872565a3cd09b610a39dfeae15c06706b81098ec44bc393dfcbafe903c7404eb6280de2641ec5496d55620c3f0005eef3e76de56e162b622350456c211454ea9d223fa3f038477983caa3dbd048700677cc9e475eaa5350"
            alt="갯마을차차차"
            style="width: 100%"
          />
        </swiper-slide>
        <swiper-slide>
          <img
            src="https://w.namu.la/s/c8497e89ea0df1a739a5d81b172ff083df2cb94bf0470154ea9f6963a24234f13d949a6fa1c6f80c6e42094bb1d5515b56fd93b10f95077968796cad878c8e859a6c16e37ce29a68c7656f151e3ce95e41ec4d8e408eb8d7074790750e295a7987d89ec23fb80ed039a83da2daf54a6c"
            alt="오징어게임"
            style="width: 100%; margin-left: 10px"
          />
        </swiper-slide>
        <swiper-slide>
          <img
            src="https://w.namu.la/s/be4b5f93d882f07eed700cfbbff75cf0cf8838041770891f0da80afe53c700b39579a3e7357c0accf4455a7afa4fd7e8860ddb2db229f0df2375078cdea5a702cc3e732b8abae324284fc7211d0e4dc72827df20c5fbb38c629218ec2c39615543a692e1d73e185bbdb614809701eb96"
            alt="갯마을차차차"
            style="width: 100%"
          />
        </swiper-slide>
        <swiper-slide>
          <img
            src="https://w.namu.la/s/a6b9ccdba583ad1881261283462efb5f40ce4be81668d6e13517856f1e90dbbd7340bb6d03a0ea6576732acf2284094e8ebfd0d136abfa107f8f6fc577d979f1ba7cbf1f790396275effdb94b4a0527f3c855ff14ebe37913802a313b13a50dfa4f2b14552e60664c994c963dbefcca4"
            alt="스위트홈"
            style="width: 100%; margin-left: 10px"
          />
        </swiper-slide>
      </swiper>
    </template>
  </SlideTemplate>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import SlideTemplate from './SlideTemplate.vue';
import { Swiper, SwiperSlide } from 'swiper/vue';
import 'swiper/swiper-bundle.min.css';
import 'swiper/swiper.min.css';
import 'swiper/components/pagination/pagination.min.css';
import SwiperCore, { EffectCoverflow, Autoplay } from 'swiper/core';
SwiperCore.use([EffectCoverflow, Autoplay]);
export default defineComponent({
  components: { SlideTemplate, Swiper, SwiperSlide },
});
</script>
