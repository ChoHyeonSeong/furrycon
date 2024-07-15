import { instance } from './index'

function readConventions(
  pageNum: number,
  countryCode?: string,
  startDate?: string,
  endDate?: string,
  confirmedLocation?: boolean
) {
  let queryStr = '?page=' + pageNum
  if (countryCode !== '') queryStr += '&country_code=' + countryCode
  if (startDate && endDate) queryStr += '&start_date=' + startDate + '&end_date=' + endDate
  if (confirmedLocation) queryStr += '&confirmed_location=' + confirmedLocation
  return instance.get('api/convention' + queryStr)
}

function createConvention(convention: RequestConvention) {
  instance.post('api/convention', convention)
}

function testConnection(msg: string) {
  instance.get('api/test?msg=' + msg)
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

export { readConventions, createConvention, testConnection }

export type { RequestConvention, ResponseConvention }
