<template>
  <div class="dropdown">
    <input
      type="text"
      id="searchInput"
      placeholder="Search..."
      v-model="searchCountry"
      @focus="show"
      @blur="hide"
      @keyup="countryFilter"
    />
    <div id="dropdown" class="dropdown-content">
      <!-- 검색 결과가 여기 나타납니다 -->
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
const searchCountry = ref('')
const clickSearch = ref('false')

function show() {
  console.log('show')
  if (searchCountry.value != '') {
    console.log(searchCountry.value)
  } else {
    console.log('all')
  }
}

function hide() {
  console.log('hide')
}

function countryFilter() {
  if (searchCountry.value != '') {
    console.log(searchCountry.value)
  } else {
    console.log('all')
  }
}
// // 검색 입력 필드와 드롭다운 요소를 가져오기
// const searchInput = document.getElementById('searchInput')
// const dropdown = document.getElementById('dropdown')

// // 검색 결과를 필터링하는 함수
// function filterFunction() {
//   const filter = searchInput.value.toUpperCase()
//   dropdown.innerHTML = '' // 기존 검색 결과 초기화

//   if (filter) {
//     const filteredData = data.filter((item) => item.toUpperCase().includes(filter))

//     filteredData.forEach((item) => {
//       const div = document.createElement('div')
//       div.textContent = item
//       dropdown.appendChild(div)
//     })

//     if (filteredData.length > 0) {
//       dropdown.classList.add('show')
//     } else {
//       dropdown.classList.remove('show')
//     }
//   } else {
//     dropdown.classList.remove('show')
//   }
// }

// // 검색 결과를 클릭했을 때 입력 필드에 값 설정
// dropdown.addEventListener('click', function (event) {
//   if (event.target.tagName === 'DIV') {
//     searchInput.value = event.target.textContent
//     dropdown.classList.remove('show')
//   }
// })

// // 입력 필드 외부를 클릭했을 때 드롭다운 숨기기
// document.addEventListener('click', function (event) {
//   if (!event.target.matches('#searchInput')) {
//     dropdown.classList.remove('show')
//   }
// })
</script>

<style scoped>
.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
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

.show {
  display: block;
}
</style>
