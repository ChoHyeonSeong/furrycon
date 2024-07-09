<template>
  <div class="list-box">
    <table class="full-width">
      <thead>
        <tr>
          <th>Schedule</th>
          <th>Country</th>
          <th>Convention</th>
          <th>Location</th>
          <th>Homepage</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>02/22/2025 - 02/23/2025</td>
          <td>kor</td>
          <td>FurryJoa</td>
          <td>FurryJoaLocation</td>
          <td><home-icon class="icon-box" /></td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script setup lang="ts">
import HomeIcon from '@/components/icons/HomeIcon.vue'
import FlagIcon from '@/components/icons/FlagIcon.vue'
import ScheduleIcon from '@/components/icons/ScheduleIcon.vue'
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
  padding: 1em 0.5em;
  vertical-align: middle;
  text-align: center;
}

th {
  background-color: rgb(193, 232, 197);
  color: black;
}
.icon-box {
  width: 2em;
  height: 2em;
  margin: 10px;
}
</style>
