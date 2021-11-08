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
}

#app {
  height: 100%;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
  padding-bottom: 50px;
}

#quite-neat-divider {
  border-top: 3px dashed green;
  margin: 60px 60px 50px;
}
</style>
