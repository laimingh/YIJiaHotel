import request from '@/utils/request'

const URL = 'user'

export function userLogin(username, password) {
  return request({
    url:  'login/user',
    method: 'post',
    data: {
      username,
      password
    }
  })
}
export function adminLogin(username, password) {
  return request({
    url:  'login/admin',
    method: 'post',
    data: {
      username,
      password
    }
  })
}
export function getPasswordByIdCard(username,idCard){
  return request({
    url: '/user/queryPassword',
    method: 'post',
    data:{
      username,
      idCard
    }
  })
}
export function userRegister(data) {
  return request({
    url:  '/register/'+URL,
    method: 'post',
    data: data
  })
}

export function getUserInfoByUsername(username) {
  return request({
    url: URL + '/withUsername',
    method: 'post',
    data: {
      username
    }
  })
}

export function getUserInfo() {
  return request({
    url: URL + '/profile',
    method: 'post',
    data: {
      // username
    }
  })
}

export function getUserInfoById(id) {
  return request({
    url: URL + '/withId',
    method: 'post',
    data: {
      userId: id
    }
  })
}
export function updateUserDetail(data) {
  return request({
    url: URL + '/update',
    method: 'post',
    data: data
  })
}

