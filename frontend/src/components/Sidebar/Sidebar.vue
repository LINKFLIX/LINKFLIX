<template>
  <div
    class="offcanvas offcanvas-end bg-dark text-white"
    tabindex="-1"
    id="offcanvasRight"
    aria-labelledby="offcanvasRightLabel"
    style="width: 400px"
  >
    <div class="offcanvas-header m-4 p-0">
      <div id="offcanvasRightLabel" class="fs-medium p-0">
        <img :src="logoEncodedBase64" alt="linkflix" style="width: 100px" />
      </div>
      <button
        type="button"
        class="btn-close btn-close-white text-reset fs-medium shadow-none p-0 m-2"
        data-bs-dismiss="offcanvas"
        aria-label="Close"
      ></button>
    </div>
    <div
      class="offcanvas-body p-0 scroll-display-none"
      style="overflow-x: hidden;"
    >
      <ProductList :products="products"></ProductList>
    </div>
  </div>
</template>

<script setup lang="ts">
import { defineProps, PropType } from 'vue';
import ProductList from '../ProductList/ProductList.vue';
import { logoEncodedBase64 } from '../../assets/images/logo';
import { Product } from '../../types';

const { products } = defineProps({
  products: {
    type: Object as PropType<Product[]>,
    required: true,
  },
});
</script>

<style>
.linkflix-toggle-btn {
  background-color: transparent;
  border: 0;
  outline: 0;
  color: white;
  transition: transform 150ms ease 0s;
}
.linkflix-toggle-btn:hover {
  transform: scale(1.3);
}
.scroll-display-none::-webkit-scrollbar {
  display: none; /* Chrome and Safari */
}
.scroll-display-none {
  -ms-overflow-style: none; /* IE and Edge */
  scrollbar-width: none; /* Firefox */
}
</style>
