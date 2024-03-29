import request from '@/utils/request'

const URL = 'code'


export function getOrder(data) {

  return request({
      responseType: 'blob',

    url: URL + '',
    method: 'get',
    data: {
      data: data
    }
  })
}

export function addOrder(data) {
  return request({
    url: URL + '',
    method: 'post',
    data: data
  })
}

export function delOrder(data) {
  return request({
    url: URL + '/delete',
    method: 'post',
    data: {
      typeId: data
    }
  })
}

export function canceltuifang(id) {
  return request({
    url: URL + '/cancel',
    method: 'post',
    data: {
      orderId: id
    }
  })
}



export function cancelOrder(id) {
  return request({
    url: URL + '/cancel',
    method: 'post',
    data: {
      orderId: id
    }
  })
}

export function updateOrder(id,status) {
  return request({
    url: URL + '/update',
    method: 'post',
    data: {
      orderId: id,
      orderStatus: status
    }
  })
}

export function payOrder(id,username,password) {
  return request({
    url: URL + '/pay',
    method: 'post',
    data: {
      orderId: id,
      username:username,
      password: password
    }
  })
}

export function getOrderByUserId(data) {
  return request({
    url: URL + '/userOrder',
    method: 'post',
    data: {
      userId: data
    }
  })
}


export function getOrderById(data) {
  return request({
    url: URL + '/'+data,
    method: 'post',
    data: {
      // orderId: data
    }
  })
}
// 删除订单
export function deleteOrderById(id){
  return request({
    url: URL + '/delete',
    method: 'post',
    data: {
      orderId: id
    }
  })
}

// export function del(roomId) {
//   return request({
//     url: URL + '/delete',
//     method: 'post',
//     data: {
//       roomId
//     }
//   })
// }
