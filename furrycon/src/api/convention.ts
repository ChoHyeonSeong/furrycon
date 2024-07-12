import { instance } from './index'

function readConventions(
  pageNum: number,
  countryCode?: string,
  startDate?: string,
  endDate?: string,
  confirmedLocation?: boolean
) {
  let queryStr = '?page=' + pageNum
  if (countryCode !== '') queryStr += '&countryCode=' + countryCode
  if (startDate && endDate) queryStr += '&startDate=' + startDate + '&endDate=' + endDate
  if (confirmedLocation) queryStr += '&confirmedLocation=' + confirmedLocation
  return instance.get('convention' + queryStr)
}

function createConvention(convention: RequestConvention) {
  instance.post('convention', convention)
}

interface RequestConvention {
  name: string
  startDate: string
  endDate: string
  countryCode: string
  location?: string
  homepageUrl: string
}

interface ResponseConvention {
  name: string
  startDate: Date
  endDate: Date
  countryCode: string
  location: string
  homepageUrl: string
}

export { readConventions, createConvention }

export type { RequestConvention, ResponseConvention }
