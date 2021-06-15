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

// 标记想看
export function addIntention(userId, IMDb) {
  return request({
    url: config.base + 'intention',
    method: 'POST',
    params: userId, IMDb
  })
}

// 删除想看
export function deleteIntention(userId, IMDb) {
  return request({
    url: config.base + 'intention/delete',
    method: 'DELETE',
    params: userId, IMDb
  })
}

