'use strict'

const getChart = (req, res) => {
    res.send({
        message: 'get cart data'
    })
}

const postAddToChart = (req, res) => {
    res.send({
        message: 'add to chart'
    })
}

module.exports = {
    getChart,
    postAddToChart
}