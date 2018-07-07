package com.headshow.controller.sys;

import com.headshow.common.utils.apiresult.AbstractApiResult;
import com.headshow.entity.dto.FormModuleDTO;
import com.headshow.entity.vo.FormModuleVO;
import com.headshow.service.formmanager.FormModuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @desc 表单模块Controller
 * @author linlangleo
 * @date 2018-04-22 20:28
 **/
@RestController
@Api(value = "sap", tags = {"sys"})
@RequestMapping("/formmanager/module")
public class FormModuleController {
    @Resource
    private FormModuleService formModuleService;

    /**
     * 保存模块信息
     */
    @ApiOperation(value = "保存模块信息", produces = "application/json")
    @RequestMapping(value = "/savemodule", method = RequestMethod.POST)
    public AbstractApiResult saveModule(@RequestBody FormModuleDTO formModule) {
        String result = formModuleService.saveModule(formModule);

        return AbstractApiResult.success(result);
    }

    /**
     * 获取所有的模块信息
     */
    @ApiOperation(value = "获取所有的模块信息", produces = "application/json")
    @RequestMapping(value = "/getallmodule", method = RequestMethod.POST)
    public AbstractApiResult getAllModule() {
        List<FormModuleVO> formModuleVOList = formModuleService.getAllModule();

        return AbstractApiResult.success(formModuleVOList);
    }

    /**
     * 删除模块信息
     */
    @ApiOperation(value = "删除模块信息", produces = "application/json")
    @RequestMapping(value = "/delmodulebyid/{id}", method = RequestMethod.GET)
    public AbstractApiResult delModuleById(@PathVariable long id) {
        String result = formModuleService.delModuleById(id);

        return AbstractApiResult.success(result);
    }

    /**
     * 修改模块信息
     */
    @ApiOperation(value = "修改模块信息", produces = "application/json")
    @RequestMapping(value = "/updatemodulebyid", method = RequestMethod.POST)
    public AbstractApiResult updateModuleById(@RequestBody FormModuleDTO formModuleDTO) {
        String result = formModuleService.updateModuleById(formModuleDTO);

        return AbstractApiResult.success(result);
    }
}
