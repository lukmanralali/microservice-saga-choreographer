'use strict'
require('dotenv').config()
const amqp = require('amqplib/callback_api')

const createConnection = async () => {
    const connection = await amqp.connect(`amqp://${process.env.BROKER_URL}`)
    const channel = await connection.createChannel()
    return {connection, channel}
}
const listenToQueue = async (queueName, handler) => { 
    try{
        const { channel } = await createConnection()
        await channel.assertQueue(queueName, { durable: false }) 
        channel.consume(queue, handler, {
              noAck: true
        })
    }catch(err){
        console.warn(err)
    }
}

const listenTopic = async (exchange, topic, message) => {
    try{
        const { channel } = await createConnection()
        const {exchange, topic, message} = payload
        const actionType = (topic.length === 0)? 'fanout' : 'topic'
        channel.assertExchange(exchange, actionType, {
            durable: false
        })
        channel.assertQueue('', { exclusive: true }, function(error2, q) {
            if (error2) {
                throw error2;
            }
            console.log(' [*] Waiting for logs. To exit press CTRL+C');

            args.forEach(function(key) {
                channel.bindQueue(q.queue, exchange, key);
            });

            channel.consume(q.queue, function(msg) {
            console.log(" [x] %s:'%s'", msg.fields.routingKey, msg.content.toString());
        }, { noAck: true })
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
    listenToQueue
}