<template>
  <div>
    <ProductListItem
      v-for="product in productList"
      :product="product"
    ></ProductListItem>
  </div>
</template>

<script setup lang="ts">
import { onMounted, ref } from 'vue';
import ProductListItem from './ProductListItem.vue';
import { testProductList, testTimelineResponse } from '../../dump';
import { Product, TimelineDto } from '../../types';
import { TimelineApi } from '../../api/api';

const productList = ref<Product[]>([]);

onMounted(() => {
  const TEST_NETFLIX_EPISODE_ID = '81282956';

  TimelineApi.getTimelines(TEST_NETFLIX_EPISODE_ID)
    .then((data) => {
      console.log(data);
      const responseData = data;
      const result: Product[] = [];

      responseData.forEach((item: TimelineDto) => {
        const p = result.find((p) => p.id == item.product.id);
        if (p) {
          p.timeline.push({ startTime: item.startTime, endTime: item.endTime });
        } else {
          result.push({
            ...item.product,
            timeline: [{ startTime: item.startTime, endTime: item.endTime }],
          });
        }
      });

      productList.value = testProductList;
    })
    .catch((err) => {
      console.error(err);
    });
});
</script>

<style></style>
