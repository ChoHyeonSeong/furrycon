<template>
  <div class="list-box">
    <table class="full-width">
      <thead>
        <tr>
          <th style="width: 230px">Dates</th>
          <th style="width: 110px">Country</th>
          <th style="width: 300px">Convention</th>
          <th>Location</th>
          <th class="icon-th">
            <svg-icon type="mdi" :path="homeIcon" class="icon-box vertical-center" />
          </th>
        </tr>
      </thead>
      <tbody>
        <template v-for="(convention, i) in conventionStore.conventions" :key="i">
          <tr>
            <td>{{ convention.startDate }} ~ {{ convention.endDate }}</td>
            <td class="flex-center">
              <img :src="'/svg/' + convention.countryCode + '.svg'" alt="Logo" class="flag-box" />
              <div class="code-box">
                {{ convention.countryCode.toUpperCase() }}
              </div>
            </td>
            <td>{{ convention.name }}</td>
            <td>
              <div>{{ convention.location }}</div>
              <div>{{ convention.city }}</div>
            </td>
            <td>
              <a :href="convention.homepageUrl" target="_blank">
                <svg-icon type="mdi" :path="homeIcon" class="icon-box vertical-center" />
              </a>
            </td>
          </tr>
        </template>
      </tbody>
    </table>
    <div ref="loadMore" class="loading flex-center"><h1>Loading...</h1></div>
  </div>
</template>

<script setup lang="ts">
import { useConventionStore } from '@/stores/convention'
import SvgIcon from '@jamescoyle/vue-icon'
import { mdiHome } from '@mdi/js'
import { ref, onMounted, onBeforeUnmount } from 'vue'

const conventionStore = useConventionStore()
const homeIcon = ref(mdiHome)
const loadMore = ref()
let observer: IntersectionObserver | null = null

const handleIntersect = (entries: IntersectionObserverEntry[]) => {
  if (entries[0].isIntersecting) {
    conventionStore.nextConventions()
  }
}

onMounted(() => {
  observer = new IntersectionObserver(handleIntersect)
  observer.observe(loadMore.value)
})

onBeforeUnmount(() => {
  if (observer) {
    observer.disconnect()
  }
})
conventionStore.resetConventions()
</script>

<style scoped>
.list-box {
  width: 100%;
}

table {
  font-size: 1.2em;
  width: 100%;
  border-collapse: collapse;
  border-radius: 5px;
  overflow: hidden;
}

thead {
  font-weight: bold;
  color: #fff;
  background: #73685d;
}

td,
th {
  padding: 1em 1em;
  vertical-align: middle;
  text-align: center;
}

th {
  background-color: rgb(193, 232, 197);
  color: black;
}
.icon-box {
  width: 36px;
  height: 36px;
}
.icon-th {
  width: 36px;
}
.flag-box {
  width: 64px;
  height: 48px;
}
.code-box {
  flex-grow: 1;
}
</style>
