import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home'
import configManage from './configManage'
import PowerForm from './PowerForm'
import interfaceManage from './interfaceManage'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    ...generateRoutesFromRoutesFile([
      ...configManage,
      ...PowerForm,
      ...interfaceManage
    ]),
    {
      path: '*',
      redirect: '/'
    }
  ]
})

function generateRoutesFromRoutesFile (files, routes = []) {
  for (let i = 0; i < files.length; i++) {
    let item = files[i]
    if (item.path) {
      routes.push(item)
    }
  }
  return routes
}
