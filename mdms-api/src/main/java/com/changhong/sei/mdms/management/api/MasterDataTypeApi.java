package com.changhong.sei.mdms.management.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.BaseTreeApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.mdms.management.dto.MasterDataTypeDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * 主数据分类(MasterDataType)API
 *
 * @author sei
 * @since 2020-08-13 22:47:14
 */
@Valid
@FeignClient(name = "mdms", path = "masterDataType")
public interface MasterDataTypeApi extends BaseEntityApi<MasterDataTypeDto>, BaseTreeApi<MasterDataTypeDto> {

    /**
     * 获取主数据分类的树
     *
     * @return 获取主数据分类的树
     */
    @GetMapping(path = "getTypeTree")
    @ApiOperation(value = "获取主数据分类的树", notes = "获取主数据分类的树")
    ResultData<List<MasterDataTypeDto>> getTypeTree();

    /**
     * 根据代码获取一个节点的树
     *
     * @param code 节点code
     * @return 节点树
     */
    @GetMapping(path = "getTreeByCode")
    @ApiOperation(value = "根据代码获取一个节点的树", notes = "根据代码获取一个节点的树")
    ResultData<MasterDataTypeDto> getTreeByCode(@RequestParam("code") String code);
}