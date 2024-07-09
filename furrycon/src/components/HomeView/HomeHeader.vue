<template>
  <div class="vertical-center home-header">
    <div class="flex-center name-box">
      <h1>FurryCon World</h1>
    </div>
    <div class="flex-center sign-in-box"><h2>sign in</h2></div>
  </div>
</template>

<script setup lang="ts"></script>

<style scoped>
.home-header {
  justify-content: space-between;
}

.name-box {
  width: 25%;
}

.sign-in-box {
  width: 15%;
  height: 100%;
  border: 1px solid lightgray;
  background-color: white;
  border-radius: 5px;
}
</style>
