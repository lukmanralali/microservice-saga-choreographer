require('dotenv').config()
const express = require('express')
const bodyParser = require('body-parser')
const { readdirSync } = require('fs')
const app = express()
const cors = require('cors')
/* set middleware */
app.use(cors())
app.use(bodyParser.json())
app.use(bodyParser.urlencoded({ extended: true }))

/* register router */
readdirSync('./src/web/router', { withFileTypes: true })
.filter(dir => !dir.isDirectory())
.map(file => file.name)
.filter(fileName => fileName.substr(fileName.lastIndexOf('.') + 1)==='js')
.forEach(module=>{
    try {
        require(`./router/${module}`)(app)
    } catch(err) {
        console.warn(`Cannot load router ${module}. it might be cause malfunction to your application`)
    }
})

/* create server */
const server = require('http').createServer(app) 

/* runing our server */
module.exports.start = () => {
    const PORT = process.env.PORT || process.env.APP_PORT || 3000
    server.listen(PORT, () => {
        console.log(`Express Server Now Running. port: ${PORT}`)
    })
}