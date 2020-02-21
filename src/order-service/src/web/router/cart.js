'use strict'
const {cart} = require('./../controller')

const base_path = '/api/v1/cart'
module.exports = (app) => {
    
    app.get(base_path+'/', cart.getChart)
    app.post(base_path+'/', cart.postAddToChart)
}
