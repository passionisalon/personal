// const { defineConfig } = require('@vue/cli-service')
// module.exports = defineConfig({
//   transpileDependencies: true
// })

// 개발 할 때 사용 할 수 있지만, 운영하는 부분에 있어서는 사용할 수 없다. 
// 이것을 잘 참고해야한다.!
const target = 'http://localhost:8080'
module.exports = {
  devServer:{
    prot:8080,
    proxy: {
      '^/api': {
        target,changeOrigin:true
      }
    }
  }

}