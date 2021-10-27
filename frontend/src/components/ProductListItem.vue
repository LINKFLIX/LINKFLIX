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
        <div class="col-md-5 h-100">
          <img
            :src="product.imgSrc"
            :title="product.productName"
            :alt="product.productName"
            class="w-100 h-100"
            style="object-fit: cover"
          />
        </div>
        <div class="col-md-7">
          <div class="d-flex flex-column card-body p-2 h-100">
            <small class="d-block text-muted text-truncate">{{
              joinTimelines(product.timeline)
            }}</small>
            <h6 class="text-truncate m-0">
              {{ product.productName }}
            </h6>
            <div
              class="text-end d-flex flex-column justify-content-end"
              style="flex-grow: 1"
            >
              <small>최저가</small>
              <div>
                <h5 class="d-inline-block m-0">
                  {{ numWithComma(product.price) }}
                </h5>
                <small class="d-inline-block ms-1">원</small>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="collapse" :id="'collapseDetail' + product.id">
      <ProductListItemCollapse :product="product"></ProductListItemCollapse>
    </div>
  </div>
</template>

<script setup lang="ts">
import { PropType } from 'vue';
import { Product, Timeline } from '../types';

import ProductListItemCollapse from './ProductListItemCollapse.vue';

const { product } = defineProps({
  product: {
    type: Object as PropType<Product>,
    required: true,
  },
});

const numWithComma = (num: string | undefined) => {
  if (!num) return 'ERROR';
  if (num.includes(',')) return num;

  let len: number, point: number, str: string;

  point = num.length % 3;
  len = num.length;

  str = num.substring(0, point);
  while (point < len) {
    if (str != '') str += ',';
    str += num.substring(point, point + 3);
    point += 3;
  }

  return str;
};

const joinTimelines = (timeline: Timeline[]) => {
  if (!timeline || timeline.length == 0) return '타임라인 없음';

  let str = timeline[0].start + '~' + timeline[0].end;
  for (let i = 1; i < timeline.length; i++) {
    str += `, `;
    str += timeline[i].start + '~' + timeline[i].end;
  }

  return str;
};
</script>

<style>
.hover-expand {
  z-index: 0;
  border-radius: 0;
  transition: transform ease 300ms, border-radius 300ms, z-index 300ms;
}
.hover-expand:hover {
  z-index: 1;
  border-radius: 0.5rem;
  transform: scale(1.05);
}
.cursor-pointer {
  cursor: pointer;
}
</style>
