<template>
  <div>
    <div class="layered-image" :style="setBgProductImage()"></div>
    <div class="overlay-text bg-dark text-white">
      <div class="fs-xlarge m-2" style="margin-top: 0 !important">
        {{ product.name }}
      </div>
      <table
        class="
          table table-dark table-hover
          cursor-pointer
          mt-4
          table-layout-fixed
        "
      >
        <thead class="table-light">
          <tr>
            <th scope="col" style="width: 60%">
              <span class="fs-medium">판매처</span>
            </th>
            <th scope="col" style="width: 40%">
              <span class="fs-medium">가격</span>
            </th>
          </tr>
        </thead>
        <tbody>
          <tr v-if="priceList.length == 0">
            <td colspan="2" class="text-center fs-medium">No Data</td>
          </tr>
          <tr v-for="price in priceList" @click="onClickRow(price.link)">
            <td class="text-truncate fs-medium" v-html="price.seller"></td>
            <td class="fs-medium">{{ price.price }}</td>
          </tr>
        </tbody>
      </table>

      <div class="mb-3">
        <div class="fs-large m-2">타임라인</div>
        <ul class="list-inline m-2">
          <div v-if="product.timeline.length == 0" class="fs-medium">
            No Data
          </div>
          <li v-for="timeline in product.timeline" class="list-inline-item">
            <span class="fs-medium">
              {{ timeline.startTime }}~{{ timeline.endTime }}
            </span>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { PropType, defineProps, toRef } from 'vue';
import { Product, Sale } from '../../types';
import { NotFoundImageEncodedBase64 } from '../../assets/images';

const props = defineProps({
  product: {
    type: Object as PropType<Product>,
    required: true,
  },
  priceList: {
    type: Object as PropType<Sale[]>,
    required: true,
  },
});

const product = toRef(props, 'product');
const priceList = toRef(props, 'priceList');

const DARK_COLOR = '#212529';
const setBgProductImage = () => {
  return {
    background: `linear-gradient(to bottom, transparent, 20%, ${DARK_COLOR}),
      url('${product.value.imagePath}'), url('${NotFoundImageEncodedBase64}')`,
    backgroundSize: 'cover',
    backgroundPosition: 'center',
  };
};

const onClickRow = (link: string) => {
  window.open(link);
};
</script>

<style scoped>
.background-image {
  width: 100%;
  height: 200px;
  position: relative;
  top: 0;
  left: 0;
  z-index: 0;
}
.layered-image {
  width: 100%;
  height: 200px;
  position: relative;
  top: 0;
  left: 0;
  z-index: 1;
}
.overlay-text {
  position: relative;
  top: 0;
  left: 0;
  z-index: 3;
  padding: 0 5px 5px;
}
.table > thead > tr > th {
  font-size: 8px;
  padding: 10px 13px;
}
.table > tbody > tr > td {
  padding: 10px;
}

.list-inline-item:not(:last-child) {
  margin-right: 12px;
}
</style>
