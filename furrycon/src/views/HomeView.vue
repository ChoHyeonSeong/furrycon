<template>
  <header class="flex-center">
    <div class="content-width">
      <home-header />
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
</style>
