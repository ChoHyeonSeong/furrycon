<template>
  <header>
    <div class="section-line flex-center">
      <home-header class="content-width" />
    </div>
  </header>
  <main class="flex-center">
    <div class="content-width">
      <convention-filter />
      <convention-list />
    </div>
  </main>
</template>

<script setup lang="ts">
import ConventionFilter from '@/components/HomeView/ConventionFilter.vue'
import ConventionList from '@/components/HomeView/ConventionList.vue'
import HomeHeader from '@/components/HomeView/HomeHeader.vue'
import { testConnection } from '@/api/convention'

testConnection('테스트 연결!')
</script>

<style scoped>
.content-width {
  width: 1280px;
}

.section-line {
  width: 100vw;
  border-bottom: 1px solid rgb(235, 235, 235);
}
</style>
