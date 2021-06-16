import request from '@/utils/request'
import config from './config'

export function getHotMovList(query) {
  return request({
    url: config.base + 'movies/gethotmovlist',
    method: 'GET',
    params: { query }
  })
}

export function getMovie(IMDb) {
  return request({
    url: config.base + 'movies/getmovie',
    method: 'GET',
    params: { IMDb }
  })
}

// 标记想看
export function addIntention(userId, IMDb) {
  return request({
    url: config.base + 'intention',
    method: 'POST',
    params: { userId, IMDb }
  })
}

// 删除想看
export function deleteIntention(userId, IMDb) {
  return request({
    url: config.base + 'intention/delete',
    method: 'DELETE',
    params: { userId, IMDb }
  })
}

// 标记看过
export function addWatched(userId, IMDb, rate, srContent) {
  return request({
    url: config.base + 'shortreview',
    method: 'POST',
    params: { userId, IMDb, rate, srContent }
  })
}

export function getShortComment(IMDb) {
  return request({
    url: config.base + 'shortreview/getsrbyIMDb',
    method: 'GET',
    params: { IMDb }
  })
}

export function addLikeShortComment(ownerId, IMDb, userId) {
  return request({
    url: config.base + 'srlike',
    method: 'POST',
    params: { ownerId, IMDb, userId }
  })
}

export function getArtistInfo(IMDb) {
  return request({
    url: config.base + 'artists/getartist',
    method: 'GET',
    params: { IMDb }
  })
}

export function getIntentionList(userId) {
  return request({
    url: config.base + 'intention/showuserintention',
    method: 'GET',
    params: { userId }
  })
}

export function getWatchedList(userId) {
  return request({
    url: config.base + 'intention/showuserintention',
    method: 'GET',
    params: { userId }
  })
}

export function checkLike(ownerId, IMDb, userId) {
  return request({
    url: config.base + 'srlike/hasliked',
    method: 'GET',
    params: { ownerId, IMDb, userId }
  })
}

export function checkIntention(IMDb, userId) {
  return request({
    url: config.base + 'intention/hasintention',
    method: 'GET',
    params: { IMDb, userId }
  })
}

export function checkWatched(IMDb, userId) {
  return request({
    url: config.base + 'haswatched',
    method: 'GET',
    params: { IMDb, userId }
  })
}

