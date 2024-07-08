<template>
  <div class="filter-box flex">
    <div class="btn-box flex">
      <button
        type="button"
        class="flex-center"
        :class="countrySelected ? 'half-btn half-box symbol-bg-color' : 'btn full-box btn-bg-color'"
        @click="selectFilter(0)"
      >
        <CountryIcon class="icon-box" />
        country
      </button>
      <input class="half-box input-box" v-if="countrySelected" type="text" />
    </div>
    <div class="btn-box flex">
      <button
        type="button"
        class="flex-center"
        :class="
          scheduleSelected ? 'half-btn half-box symbol-bg-color' : 'btn full-box btn-bg-color'
        "
        @click="selectFilter(1)"
      >
        <ScheduleIcon class="icon-box" />
        schedule
      </button>
      <input class="half-box input-box" v-if="scheduleSelected" type="text" />
    </div>
    <div class="btn-box flex">
      <button class="full-box btn symbol-bg-color flex-center" type="button">
        <PlusIcon class="icon-box" />
        request
      </button>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import CountryIcon from '@/components/icons/CountryIcon.vue'
import ScheduleIcon from '@/components/icons/ScheduleIcon.vue'
import PlusIcon from '@/components/icons/PlusIcon.vue'

const countrySelected = ref(false)
const scheduleSelected = ref(false)

function selectFilter(filter: number) {
  switch (filter) {
    case 0:
      countrySelected.value = !countrySelected.value
      break

    case 1:
      scheduleSelected.value = !scheduleSelected.value
      break
  }
}
</script>

<style scoped>
.filter-box {
  width: 90%;
  justify-content: space-between;
}
.btn-box {
  width: 30%;
  height: 7vh;
}
.btn {
  font-size: 1.5em;
  border: 1px solid lightgray;
  border-radius: 5px;
  color: gray;
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
}

.btn-bg-color {
  background-color: white;
}

.btn:hover {
  background-color: lightgray;
}

.input-box {
  border-radius: 5px;
  border-top-left-radius: 0px;
  border-bottom-left-radius: 0px;
  border: 1px solid lightgray;
}

.icon-box {
  width: 1.5em;
  height: 1.5em;
  margin: 10px;
}
</style>
