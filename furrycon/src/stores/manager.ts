import { createConvention, type RequestConvention } from '@/api/convention'
import { defineStore } from 'pinia'

export const useManagerStore = defineStore('manager', {
  actions: {
    async registerConvention(convention: RequestConvention) {
      await createConvention(convention)
    }
  }
})
