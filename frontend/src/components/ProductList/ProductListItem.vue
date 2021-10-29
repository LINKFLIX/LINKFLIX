<template>
  <div style="width: 360px">
    <div
      class="
        position-relative
        card
        text-white
        bg-dark
        p-0
        hover-expand
        cursor-pointer
      "
      style="width: 360px; height: 120px"
      data-bs-toggle="collapse"
      :data-bs-target="'#collapseDetail' + product.id"
      aria-expanded="false"
      :aria-controls="'collapseDetail' + product.id"
    >
      <div class="row g-0 w-100 h-100">
        <div class="col-5 h-100">
          <img
            :src="product.imagePath"
            :title="product.name"
            :alt="product.name"
            @error="setDefaultImage"
            class="w-100 h-100"
            style="object-fit: cover"
          />
        </div>
        <div class="col-7">
          <div class="d-flex flex-column card-body p-2 h-100">
            <small class="d-block text-muted text-truncate">{{
              joinTimelines(product.timeline)
            }}</small>
            <h6 class="text-truncate m-0">
              {{ product.name }}
            </h6>
            <div
              class="text-end d-flex flex-column justify-content-end"
              style="flex-grow: 1"
            >
              <div v-if="priceList.length == 0">No Data</div>
              <div v-else>
                <small>최저가</small>
                <div>
                  <h5 class="d-inline-block m-0">{{ minPrice }}</h5>
                  <small class="d-inline-block ms-1">원</small>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="collapse" :id="'collapseDetail' + product.id">
      <ProductListItemCollapse
        :product="product"
        :priceList="priceList"
      ></ProductListItemCollapse>
    </div>
  </div>
</template>

<script setup lang="ts">
import { PropType, onMounted, ref, computed } from 'vue';
import { Product, Sale, Timeline } from '../../types';
import { testPriceList } from '../../dump';
import NotFoundImage from '../../assets/images/not-found.jpg';

import ProductListItemCollapse from './ProductListItemCollapse.vue';

const { product } = defineProps({
  product: {
    type: Object as PropType<Product>,
    required: true,
  },
});

const priceList = ref<Sale[]>([]);

onMounted(() => {
  try {
    // TODO: call crawling and set state
    const result = testPriceList.find(
      (item) => item.keyword === product.searchKeyword
    );
    if (result) {
      result.priceList = result.priceList.sort(
        (a, b) =>
          removeCommaAndConvertToNumber(a.price) -
          removeCommaAndConvertToNumber(b.price)
      );
      priceList.value = result.priceList;
    }
  } catch (error) {
    console.error(error);
  }
});

const minPrice = computed(() => {
  if (priceList.value && priceList.value.length > 0) {
    return priceList.value[0].price;
  }
  return '';
});

const removeCommaAndConvertToNumber = (price: string) => {
  return Number(price.replaceAll(',', ''));
};

const joinTimelines = (timeline: Timeline[]) => {
  if (!timeline || timeline.length == 0) return '타임라인 없음';

  let str = timeline[0].startTime + '~' + timeline[0].endTime;
  for (let i = 1; i < timeline.length; i++) {
    str += `, `;
    str += timeline[i].startTime + '~' + timeline[i].endTime;
  }

  return str;
};

const setDefaultImage = (event: Event) => {
  (event.target as HTMLImageElement).src = NotFoundImage;
};
</script>

<style scoped>
.hover-expand {
  z-index: 0;
  border-radius: 0;
  transition: transform ease 300ms, border-radius 300ms, z-index 300ms;
}
.hover-expand:hover {
  z-index: 10;
  border-radius: 0.5rem;
  transform: scale(1.05);
}
</style>
