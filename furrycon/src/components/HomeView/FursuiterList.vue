<template>
  <div class="fursuiter-box">
    <div class="title-box">DAILY FURSUITER</div>
    <div class="flex list-box">
      <div class="item-box"></div>
      <div class="item-box"></div>
      <div class="item-box"></div>
      <div class="item-box"></div>
    </div>
  </div>
</template>

<script setup lang="ts"></script>

<style scoped>
.fursuiter-box {
  margin-top: 20px;
  margin-bottom: 20px;
}

.list-box {
  justify-content: space-between;
}

.item-box {
  width: 300px;
  height: 400px;
  border-radius: 5px;
  background-color: lightgrey;
}
.title-box {
  font-size: 20px;
}
</style>
