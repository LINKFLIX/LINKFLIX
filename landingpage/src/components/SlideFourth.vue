<template>
  <div class="w-100" style="padding: 140px 120px; height: 100vh">
    <div class="d-flex h-100 overflow-auto align-items-center">
      <div class="col-4 text-center">
        <div class="display-5">Available Contents</div>
      </div>
      <div class="col-8 text-center h-100" id="slide-fourth-swiper">
        <swiper
          class="h-100"
          :spaceBetween="30"
          :loop="true"
          :autoplay="{ delay: 2500 }"
        >
          <swiper-slide class="h-100">
            <div class="d-flex w-100 h-100">
              <div class="col m-3">
                <img
                  class="h-100 shadow"
                  src="https://file.mk.co.kr/meet/neds/2021/08/image_readtop_2021_774018_16285690364746521.jpg"
                  style="object-fit: contain"
                />
              </div>
              <div
                class="
                  col
                  d-flex
                  flex-column
                  align-items-center
                  justify-content-center
                  fs-4
                "
              >
                <div>갯마을 차차차</div>
                <div>Ep.01</div>
                <div>Ep.02</div>
                <div>Ep.03</div>
              </div>
            </div>
          </swiper-slide>
          <swiper-slide class="h-100">
            <div class="d-flex w-100 h-100">
              <div class="col m-3">
                <img
                  class="h-100 shadow"
                  src="http://t1.daumcdn.net/movie/cab3b02a7b274bd6838b80a5e481fedf1559021787090"
                  style="object-fit: contain"
                />
              </div>
              <div
                class="
                  col
                  d-flex
                  flex-column
                  align-items-center
                  justify-content-center
                  fs-3
                "
              >
                <div>기생충</div>
              </div>
            </div>
          </swiper-slide>
        </swiper>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import { Swiper, SwiperSlide } from 'swiper/vue';

export default defineComponent({
  components: {
    Swiper,
    SwiperSlide,
  },
});
</script>
