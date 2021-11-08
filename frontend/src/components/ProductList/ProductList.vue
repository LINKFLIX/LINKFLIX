<template>
  <div>
    <div
      v-if="!productList || productList.length == 0"
      class="d-flex justify-content-center align-items-center text-center"
      style="height: 200px; margin: 0 50px"
    >
      <div>
        <svg
          xmlns="http://www.w3.org/2000/svg"
          width="24"
          height="24"
          fill="currentColor"
          class="bi bi-cart-x"
          viewBox="0 0 16 16"
        >
          <path
            d="M7.354 5.646a.5.5 0 1 0-.708.708L7.793 7.5 6.646 8.646a.5.5 0 1 0 .708.708L8.5 8.207l1.146 1.147a.5.5 0 0 0 .708-.708L9.207 7.5l1.147-1.146a.5.5 0 0 0-.708-.708L8.5 6.793 7.354 5.646z"
          />
          <path
            d="M.5 1a.5.5 0 0 0 0 1h1.11l.401 1.607 1.498 7.985A.5.5 0 0 0 4 12h1a2 2 0 1 0 0 4 2 2 0 0 0 0-4h7a2 2 0 1 0 0 4 2 2 0 0 0 0-4h1a.5.5 0 0 0 .491-.408l1.5-8A.5.5 0 0 0 14.5 3H2.89l-.405-1.621A.5.5 0 0 0 2 1H.5zm3.915 10L3.102 4h10.796l-1.313 7h-8.17zM6 14a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm7 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0z"
          />
        </svg>
        <div style="font-size: 20px; margin-top: 10px; font-weight: 300">
          데이터가 없습니다.
        </div>
      </div>
    </div>
    <ProductListItem
      v-else
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
