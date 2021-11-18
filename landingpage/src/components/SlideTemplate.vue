<template>
  <div class="w-100" style="padding: 140px 120px; height: 100vh">
    <div class="d-flex h-100 overflow-auto align-items-center">
      <div class="col-4">
        <div class="display-1" style="margin: 40px 0">
          <slot name="subtitle"></slot>
        </div>

        <div class="display-6" style="line-height: 1.5">
          <slot name="description"></slot>
        </div>
      </div>
      <div class="col-1"></div>
      <div class="col-7">
        <slot name="image-container"></slot>
      </div>
    </div>
  </div>
</template>
