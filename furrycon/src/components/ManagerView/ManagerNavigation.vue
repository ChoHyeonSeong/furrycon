<template>
  <div>
    <nav class="vertical-center nav-box">
      <router-link to="/wasabi/970917"
        ><div class="vertical-center nav-item">convention register</div></router-link
      >
    </nav>
  </div>
</template>

<script setup lang="ts"></script>

<style scoped>
.nav-box a {
  height: 100%;
}

.nav-item {
  height: 50px;
  padding: 5px;
  transition-property: background-color;
  transition-duration: 0.2s;
}
.nav-item:hover {
  background-color: lightgray;
}
</style>
