<template>
  <SlideTemplate>
    <template v-slot:subtitle>Beta</template>
    <template v-slot:description>
      <div>현재 LINKFLIX는 일부 영상에 한해서 이용 가능합니다.</div>
    </template>
    <template v-slot:image-container>
      <div class="h-100 d-flex justify-content-center align-items-center">
        <div class="row justify-content-center gap-3 m-0">
          <div class="col-5 p-0">
            <img
              class="w-100 mb-2"
              :src="`https://file.mk.co.kr/meet/neds/2021/08/image_readtop_2021_774018_16285690364746521.jpg`"
              style="object-fit: contain"
            />
            <div class="text-center">갯마을 차차차 1 ~ 3 화</div>
          </div>
          <div class="col-5 p-0">
            <img
              class="w-100 mb-2 ml-1"
              :src="`https://upload.wikimedia.org/wikipedia/ko/6/60/%EA%B8%B0%EC%83%9D%EC%B6%A9_%ED%8F%AC%EC%8A%A4%ED%84%B0.jpg`"
              style="border: solid 1px lightgrey; object-fit: contain"
            />
            <div class="text-center">기생충</div>
          </div>
        </div>
      </div>
    </template>
  </SlideTemplate>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import SlideTemplate from './SlideTemplate.vue';

export default defineComponent({
  components: { SlideTemplate },
});
</script>
