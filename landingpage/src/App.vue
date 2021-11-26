<template>
  <SlidingPage />
</template>

<script lang="ts">
import { defineComponent } from 'vue';

import SlidingPage from './components/SlidingPage.vue';

export default defineComponent({
  name: 'App',
  components: {
    SlidingPage,
  },
  setup() {},
});
</script>

<style>
body {
  position: relative;
  overflow: hidden;
  height: 100%;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
</style>
