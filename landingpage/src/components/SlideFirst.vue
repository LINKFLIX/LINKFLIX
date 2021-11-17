<template>
  <div class="content">
    <h1>넷플릭스를 보다가 영상 속 제품에 대해서 궁금한 적 없으신가요?</h1>
    <h2>
      <img
        :src="imgsrc"
        alt="linkflix"
        style="width: 350px"
        class="linkflix-logo"
      />
      가 알려드립니다!
    </h2>
    <button type="button" class="btn btn-info" v-on:click="moveTo">
      Download
    </button>
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

<style scoped>
.linkflix-logo {
  display: inline;
  margin-left: auto;
  margin-right: auto;
}
.content {
  position: relative;
  height: 100%;
  width: 100%;
  margin-left: 5%;
  /* background: linear-gradient(-45deg, #94969c, #3c3e42, #000000); */
  background-size: 400% 400%;
  animation: gradient 15s ease infinite;
  vertical-align: middle;
}

h1 {
  margin-top: 10%;
  font-size: 120px;
}

h2 {
  font-size: 120px;
}
button {
  margin-top: 5%;
  margin-left: 35%;
  font-size: 80px;
  background-color: #19b5e0;
  color: white;
  cursor: pointer;
}
</style>
