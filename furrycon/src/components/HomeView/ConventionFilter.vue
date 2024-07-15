<template>
  <div class="filter-box flex">
    <div class="btn-box flex">
      <button
        type="button"
        class="flex-center"
        :class="
          scheduleSelected ? 'half-btn half-box symbol-bg-color' : 'btn full-box btn-bg-color'
        "
        @click="selectFilter(0)"
      >
        <schedule-icon class="icon-box" />
        schedule
      </button>
      <vue-date-picker
        class="date-picker-box full-height"
        v-if="scheduleSelected"
        v-model="dateRange"
        @update:model-value="updateDateRange"
        model-type="yyyy-MM-dd"
        :enable-time-picker="false"
        range
      />
    </div>
    <div class="btn-box flex">
      <button
        type="button"
        class="flex-center"
        :class="countrySelected ? 'half-btn half-box symbol-bg-color' : 'btn full-box btn-bg-color'"
        @click="selectFilter(1)"
      >
        <flag-icon class="icon-box" />
        country
      </button>
      <vue3-country-intl
        class="input-box country-box"
        type="country"
        v-if="countrySelected"
        placeholder="Select Country"
        @change="updateCountryCode"
      />
    </div>
    <div class="btn-box flex">
      <button
        type="button"
        class="flex-center btn full-box"
        :class="confirmedLocationSelected ? 'symbol-bg-color' : 'btn-bg-color'"
        @click="selectFilter(2), updateConfirmedLocation()"
      >
        <plus-icon class="icon-box" />
        confirmed location
      </button>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import ScheduleIcon from '@/components/icons/ScheduleIcon.vue'
import PlusIcon from '@/components/icons/PlusIcon.vue'
import FlagIcon from '@/components/icons/FlagIcon.vue'
import VueDatePicker from '@vuepic/vue-datepicker'
import '@vuepic/vue-datepicker/dist/main.css'
import { useConventionStore } from '@/stores/convention'

const scheduleSelected = ref(false)
const countrySelected = ref(false)
const confirmedLocationSelected = ref(false)
const dateRange = ref()
const countryCode = ref()
const conventionStore = useConventionStore()

function selectFilter(filter: number) {
  switch (filter) {
    case 0:
      scheduleSelected.value = !scheduleSelected.value
      if (!scheduleSelected.value) updateDateRange()
      break
    case 1:
      countrySelected.value = !countrySelected.value
      if (!countrySelected.value) updateCountryCode()
      break
    case 2:
      confirmedLocationSelected.value = !confirmedLocationSelected.value
      break
  }
}

function updateDateRange(range?: string[]) {
  dateRange.value = range
  if (range) conventionStore.setScheduleFilter(range[0], range[1])
  else conventionStore.resetScheduleFilter()
}

function updateCountryCode(code?: { iso2: string }) {
  countryCode.value = code
  if (code) conventionStore.setCountryCodeFilter(code.iso2)
  else conventionStore.resetCountryCodeFilter()
}

function updateConfirmedLocation() {
  conventionStore.setConfirmedLocationFilter(confirmedLocationSelected.value)
}
</script>

<style scoped>
.filter-box {
  width: 100%;
  justify-content: space-between;
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
  width: 40%;
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
  width: 60%;
  border-radius: 5px;
  border-top-left-radius: 0px;
  border-bottom-left-radius: 0px;
  border: 1px solid lightgray;
}

.date-picker-box {
  width: 60%;
}

.icon-box {
  width: 1.5em;
  height: 1.5em;
  margin: 10px;
}
.country-box {
  border-radius: 5px;
  border-top-left-radius: 0px;
  border-bottom-left-radius: 0px;
  height: 70px;
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
</style>
