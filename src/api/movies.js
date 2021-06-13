import request from '@/utils/request'
import config from './config'

export function getHotMovList(query) {
  return request({
    url: config.base + 'movies/gethotmovlist',
    method: 'get',
    params: query
  })
}

export function getMovie(IMDb) {
  return request({
    url: config.base + 'movies/getmovie',
    method: 'get',
    params: IMDb
  })
}
