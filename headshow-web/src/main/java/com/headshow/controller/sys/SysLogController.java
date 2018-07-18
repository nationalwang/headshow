package com.headshow.controller.sys;

import com.headshow.common.utils.apiresult.AbstractApiResult;
import com.headshow.common.utils.page.PageParam;
import com.headshow.common.utils.page.PageResult;
import com.headshow.entity.dto.AddLogInterfaceDTO;
import com.headshow.entity.dto.DelLogInterfaceDTO;
import com.headshow.entity.dto.GetLogInterfaceKeyWordDTO;
import com.headshow.entity.dto.UpdateLogInterfaceDTO;
import com.headshow.service.log.SysLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 系统controller
 */
@RestController
@Api(value = "sap", tags = {"sys"})
@RequestMapping(value = "/sys/log")
public class SysLogController {

    @Resource
    SysLogService sysLogService;

    /**
     * 在日志中新增接口
     */
    @RequestMapping(value = "/addinterface", method = RequestMethod.POST)
    @ApiOperation(value = "在日志中新增接口", produces = "application/json")
    public AbstractApiResult addInterface(@RequestBody AddLogInterfaceDTO addLogInterfaceDTO) {
        sysLogService.addInterface(addLogInterfaceDTO);
        return AbstractApiResult.success("success");
    }

    /**
     * 在日志中删除接口
     */
    @RequestMapping(value = "/deleteinterfacebyid", method = RequestMethod.DELETE)
    @ApiOperation(value = "在日志中删除接口以及对应所有记录", produces = "application/json")
    public AbstractApiResult deleteInterfaceById(@RequestBody DelLogInterfaceDTO delLogInterfaceDTO) {
        sysLogService.deleteInterfaceById(delLogInterfaceDTO);
        return AbstractApiResult.success("success");
    }

    /**
     * 根据id修改接口信息
     */
    @RequestMapping(value = "/updateinterfacebyid", method = RequestMethod.PUT)
    @ApiOperation(value = "在日志中修改接口", produces = "application/json")
    public AbstractApiResult updateInterfaceById(@RequestBody UpdateLogInterfaceDTO updateLogInterfaceDTO) {
        sysLogService.updateInterfaceById(updateLogInterfaceDTO);
        return AbstractApiResult.success("success");
    }

    /**
     * 根据条件查询接口
     */
    @RequestMapping(value = "/getinterfacelist", method = RequestMethod.POST)
    @ApiOperation(value = "查看日志接口列表", produces = "application/json")
    public AbstractApiResult getInterfaceList(@RequestBody GetLogInterfaceKeyWordDTO getLogInterfaceKeyWordDTO, @ModelAttribute PageParam pageParam) {
        PageResult pageResult = sysLogService.getInterfaceList(getLogInterfaceKeyWordDTO, pageParam);
        return AbstractApiResult.success(pageResult);
    }
}
