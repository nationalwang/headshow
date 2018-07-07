import InterfaceList from '../views/InterfaceManage/InterfaceList'
import InterfaceLog from '../views/InterfaceManage/InterfaceLog'
import InterfaceReport from '../views/InterfaceManage/InterfaceReport'
import InterfaceWhiteList from '../views/InterfaceManage/InterfaceWhiteList'

export default [
  {
    name: 'InterfaceList',
    path: '/InterfaceManage/InterfaceList',
    component: InterfaceList,
    meta: {
      label: '接口配置管理'
    },
    children: [
      {
        name: 'InterfaceLog',
        path: '/InterfaceManage/InterfaceLog',
        component: InterfaceLog,
        meta: {
          label: '调用接口日志'
        }
      }
    ]
  },
  {
    name: 'InterfaceWhiteList',
    path: '/InterfaceManage/InterfaceWhiteList',
    component: InterfaceWhiteList,
    meta: {
      label: 'IP白名单管理'
    }
  },
  {
    name: 'InterfaceReport',
    path: '/InterfaceManage/InterfaceReport',
    component: InterfaceReport,
    meta: {
      label: '接口报表'
    }
  }
]