const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  outputDir: '../src/main/resources/static', // Build Directory 설정
  devServer: {proxy: 'http://localhost'},    // Spring boot Server 설정
  lintOnSave: false,

})
