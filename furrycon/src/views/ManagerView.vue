<template>
  <header>
    <div class="flex-center header-box symbol-bg-color">
      <manager-header class="content-width" />
    </div>
    <div class="flex-center header-box component-margin navi-box">
      <manager-navigation class="content-width" />
    </div>
  </header>
  <main class="flex-center">
    <div class="content-width">
      <router-view />
    </div>
  </main>
</template>

<script setup lang="ts">
import ManagerHeader from '@/components/ManagerView/ManagerHeader.vue'
import ManagerNavigation from '@/components/ManagerView/ManagerNavigation.vue'
</script>
<style scoped>
.header-box {
  width: 100vw;
  box-shadow: 0 2px 10px 0 rgba(0, 0, 0, 0.1);
}
.content-width {
  width: 1280px;
}
.component-margin {
  margin-bottom: 30px;
}
.navi-box {
  background-color: white;
}
</style>
