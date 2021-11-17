<template>
  <SlideTemplate>
    <template v-slot:subtitle> Beta </template>
    <template v-slot:description>
      <div>현재 LINKFLIX는</div>
      <div>일부 영상에서 이용 가능합니다.</div>
    </template>
    <template v-slot:image-container>
      <img
        src="https://w.namu.la/s/5cd695b54231bb2af4d801ef59881da0bd343d71486ab2c81264059581ce4193df40d08c2f0240e79529c63196628a9c591d605563d4af4c963e6417892f81a2fd9bace704779477f6bc2dcf1da880ea856f2a39f27edc02975393a59a1d369a"
        alt="갯마을차차차"
        style="width: 30%"
      />
      <img
        src="https://w.namu.la/s/5cd695b54231bb2af4d801ef59881da0bd343d71486ab2c81264059581ce4193df40d08c2f0240e79529c63196628a9c591d605563d4af4c963e6417892f81a2fd9bace704779477f6bc2dcf1da880ea856f2a39f27edc02975393a59a1d369a"
        alt="갯마을차차차"
        style="width: 30%; margin-left: 10px"
      />
    </template>
  </SlideTemplate>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import SlideTemplate from './SlideTemplate.vue';

export default defineComponent({
  components: { SlideTemplate },
});
</script>
