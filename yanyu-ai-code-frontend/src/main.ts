import { createApp } from 'vue'
import { createPinia } from 'pinia'
import App from './App.vue'
import router from './router'

// Ant Design Vue 相关导入
import Antd from 'ant-design-vue'
import 'ant-design-vue/dist/reset.css'
import zhCN from 'ant-design-vue/es/locale/zh_CN' // 中文语言包
import dayjs from 'dayjs'
import 'dayjs/locale/zh-cn' // 中文日期本地化

// 配置 dayjs 使用中文
dayjs.locale('zh-cn')

const app = createApp(App)

// 使用 Pinia 和路由
app.use(createPinia())
app.use(router)

// 使用 Ant Design Vue 并配置国际化
app.use(Antd)

// 全局注入 Ant Design 的国际化配置（可选）
app.provide('antdLocale', zhCN) // 通过 provide/inject 共享配置

app.mount('#app')
