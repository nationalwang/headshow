import PowerForm from '../views/Power/PowerForm'
import PowerEdit from '@/views/Power/PowerEdit'
import PowerContent from '@/views/Power/PowerContent'
import addPower from '@/views/Power/addPower'

export default [
  {
    path: '/Power/PowerForm',
    component: PowerForm,
    meta: {
      label: '表单权限管理'
    },
    children: [
      {
		path: '/Power/PowerForm/PowerContent',
		name: 'PowerForm',
        component: PowerContent,
        meta: {
          label: '管理权限编辑'
        }
	  },
	  {
		path: '/Power/PowerForm/PowerEdit',
		name: 'PowerEdit',
        component: PowerEdit,
        meta: {
          label: '编辑管理权限'
        }
	  },
	  {
		path: '/Power/PowerForm/addPower',
		name: 'addPower',
        component: addPower,
        meta: {
          label: '添加管理标签'
        }
	  }
    ]
  }
]
