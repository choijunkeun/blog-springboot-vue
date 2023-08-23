const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  outputDir: '../src/main/resources/static', // Build Directory 설정
  devServer: {
    proxy: {
      '/': {
        target: 'http://localhost',
        changeOrigin: true,
      }
    }
  },
  lintOnSave: false,
})
