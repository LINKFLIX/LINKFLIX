<template>
  <div class="content">
    <img
      :src="imgsrc"
      alt="linkflix"
      style="width: 50%"
      class="linkflix-logo"
    />
    <h1>
      익스텐션을 설치한 후 넷플릭스 영상 재생창에 생긴 카트모양을 클릭해주세요!
    </h1>
  </div>
</template>

<script lang="ts">
export default {
  name: 'slideSecond',
  data() {
    return {
      imgsrc: require('../assets/overlaybtn.png'),
    };
  },
};
</script>
<style scoped>
.linkflix-logo {
  display: block;
  margin-top: 5%;
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
  margin-top: 5%;
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
