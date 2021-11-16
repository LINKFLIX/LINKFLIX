<template>
  <div class="content">
    <img
      :src="imgsrc"
      alt="linkflix"
      style="width: 50%"
      class="linkflix-logo"
    />
    <h1>넷플릭스를 보다가 영상 속 제품에 대해서 궁금한 적 없으신가요?</h1>
    <h2>
      <p style="color: blue; display: inline">LINK</p>
      <p style="color: red; display: inline">FLIX</p>
      가 알려드립니다!
    </h2>
    <button v-on:click="moveTo">설치하러가기</button>
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
  display: block;
  margin-top: 10%;
  margin-left: auto;
  margin-right: auto;
}
.content {
  position: relative;
  height: 100%;
  width: 100%;
  background-color: #3c3e42;
  /* background: linear-gradient(-45deg, #94969c, #3c3e42, #000000); */
  background-size: 400% 400%;
  animation: gradient 15s ease infinite;
  vertical-align: middle;
}

@keyframes gradient {
  0% {
    background-position: 0% 50%;
  }
  50% {
    background-position: 100% 50%;
  }
  100% {
    background-position: 0% 50%;
  }
}

@font-face {
  font-family: 'SBAggroB';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2108@1.1/SBAggroB.woff')
    format('woff');
  font-weight: normal;
  font-style: normal;
}
h1 {
  font-family: 'SBAggroB';
  font-size: 50px;
  color: white;
}

h2 {
  font-family: 'SBAggroB';
  font-size: 50px;
  color: white;
}
button {
  font-family: 'SBAggroB';
  font-size: 30px;
  background-color: #19b5e0;
  color: white;
  cursor: pointer;
}
</style>
