import client from './client.js'

class ConfigManage {

  // 获取所有的模块信息
  getModuleList () {
    return client.request('/formmanager/module/getallmodule', {}, {
      method: 'post'
    })
  }

  // 根据模块ID获取流程信息
  getProcessList (id) {
    return client.request('/formmanager/flow/getflowbymoduleid/' + id)
  }

  // 根据ID获取流程信息
  getProcessDetail (id) {
    return client.request('/formmanager/flow/getflowbyid/' + id)
  }

  // 根据流程ID，获取节点信息
  getNodeList (id) {
    return client.request('/formmanager/node/getnodebyflowid/' + id)
  }

  // 保存模块信息
  saveModule (data) {
    return client.request('/formmanager/module/savemodule?module_code='+data.module_code+'&module_name='+data.module_name, {}, {
      method: 'post'
    })
  }

  // 删除模块信息
  delmodulebyid (id) {
    return client.request('/formmanager/module/delmodulebyid/'+id, {}, {
      method: 'post'
    })
  }

  // 保存流程信息
  saveflow (data) {
    return client.request('/formmanager/flow/saveflow?module_id='+data.module_id+'&flow_name='+data.flow_name+'&k2_process_code='+data.k2_process_code, {}, {
      method: 'post'
    })
  }

  // 删除流程信息
  delflowbyid (id) {
    return client.request('/formmanager/flow/delflowbyid/'+id, {}, {
      method: 'post'
    })
  }

  // 保存节点信息
  savenode (data) {
    return client.request('/formmanager/node/savenode?k2_process_id='+data.k2_process_id+'&k2_node_id='+data.k2_node_id+'&node_pagename='+data.node_pagename, {}, {
      method: 'post'
    })
  }

  // 删除节点信息
  delnodebyid (id) {
    return client.request('/formmanager/node/delnodebyid/'+id, {}, {
      method: 'post'
    })
  }
}

const configManage = new ConfigManage()

export default configManage