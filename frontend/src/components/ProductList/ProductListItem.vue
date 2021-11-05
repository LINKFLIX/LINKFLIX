<template>
  <div>
    <div
      class="
        position-relative
        card
        text-white
        bg-dark
        p-0
        hover-expand
        cursor-pointer
        border-0
      "
      style="height: 120px"
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
            class="w-100 h-100"
            style="object-fit: cover"
            @error="setDefaultImage"
          />
        </div>
        <div class="col-7">
          <div class="d-flex flex-column card-body p-2 h-100">
            <div
              class="text-muted text-truncate fs-small"
              style="margin-bottom: 3px"
            >
              {{ joinTimelines(product.timeline) }}
            </div>
            <div class="text-truncate m-0 fs-large">
              {{ product.name }}
            </div>
            <div
              class="text-end d-flex flex-column justify-content-end"
              style="flex-grow: 1"
            >
              <div v-if="priceList.length == 0">No Data</div>
              <div v-else>
                <div class="fs-small">최저가</div>
                <div>
                  <div class="d-inline-block m-0 fs-xlarge">{{ minPrice }}</div>
                  <div class="d-inline-block ms-1 fs-small">원</div>
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
import { PropType, defineProps, onMounted, toRef, ref, computed } from 'vue';
import { Product, Sale, Timeline } from '../../types';
import { NotFoundImageEncodedBase64 } from '../../assets/images/notFoundImage';
import { ProductSaleApi } from '../../api/crawlingApi';
import ProductListItemCollapse from './ProductListItemCollapse.vue';

const props = defineProps({
  product: {
    type: Object as PropType<Product>,
    required: true,
  },
});

const product = toRef(props, 'product');
const priceList = ref<Sale[]>([]);

onMounted(() => {
  ProductSaleApi.getProductSales(product.value.searchKeyword)
    .then((data) => {
      // 응답 전처리
      let result: Sale[] = [];
      if (data && data.link && data.link.length > 0) {
        const size = data.link.length;
        for (let i = 0; i < size; i++) {
          result.push({
            link: data.link[i],
            price: data.price[i],
            seller: data.seller[i],
          });
        }

        // 가격순 정렬
        result = result.sort(
          (a, b) =>
            removeCommaAndConvertToNumber(a.price) -
            removeCommaAndConvertToNumber(b.price)
        );
      }

      priceList.value = result;
    })
    .catch((err) => {
      console.error(err);
    });
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

  let str = timeline[0].startTime;
  for (let i = 1; i < timeline.length; i++) {
    str += `, `;
    str += timeline[i].startTime;
  }

  return str;
};

const setDefaultImage = (event: Event) => {
  (event.target as HTMLImageElement).src = NotFoundImageEncodedBase64;
};
</script>

<style scoped>
.hover-expand {
  border-radius: 0;
  transition: transform ease 300ms, border-radius 300ms;
}
.hover-expand:hover {
  border-radius: 10px;
  transform: scale(1.05);
}
</style>
