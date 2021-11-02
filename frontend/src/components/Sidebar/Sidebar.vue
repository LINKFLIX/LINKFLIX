<template>
  <div>
    <button
      class="btn"
      type="button"
      data-bs-toggle="offcanvas"
      data-bs-target="#offcanvasRight"
      aria-controls="offcanvasRight"
    >
      LINKFLIX
    </button>

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
      <div class="offcanvas-body p-0" style="overflow-x: hidden">
        <ProductList></ProductList>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import ProductList from '../ProductList/ProductList.vue';
import { logoEncodedBase64 } from '../../assets/images/logo';
</script>

<style></style>
