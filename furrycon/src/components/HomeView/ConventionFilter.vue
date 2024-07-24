<template>
  <div class="filter-box">
    <!-- 일반 필터 -->
    <div class="flex">
      <div class="filter-item">
        <div class="flex-center filter-big-title">dates</div>
        <div><input type="date" /> ~ <input type="date" /></div>
      </div>
      <div class="filter-item">
        <div class="flex-center filter-big-title">country</div>
        <country-dropdown />
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import VueDatePicker from '@vuepic/vue-datepicker'
import '@vuepic/vue-datepicker/dist/main.css'
import { useConventionStore } from '@/stores/convention'
import SvgIcon from '@jamescoyle/vue-icon'
import CountryDropdown from './CountryDropdown.vue'
import { mdiCalendarClock, mdiFlag, mdiCheckCircleOutline } from '@mdi/js'

const scheduleSelected = ref(false)
const countrySelected = ref(false)
const dateRange = ref()
const countryCode = ref()
const conventionStore = useConventionStore()
const calendarIcon = ref(mdiCalendarClock)
const flagIcon = ref(mdiFlag)
const checkCircleIcon = ref(mdiCheckCircleOutline)

function selectFilter(filter) {
  switch (filter) {
    case 0:
      scheduleSelected.value = !scheduleSelected.value
      if (!scheduleSelected.value) updateDateRange()
      break
    case 1:
      countrySelected.value = !countrySelected.value
      if (!countrySelected.value) updateCountryCode()
      break
  }
}

function updateDateRange(range) {
  dateRange.value = range
  if (range && range[0] && range[1]) conventionStore.setScheduleFilter(range[0], range[1])
  else conventionStore.resetScheduleFilter()
}

function updateCountryCode(code) {
  countryCode.value = code
  if (code) conventionStore.setCountryCodeFilter(code.iso2)
  else conventionStore.resetCountryCodeFilter()
}
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
