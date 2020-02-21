const { readdirSync } = require('fs')

module.exports.start = () => {
    readdirSync('./src/daemon', { withFileTypes: true })
    .filter(dir => dir.isDirectory())
    .map(dir => dir.name)
    .forEach(module=>{
        try {
            require(`./${module}`).load()
        } catch(err) {
            console.error(err)
            console.warn(`cannot load module ${module}. it might be cause malfunction to your application`)
        }
    })
}