import axios from 'axios'

function createInstance(url: string) {
  return axios.create({
    baseURL: `${import.meta.env.VITE_APP_API_URL}${url}`
  })
}

function createInstanceWithAuth(url: string) {
  const instance = axios.create({
    baseURL: `${import.meta.env.VITE_APP_API_URL}${url}`
  })
  return instance
  // return setInterceptors(instance);
}

function createDefaultInstance() {
  const instance = axios.create({
    baseURL: `${import.meta.env.VITE_APP_API_URL}`
  })
  return instance
}

export const instance = createDefaultInstance()
