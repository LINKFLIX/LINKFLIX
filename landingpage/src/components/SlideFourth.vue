<template>
  <div class="w-100" style="padding: 140px 120px; height: 100vh">
    <div class="d-flex h-100 overflow-auto align-items-center">
      <div class="col-4 text-center">
        <div class="display-5">Available Contents</div>

        <button
          type="button"
          class="btn btn-primary text-white mt-5 py-2 px-4 fs-5"
          v-on:click="moveTo"
        >
          DOWNLOAD
        </button>
      </div>
      <div class="col-8 text-center h-100" id="slide-fourth-swiper">
        <swiper
          class="h-100"
          :spaceBetween="30"
          :loop="true"
          :autoplay="{ delay: 2500 }"
          :speed="725"
        >
          <swiper-slide class="h-100">
            <div class="d-flex w-100 h-100">
              <div class="col m-3">
                <img
                  class="h-100 shadow"
                  :src="chachachaImage"
                  style="object-fit: contain"
                  alt="기생충"
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
                <div class="fs-5">Ep.01</div>
                <div class="fs-5">Ep.02</div>
                <div class="fs-5">Ep.03</div>
              </div>
            </div>
          </swiper-slide>
          <swiper-slide class="h-100">
            <div class="d-flex w-100 h-100">
              <div class="col m-3">
                <img
                  class="h-100 shadow"
                  :src="parasiteImage"
                  style="object-fit: contain"
                  alt="갯마을 차차차"
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
  data() {
    return {
      chachachaImage: require('../assets/cha-cha-cha.jpeg'),
      parasiteImage: require('../assets/parasite.png'),
    };
  },
  methods: {
    moveTo: function () {
      window.open(
        'https://chrome.google.com/webstore/detail/linkflix/oipofophdaejmlneoheopbmmobmjmlkf?hl=ko',
        '_blank'
      );
    },
  },
});
</script>
