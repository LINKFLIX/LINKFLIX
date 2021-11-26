<template>
  <div class="w-100" style="padding: 140px 120px; height: 100vh">
    <div class="container overflow-auto h-100">
      <div class="row h-100">
        <div class="col-4">
          <div
            class="
              h-100
              d-flex
              flex-column
              align-items-center
              justify-content-center
            "
          >
            <div class="display-5 mb-4 w-100">
              <slot name="subtitle"></slot>
            </div>

            <div class="display-6 fs-3" style="line-height: 1.5">
              <slot name="description"></slot>
            </div>
          </div>
        </div>
        <div class="col-1"></div>
        <div class="col-7">
          <div class="d-flex h-100 align-items-center justify-content-center">
            <slot name="image-container"></slot>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
