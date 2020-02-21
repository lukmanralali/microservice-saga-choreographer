'use strict'
const {producer} = require('../../utility/rabbitmq')

module.exports.load = () => {
    // for(var i=0;i<10;i++){
    //     producer.publishToQueue('samplequeue',JSON.stringify({
    //         message: `hallo dunia. dari sample - ${i}`
    //     }))
    //     producer.publishTopic('exchangename','exchange.name',JSON.stringify({
    //         message: `hallo dunia. dari sample - ${i}`
    //     }))
    // }
}