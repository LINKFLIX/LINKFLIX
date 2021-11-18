<template>
  <div class="w-100" style="padding: 140px 120px; height: 100vh">
    <div class="d-flex h-100 overflow-auto align-items-center">
      <div>
        <div class="display-1 mb-5">
          넷플릭스를 보다가 영상 속 제품에 대해서 궁금한 적 없으신가요?
        </div>
        <div class="display-1">
          <span class="d-inline-block">
            <img :src="imgsrc" alt="linkflix" style="width: 350px" />
          </span>
          가 알려드립니다!
        </div>
        <div class="text-center" style="margin-top: 5rem">
          <button
            type="button"
            class="btn btn-primary download-btn py-3 px-5 text-white"
            v-on:click="moveTo"
          >
            <span class="h1">DOWNLOAD</span>
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
export default {
  name: 'slideFisrt',
  data() {
    return {
      imgsrc: require('../assets/logo.png'),
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
};
</script>

<style scoped></style>
