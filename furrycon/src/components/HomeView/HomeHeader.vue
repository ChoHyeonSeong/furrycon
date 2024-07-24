<template>
  <div class="vertical-center home-header">
    <div class="flex-center">
      <img class="logo-box" src="/logo.png" alt="" />
      <div class="flex-center name-box">
        <div>FURRYCON</div>
        <div>WORLD</div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts"></script>

<style scoped>
.home-header {
  justify-content: space-between;
  height: 60px;
  margin-top: 20px;
  margin-bottom: 20px;
}

.name-box {
  flex-direction: column;
  font-size: 22px;
  font-weight: bold;
}

.logo-box {
  width: 64px;
  height: 64px;
  margin: 12px;
}
</style>
