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
import { testProductList } from '../../dump';
import { Product } from '../../types';

const productList = ref<Product[]>([]);

onMounted(() => {
  // TODO: call server about product data
  productList.value = testProductList;
});
</script>

<style></style>
