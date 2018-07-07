import ProcessManage from '../views/ConfigManage/ProcessManage'
import DataManage from '../views/ConfigManage/DataManage'
import FormConfig from '../views/ConfigManage/FormConfig'

export default [
  {
    name: 'ProcessManage',
    path: '/ConfigManage/ProcessManage',
    component: ProcessManage,
    meta: {
      label: '表单配置'
    }
  },
  // {
  //   name: 'DataManage',
  //   path: '/ConfigManage/DataManage',
  //   component: DataManage,
  //   meta: {
  //     label: '元数据管理'
  //   }
  // },
  // {
  //   name: 'FormConfig',
  //   path: '/ConfigManage/FormConfig',
  //   component: FormConfig,
  //   meta: {
  //     label: '动态表单配置'
  //   }
  // }
]
