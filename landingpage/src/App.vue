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
html,
body {
  position: relative;
  height: 100%;
  width: 100%;
  background-color: #3c3e42;
}

#app {
  height: 100%;
  width: 100%;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
