<template>
  <div>
    <div class="layered-image" :style="setBgProductImage()"></div>
    <div class="overlay-text bg-dark text-white">
      <h5>{{ product.name }}</h5>
      <table
        class="
          table table-dark table-hover
          cursor-pointer
          mt-3
          table-layout-fixed
        "
      >
        <thead class="table-light">
          <tr>
            <th scope="col" style="width: 60%">판매처</th>
            <th scope="col" style="width: 40%">가격</th>
          </tr>
        </thead>
        <tbody>
          <tr v-if="priceList.length == 0">
            <td colspan="2" class="text-center">No Data</td>
          </tr>
          <tr v-for="price in priceList" @click="onClickRow(price.link)">
            <td class="text-truncate" v-html="price.seller"></td>
            <td>{{ price.price }}</td>
          </tr>
        </tbody>
      </table>

      <div>
        <h6>타임라인</h6>
        <ul>
          <div v-if="product.timeline.length == 0">No Data</div>
          <li v-for="timeline in product.timeline">
            <small>{{ timeline.startTime }} ~ {{ timeline.endTime }}</small>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { PropType } from 'vue';
import { Product, Sale } from '../../types';
import NotFoundImage from '../../assets/images/not-found.jpg';

const { product, priceList } = defineProps({
  product: {
    type: Object as PropType<Product>,
    required: true,
  },
  priceList: {
    type: Object as PropType<Sale[]>,
    required: true,
  },
});

const DARK_COLOR = '#212529';
const setBgProductImage = () => {
  return {
    background: `linear-gradient(to bottom, transparent, 20%, ${DARK_COLOR}),
      url('${product.imagePath}'), url(${NotFoundImage})`,
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
  padding: 0 0.5rem 0.5rem;
}
.table > thead > tr > th {
  font-size: 0.75rem;
  padding: 0.5rem 1.25rem;
}
.table > tbody > tr > td {
  padding: 0.5rem 1rem;
}
</style>
