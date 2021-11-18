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
      <img
        src="https://w.namu.la/s/4acb2ead656c5ff7bf12a414dd0b719e2c707612a740a2aa5872565a3cd09b610a39dfeae15c06706b81098ec44bc393dfcbafe903c7404eb6280de2641ec5496d55620c3f0005eef3e76de56e162b622350456c211454ea9d223fa3f038477983caa3dbd048700677cc9e475eaa5350"
        alt="갯마을차차차"
        style="width: 24%"
      />
      <img
        src="https://w.namu.la/s/00ea3302678c6d6e2fdd3fdb07bf5f9374776d97c28ac711f51a350a3cc95ecc2ab01f158369088c9d8f78d334c5883d9ac4421fae058ab882c49ed8d8cf0709f8f8307ab1f21fc05a13ddc25130913fc4ba183ff4a991b0c38b3a4751bd8c11"
        alt="킹덤"
        style="width: 23%; margin-left: 10px"
      />
      <img
        src="https://w.namu.la/s/c8497e89ea0df1a739a5d81b172ff083df2cb94bf0470154ea9f6963a24234f13d949a6fa1c6f80c6e42094bb1d5515b56fd93b10f95077968796cad878c8e859a6c16e37ce29a68c7656f151e3ce95e41ec4d8e408eb8d7074790750e295a7987d89ec23fb80ed039a83da2daf54a6c"
        alt="오징어게임"
        style="width: 23%; margin-left: 10px"
      />
      <img
        src="https://w.namu.la/s/a6b9ccdba583ad1881261283462efb5f40ce4be81668d6e13517856f1e90dbbd7340bb6d03a0ea6576732acf2284094e8ebfd0d136abfa107f8f6fc577d979f1ba7cbf1f790396275effdb94b4a0527f3c855ff14ebe37913802a313b13a50dfa4f2b14552e60664c994c963dbefcca4"
        alt="스위트홈"
        style="width: 23%; margin-left: 10px"
      />
    </template>
  </SlideTemplate>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import SlideTemplate from './SlideTemplate.vue';
import { Carousel, Pagination, Slide } from 'vue3-carousel';

export default defineComponent({
  components: { SlideTemplate },
});
</script>
