import Vue from 'vue'
import Vuex from 'vuex'

import * as actions from './actions'
import * as getters from './getters'

import tabs from './modules/tabs'

Vue.use(Vuex)

const store = new Vuex.Store({
  strict: true,
  actions,
  getters,
  modules: {
    tabs
  },
  state: {
  },
  mutations: {
  }
})

export default store
