package com.headshow.controller.sys;

import com.headshow.common.utils.apiresult.AbstractApiResult;
import com.headshow.service.formmanager.FormManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 表单管理controller
 * @by linlangleo
 */
@RestController
@Api(value = "sap", tags = {"sys"})
@RequestMapping("/formmanager")
public class FormManagerController {
    @Resource
    private FormManagerService formManagerService;

    /**
     * 根据传进来的 流程Id，节点Id 获取对应的页面名称
     */
    @RequestMapping(value = "/getpageofnode/{processId}/{nodeId}", method = RequestMethod.GET)
    @ApiOperation(value = "传流程Id，节点Id 获取对应的页面", produces = "application/json")
    public AbstractApiResult getPageOfNode(@PathVariable String processId, @PathVariable String nodeId){

        //获取页面名称
        String pageName = formManagerService.getPageOfNode(processId, nodeId);

        return AbstractApiResult.success(pageName);
    }
}
