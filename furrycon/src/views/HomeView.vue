<template>
  <header class="">
    <div class="flex-center header-box component-margin symbol-bg-color">
      <home-header class="content-width" />
    </div>
  </header>
  <main class="flex-center">
    <div class="content-width">
      <convention-filter class="component-margin" />
      <convention-list />
    </div>
  </main>
</template>

<script setup lang="ts">
import ConventionList from '@/components/HomeView/ConventionList.vue'
import ConventionFilter from '@/components/HomeView/ConventionFilter.vue'
import HomeHeader from '@/components/HomeView/HomeHeader.vue'
</script>

<style scoped>
.header-box {
  height: 80px;
  width: 100vw;
  box-shadow: 0 2px 10px 0 rgba(0, 0, 0, 0.1);
}
.content-width {
  width: 1280px;
}
.component-margin {
  margin-bottom: 30px;
}
</style>
