<template>
  <div>
    <input type="date" v-model="startDate" @input="inputDate" /> ~
    <input type="date" v-model="endDate" @input="inputDate" />
  </div>
</template>

<script setup lang="ts">
import { useConventionStore } from '@/stores/convention'
import { ref } from 'vue'

const startDate = ref<Date>()
const endDate = ref<Date>()
const conventionStore = useConventionStore()

function inputDate() {
  if (startDate.value && endDate.value) {
    if (startDate.value > endDate.value) {
      const temp = startDate.value
      startDate.value = endDate.value
      endDate.value = temp
    }
    conventionStore.setScheduleFilter(startDate.value, endDate.value)
  }
}
</script>

<style scoped></style>
