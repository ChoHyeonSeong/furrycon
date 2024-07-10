<template>
  <div>
    <h1>CONVENTION</h1>
    <form>
      <div class="input-box">
        Name :
        <input class="input-field" type="text" />
      </div>
      <div class="input-box">
        StartDate :
        <input class="input-field" type="date" />
      </div>
      <div class="input-box">
        EndDate :
        <input class="input-field" type="date" />
      </div>
      <div class="input-box">
        CountryCode :
        <input class="input-field" type="text" />
      </div>
      <div class="input-box">
        Location :
        <input class="input-field" type="text" />
      </div>
      <div class="input-box">
        HomepageUrl :
        <input class="input-field" type="text" />
      </div>
      <button>register</button>
    </form>
  </div>
</template>

<script setup lang="ts"></script>

<style scoped>
.input-box {
  margin: 10px;
}

.input-field {
  border: 1px solid lightgray;
}
</style>
