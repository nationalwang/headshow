import { TABS_NAV_LIST } from '../../mutation-types'

const state = {
  list: {
    tabsList: [{ label: '首页', name: 'Home' }],
    value: 'Home'
  }
}

const mutations = {
  [TABS_NAV_LIST] (state, {tabsList, value}) {
    state.list.tabsList = tabsList
    state.list.value = value
  }
}

const actions = {
  getList: ({commit}, {type, name, obj, index}) => {
    let data = state.list.tabsList
    if (type === 'ADD') {
      data = obj
    } else if (type === 'DETELE') {
      data = data.filter(tab => tab.name !== name)
    }
    commit(TABS_NAV_LIST, {
      tabsList: data,
      value: index
    })
  }
}

export default {
  namespaced: true,
  state: state,
  mutations: mutations,
  actions: actions
}
