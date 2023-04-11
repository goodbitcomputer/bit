const {defineConfig} = require('@vue/cli-service')
module.exports = defineConfig({
    chainWebpack: config => {
        config.plugins.delete('prefetch');
    },
    outputDir: "../src/main/resources/static",
    devServer: {
        proxy: {
            '/api': {
                target: 'http://localhost:8080/',
                changeOrigin: true
            }
        }
    },
});