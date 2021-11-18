<template>
  <div class="container">
    <div class="row">
      <div class="col-4" style="text-align: left">
        <div style="font-weight: 900; font-size: 90px; margin-bottom: 100px">
          <p>BETA</p>
        </div>
        <div style="font-size: 30px; font-weight: 600">
          <p style="margin-bottom: 35px">현재 LINKFLIX는</p>
          <p style="margin-bottom: 35px">일부 영상에서 이용 가능합니다</p>
          <p style="margin-bottom: 36px">서비스 영상은</p>
          <p style="margin-bottom: 36px">지속적으로 업데이트 됩니다</p>
        </div>
      </div>
      <div class="col-8" style="display: flex; justify-content: space-around">
        <ul class="title">
          <li>
            <img
              :src="`https://file.mk.co.kr/meet/neds/2021/08/image_readtop_2021_774018_16285690364746521.jpg`"
              style="width: 330px; height: 470px; margin-bottom: 25px"
            />
            <p>갯마을 차차차 1 ~ 3 화</p>
          </li>
        </ul>
        <ul class="title">
          <li>
            <img
              :src="`https://upload.wikimedia.org/wikipedia/ko/6/60/%EA%B8%B0%EC%83%9D%EC%B6%A9_%ED%8F%AC%EC%8A%A4%ED%84%B0.jpg`"
              style="
                width: 330px;
                height: 470px;
                margin-bottom: 25px;
                border: solid 1px lightgrey;
              "
            />
            <p>기생충</p>
          </li>
        </ul>
      </div>
    </div>

  </div>
</template>

<script lang="ts">
export default {
  name: 'slideThird',
  data() {
    return {
      imgsrc: require('../assets/oberlaysidebar.png'),
    };
  },
};
</script>

<style scoped>
.title {
  list-style: none;
  padding-left: 0px;
  font-size: 20px;
  font-weight: 700;
}
.eplist {
  list-style: none;
  padding-left: 0px;
  font-size: 15px;
  font-weight: 500;
}
li {
  float: left;
}
</style>
