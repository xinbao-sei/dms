package com.changhong.sei.dms.general.api;

import com.changhong.sei.core.api.*;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.dms.general.dto.CorporationDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 实现功能: 公司API接口
 *
 * @author 王锦光 wangjg
 * @version 2020-01-26 16:16
 */
@FeignClient(name = "dms", path = "corporation")
public interface CorporationApi extends BaseEntityApi<CorporationDto>,
        FindByPageApi<CorporationDto>,
        FindAllApi<CorporationDto> {
    /**
     * 根据公司代码查询公司
     *
     * @param code 公司代码
     * @return 公司
     */
    @GetMapping(path = "findByCode")
    @ApiOperation(value = "根据公司代码查询公司", notes = "根据公司代码查询公司")
    ResultData<CorporationDto> findByCode(@RequestParam("code")String code);

    /**
     * 根据ERP公司代码查询公司
     *
     * @param erpCode ERP公司代码
     * @return 公司
     */
    @GetMapping(path = "findByErpCode")
    @ApiOperation(value = "根据ERP公司代码查询公司", notes = "根据ERP公司代码查询公司")
    ResultData<List<CorporationDto>> findByErpCode(@RequestParam("erpCode") String erpCode);
}
