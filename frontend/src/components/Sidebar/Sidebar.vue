<template>
  <div>
    <button
      class="btn-cart p-0"
      type="button"
      data-bs-toggle="offcanvas"
      data-bs-target="#offcanvasRight"
      aria-controls="offcanvasRight"
    >
      <div
        class="d-flex justify-content-center align-items-center"
        style="width: 4rem; height: 4rem"
      >
        <svg
          xmlns="http://www.w3.org/2000/svg"
          fill="currentColor"
          class="bi bi-cart3"
          viewBox="0 0 16 16"
        >
          <path
            d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .49.598l-1 5a.5.5 0 0 1-.465.401l-9.397.472L4.415 11H13a.5.5 0 0 1 0 1H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l.84 4.479 9.144-.459L13.89 4H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"
          />
        </svg>
      </div>
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

<style scoped>
.btn-cart {
  background-color: transparent;
  border: 0;
  outline: 0;
  color: white;
  transition: transform 150ms ease 0s;
}
.btn-cart:hover {
  transform: scale(1.3);
}
</style>
