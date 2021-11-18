<template>
  <div class="w-100" style="padding: 140px 120px; height: 100vh">
    <div class="d-flex h-100 overflow-auto align-items-center">
      <YouTube
        src="https://www.youtube.com/watch?v=gUyCa6errBc"
        @ready="onReady"
        ref="youtube"
        width="800"
        height="500"
      />
      <div>
        <div class="display-1" style="margin-left: 40%">
          <span class="d-inline-block">
            <img :src="imgsrc" alt="linkflix" style="width: 600px" />
          </span>
        </div>
        <div class="text-center" style="margin-top: 5rem; margin-left: 60%">
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
import { defineComponent } from 'vue';
import YouTube from 'vue3-youtube';
export default defineComponent({
  name: 'slideFisrt',
  components: { YouTube },
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
});
</script>

<style scoped></style>
