<template>
  <Slide />
</template>

<script lang="ts">
import { defineComponent } from 'vue';

import Slide from './components/SlidingPage.vue';

export default defineComponent({
  name: 'App',
  components: {
    Slide,
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
