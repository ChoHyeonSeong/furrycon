import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'
import Vue3CountryIntl from 'vue3-country-intl'
// import css
import 'vue3-country-intl/lib/vue3-country-intl.css'

import App from './App.vue'
import router from './router'

const app = createApp(App)
app.component(Vue3CountryIntl.name, Vue3CountryIntl)

app.use(createPinia())
app.use(router)

app.mount('#app')
