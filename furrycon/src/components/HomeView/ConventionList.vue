<template>
  <div class="list-box">
    <table class="full-width">
      <thead>
        <tr>
          <th>Dates</th>
          <th>Country</th>
          <th>Logo</th>
          <th>Convention</th>
          <th>Location</th>
          <th>Homepage</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>2025.2.22 - 23</td>
          <td>kor</td>
          <td>FurryJoaLogo</td>
          <td>FurryJoa</td>
          <td>FurryJoaLocation</td>
          <td>FurryJoaHomePage</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script setup lang="ts"></script>

<style scoped>
.list-box {
  width: 90%;
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
}

th {
  background-color: rgb(193, 232, 197);
  color: black;
}
</style>
