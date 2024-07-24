<template>
  <div>
    <h1>CONVENTION</h1>
    <form @submit.prevent="submitConventionData">
      <div class="input-box">
        Name :
        <input class="input-field" type="text" v-model="convention.name" />
      </div>
      <div class="input-box">
        StartDate :
        <input class="input-field" type="date" v-model="convention.startDate" />
      </div>
      <div class="input-box">
        EndDate :
        <input class="input-field" type="date" v-model="convention.endDate" />
      </div>
      <div class="input-box">
        CountryCode :

        <vue3-country-intl
          class="input-field"
          type="country"
          v-model="convention.countryCode"
          placeholder="Select Country"
        />
      </div>
      <div class="input-box">
        Location :
        <input class="input-field" type="text" v-model="convention.location" />
      </div>
      <div class="input-box">
        City :
        <input class="input-field" type="text" v-model="convention.city" />
      </div>
      <div class="input-box">
        HomepageUrl :
        <input class="input-field" type="text" v-model="convention.homepageUrl" />
      </div>
      <button>register</button>
    </form>
  </div>
</template>

<script setup lang="ts">
import type { RequestConvention } from '@/api/convention'
import { useManagerStore } from '@/stores/manager'
import { ref } from 'vue'

const convention = ref<RequestConvention>({
  name: '',
  startDate: '',
  endDate: '',
  countryCode: '',
  location: '',
  city: '',
  homepageUrl: ''
})
const managerStore = useManagerStore()

function submitConventionData() {
  managerStore.registerConvention(convention.value)
}
</script>

<style scoped>
.input-box {
  margin: 10px;
}

.input-field {
  border: 1px solid lightgray;
  width: 200px;
}
</style>
