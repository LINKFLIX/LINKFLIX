<template>
  <div>
    <ProductListItem
      v-for="product in productList"
      :product="product"
    ></ProductListItem>
  </div>
</template>

<script setup lang="ts">
import { ref, toRef, defineProps, watch } from 'vue';
import ProductListItem from './ProductListItem.vue';
import { Product, TimelineDto } from '../../types';
import { TimelineApi } from '../../api/restApi';

const props = defineProps({
  isShow: {
    type: Boolean,
    required: true,
  },
});

const currentEpisodeId = ref('');
const isShow = toRef(props, 'isShow');
const productList = ref<Product[]>([]);

watch(isShow, () => {
  if (isShow.value) {
    const netflixEpisodeId = window.location.pathname.split('/')[2];

    if (currentEpisodeId.value !== netflixEpisodeId) {
      currentEpisodeId.value = netflixEpisodeId;
      callGetTimelines();
    }
  }
});

const callGetTimelines = () => {
  TimelineApi.getTimelines(currentEpisodeId.value)
    .then((data) => {
      const responseData = data;
      const result: Product[] = [];

      responseData.forEach((item: TimelineDto) => {
        const p = result.find((p) => p.id == item.product.id);
        if (p) {
          p.timeline.push({ startTime: item.startTime });
        } else {
          item.product.imagePath =
            'https://k5a104.p.ssafy.io:8081/products/image/' +
            item.product.imagePath.split('/')[2];

          result.push({
            ...item.product,
            timeline: [{ startTime: item.startTime }],
          });
        }
      });

      productList.value = result;
    })
    .catch((err) => {
      console.error(err);
    });
};
</script>

<style></style>
