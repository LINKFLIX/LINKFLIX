<template>
  <div class="w-100" style="padding: 140px 120px; height: 100vh">
    <div class="d-flex h-100 overflow-auto align-items-center">
      <div class="col ratio ratio-16x9">
        <iframe
          src="https://www.youtube.com/embed/mDbXRICn3Hw?rel=0"
          title="YouTube video"
          allowfullscreen
        ></iframe>
      </div>
      <div class="col ms-5">
        <div class="w-100 text-center">
          <img :src="imgsrc" alt="linkflix" class="w-75" />
        </div>
        <div class="text-center mt-5">
          <button
            type="button"
            class="btn btn-primary py-3 px-5 text-white"
            v-on:click="moveTo"
          >
            <span class="h4">DOWNLOAD</span>
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
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
});
</script>

<style scoped></style>
