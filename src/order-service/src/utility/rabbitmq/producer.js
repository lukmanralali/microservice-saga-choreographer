'use strict'
require('dotenv').config()
const amqp = require('amqplib')

const createConnection = async () => {
    const connection = await amqp.connect(`amqp://${process.env.BROKER_URL}`)
    const channel = await connection.createChannel()
    return {connection, channel}
}
const publishToQueue = async (queueName, message) => { 
    try{
        const { connection, channel } = await createConnection()
        await channel.assertQueue(queueName, { durable: false }) 
        await channel.sendToQueue(queueName, Buffer.from(message),{
            persistent: true
        })
        console.debug(`[sent] ${queueName}: ${message}`)
        await channel.close()
        await connection.close()
    }catch(err){
        console.warn(err)
    }
}

const publishTopic = async (exchange, topic, message) => {
    try{
        const { connection, channel } = await createConnection()
        broadcast({ exchange, topic, message }, channel, connection)
    }catch(err){
        console.warn(err)
    }
}

const publishFanout = async (exchange, message) => {
    try{
        const { connection, channel } = await createConnection()
        broadcast({ exchange, topic:'', message }, channel, connection)
    }catch(err){
        console.warn(err)
    }
}

const broadcast = (payload, channel, connection) => {
    const {exchange, topic, message} = payload
    const actionType = (topic.length === 0)? 'fanout' : 'topic'
    channel.assertExchange(exchange, actionType, {
        durable: false
    })
    channel.publish(exchange, topic, Buffer.from(message));
    console.debug(`[sent] ${exchange} | ${topic} : ${message}`)
    setTimeout(() => { 
        channel.close()
        connection.close()
    }, 500)
}

module.exports = {
    publishToQueue,
    publishTopic,
    publishFanout
}