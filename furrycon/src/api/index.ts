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

export const user = createInstance('user')
export const vark = createInstanceWithAuth('vark')
export const account = createInstanceWithAuth('account')
export const notify = createInstanceWithAuth('notify')
export const receiver = createInstanceWithAuth('receiver')
export const defaultInst = createDefaultInstance()
