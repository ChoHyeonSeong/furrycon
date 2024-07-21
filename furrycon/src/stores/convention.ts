import { readConventions, type ResponseConvention } from '@/api/convention'
import { defineStore } from 'pinia'
import Papa from 'papaparse'

async function loadCSV() {
  const countryMap = new Map<string, string>()
  try {
    const response = await fetch(require('@/assets/countryData.csv'))
    const csvText = await response.text()
    Papa.parse(csvText, {
      header: true,
      dynamicTyping: true,
      complete: (results: any) => {},
      error: (error: any) => {
        console.error('Error parsing CSV:', error)
      }
    })
  } catch (error) {
    console.error('Error loading CSV:', error)
  }
  return countryMap
}

function padTo2Digits(num: number) {
  return num.toString().padStart(2, '0')
}
function formatDate(date: Date) {
  return [date.getFullYear(), padTo2Digits(date.getMonth() + 1), padTo2Digits(date.getDate())].join(
    '-'
  )
}
export const useConventionStore = defineStore('convention', {
  state: () => ({
    pageNum: -1,
    countryCode: '',
    startDate: formatDate(new Date()),
    endDate: formatDate(new Date(64000000000000)),
    confirmedLocation: false,
    conventions: [] as ResponseConvention[]
  }),
  actions: {
    async nextConventions() {
      this.pageNum++
      const { data } = await readConventions(
        this.pageNum,
        this.countryCode,
        this.startDate,
        this.endDate,
        this.confirmedLocation
      )
      this.conventions = data.content
    },
    setCountryCodeFilter(countryCode: string) {
      this.countryCode = countryCode
      this.resetConventions()
    },
    setScheduleFilter(startDate: string, endDate: string) {
      this.startDate = startDate
      this.endDate = endDate
      this.resetConventions()
    },
    setConfirmedLocationFilter(confirmedLocation: boolean) {
      this.confirmedLocation = confirmedLocation
      this.resetConventions()
    },

    resetCountryCodeFilter() {
      this.setCountryCodeFilter('')
    },
    resetScheduleFilter() {
      this.setScheduleFilter(formatDate(new Date()), formatDate(new Date(64000000000000)))
    },

    resetConventions() {
      this.pageNum = -1
      this.nextConventions()
    }
  }
})
