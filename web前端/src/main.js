// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import routers from './routers'
import ElementUI from 'element-ui'
import VueRouter from 'vue-router'
import animate from 'animate.css'
import Vuex from 'vuex'
import axios from 'axios';
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
Vue.prototype.$axios = axios;
Vue.use(Vuex)
Vue.use(ElementUI)
Vue.use(VueRouter)
Vue.config.productionTip = false

const global_='123'
Vue.prototype.top = global_

const store = new Vuex.Store({
  state: {
    count: 0,
    account: '0',
    phonenumber:'0',
    password:'asd',
    balance:0 ,
    credit_score:0,
    state:0,
    id: 0,
    house_id:0,
    isadmin:0,
     
  },
  mutations: {
  	increment: state => state.count++,
    decrement: state => state.count--,
    change(state,b){
      state.account = b[0],
      state.idcard = b[1],
      state.password = b[2],
      state.balance = b[3],
      state.id =b[4],
      state.isadmin =b[5]
    },
    change_house(state,house_id){
state.house_id=house_id;
    }
  }
})

const router = new VueRouter({
  mode: 'history',
  routes: routers
})
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  top,
  render: h => h(App),
})