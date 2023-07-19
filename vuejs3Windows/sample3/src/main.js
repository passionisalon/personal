import { createApp } from 'vue'
import App from './App.vue'
import mitt from 'mitt'
let emitter = mitt();
let app = createApp(App)

// 자주 쓰는 라이브러리 있으면 여기에 등록하면됨
// app.config.globalProperties.axios = axios;
// 그러면 이제 vue파일에서 import axios 해 올 필요없이 this.axios로 사용가능

app.config.globalProperties.emitter = emitter; // 보관함에 {emitter : emitter} 추가한 것
// 글로벌한 변수보관함임
app.mount('#app')
