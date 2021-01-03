import Vue from 'vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import App from './App.vue'
import VueRouter from 'vue-router'
import actor from './components/Actor.vue'
import catalog from './components/Catalog.vue'
import comment from './components/Comment.vue'
import director from './components/Director.vue'
import multi from './components/Multi.vue'
import relation from './components/Relation.vue'
import time from './components/Time.vue'
import title from './components/Title.vue'
import visual from './components/Visual.vue'
import popular from './components/Popular.vue'
import axios from 'axios'

Vue.use(axios)
Vue.use(VueRouter)
Vue.use(ElementUI)
Vue.prototype.root = 'http://localhost:8018'

const routes = [{
    path: '/visual',
    component: visual
  },
  {
    path: '/actor',
    component: actor
  },
  {
    path: '/catalog',
    component: catalog
  },
  {
    path: '/comment',
    component: comment
  },
  {
    path: '/director',
    component: director
  },
  {
    path: '/multi',
    component: multi
  },
  {
    path: '/relation',
    component: relation
  },
  {
    path: '/time',
    component: time
  },
  {
    path: '/title',
    component: title
  },
  {
    path: '/popular',
    component: popular
  }
]

const router = new VueRouter({
  routes // (缩写) 相当于 routes: routes
})
new Vue({
  el: '#app',
  router,
  render: h => h(App)
})