import request from '@/utils/request'
import config from './config'

export function getHotMovList(query) {
  return request({
    url: config.base + 'movies/gethotmovlist',
    method: 'GET',
    params: query
  })
}

export function getMovie(IMDb) {
  return request({
    url: config.base + 'movies/getmovie',
    method: 'GET',
    params: IMDb
  })
}
