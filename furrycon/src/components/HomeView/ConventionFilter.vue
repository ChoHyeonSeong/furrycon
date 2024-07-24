<template>
  <div class="filter-box">
    <!-- 일반 필터 -->
    <div class="flex">
      <div class="filter-item">
        <div class="flex-center filter-big-title">dates</div>
        <convention-dates />
      </div>
      <div class="filter-item">
        <div class="flex-center filter-big-title">country</div>
        <country-dropdown />
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import CountryDropdown from './CountryDropdown.vue'
import ConventionDates from './ConventionDates.vue'
</script>

<style scoped>
.filter-box {
  margin-bottom: 20px;
}
.btn-box {
  width: 32%;
  height: 70px;
}
.btn {
  font-size: 1.5em;
  border: 1px solid lightgray;
  border-radius: 5px;
  color: gray;
  transition-property: background-color width;
  transition-duration: 0.2s;
}
.half-box {
  width: 50%;
}
.half-btn {
  font-size: 1.5em;
  border: 1px solid lightgray;
  border-radius: 5px;
  border-top-right-radius: 0px;
  border-bottom-right-radius: 0px;
  transition-property: width;
  transition-duration: 0.2s;
}

.btn-bg-color {
  background-color: white;
}

.btn:hover {
  background-color: rgb(193, 232, 197);
}

.input-box {
  width: 50%;
  border-radius: 5px;
  border-top-left-radius: 0px;
  border-bottom-left-radius: 0px;
  border: 1px solid lightgray;
}

.date-picker-box {
  width: 50%;
}

.icon-box {
  width: 36px;
  height: 36px;
  margin: 10px;
}
.country-box {
  border-radius: 5px;
  border-top-left-radius: 0px;
  border-bottom-left-radius: 0px;
  height: 70px;
}

.btn-color-black {
  color: black;
}

.location-confirmed-checkbox {
  height: 22px;
}
</style>

<style>
.dp__input {
  border-radius: 5px;
  border-top-left-radius: 0px;
  border-bottom-left-radius: 0px;
  height: 70px;
}
.country-intl-input-wrap .country-intl-input {
  border-radius: 5px;
  border-top-left-radius: 0px;
  border-bottom-left-radius: 0px;
  height: 70px;
}

.country-intl-label {
  display: flex;
  justify-content: center;
  align-items: center;
}

.schedule-filter-small-title {
  font-size: 14px;
}
.filter-big-title {
  font-size: 20px;
  border-bottom: 1px solid lightgray;
}
.filter-item {
  margin: 10px;
  padding: 6px;
  border-radius: 5px;
  height: 50px;
  border: 1px solid lightgray;
}
</style>
