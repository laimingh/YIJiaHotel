module.exports={
  publicPath: '/' +
    '',
  devServer: {
    port: '8080',
    proxy: {
      "/": {
        target: 'http://127.0.0.1:8080'

      },
    },
  },
}
