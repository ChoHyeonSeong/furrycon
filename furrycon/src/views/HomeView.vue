<template>
  <header class="flex-center header-box">
    <ConventionFilter />
  </header>
  <main class="flex-center">
    <ConventionList />
  </main>
</template>

<script setup lang="ts">
import ConventionList from '@/components/HomeView/ConventionList.vue'
import ConventionFilter from '@/components/HomeView/ConventionFilter.vue'
</script>

<style scoped>
.header-box {
  margin-top: 50px;
  margin-bottom: 50px;
}
</style>
