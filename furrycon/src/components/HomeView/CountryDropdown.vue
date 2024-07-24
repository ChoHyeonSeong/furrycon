<template>
  <div class="dropdown">
    <input
      type="text"
      id="searchInput"
      placeholder="Select Country"
      v-model="searchCountry"
      @focus="show"
      @blur="hide"
      @input="countryFilter"
    />
    <div id="dropdown" class="dropdown-content" v-if="clickSearch">
      <!-- 검색 결과가 여기 나타납니다 -->
      <template v-for="(item, i) in countries" :key="i">
        <div @mouseover="mouseoverCountry" @mouseout="mouseoutCountry" @click="selectCountry(item)">
          {{ item.name }}
        </div>
      </template>
    </div>
  </div>
</template>

<script setup lang="ts">
import { useConventionStore } from '@/stores/convention'
import { ref } from 'vue'
const searchCountry = ref('')
const clickSearch = ref(false)

const conventionStore = useConventionStore()
const countries = ref<CountryData[]>([])
const countryHover = ref(false)

function show() {
  clickSearch.value = true
  const filter = searchCountry.value.toUpperCase()
  if (filter) {
    const filteredData = conventionStore.countries.filter(
      (item) => item.name.toUpperCase().includes(filter) || item.iso3.toUpperCase().includes(filter)
    )
    countries.value = filteredData
  } else {
    countries.value = conventionStore.countries
  }
}

function hide() {
  if (!countryHover.value) clickSearch.value = false
}

function countryFilter() {
  const filter = searchCountry.value.toUpperCase()
  if (filter) {
    const filteredData = conventionStore.countries.filter(
      (item) => item.name.toUpperCase().includes(filter) || item.iso3.toUpperCase().includes(filter)
    )
    countries.value = filteredData
  } else {
    countries.value = conventionStore.countries
  }
}

function selectCountry(country: CountryData) {
  searchCountry.value = country.name
  conventionStore.setCountryCodeFilter(country.iso3)
  mouseoutCountry()
  hide()
}

function mouseoverCountry() {
  countryHover.value = true
}
function mouseoutCountry() {
  countryHover.value = false
}

interface CountryData {
  name: string
  iso2: string
  iso3: string
}
</script>

<style scoped>
.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: block;
  overflow-y: scroll;
  height: 300px;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
  z-index: 1;
}
.dropdown-content div {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content div:hover {
  background-color: #ddd;
}
</style>
