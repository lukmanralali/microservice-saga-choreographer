'use strict'
const {order} = require('./../controller')

const base_path = '/api/v1/order'
module.exports = (app) => {
    
    app.get(base_path+'/', order.getOrderList)
    app.post(base_path+'/', order.postCreateOrder)
}
