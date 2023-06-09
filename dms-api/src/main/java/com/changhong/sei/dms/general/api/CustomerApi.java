package com.changhong.sei.dms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.dms.general.dto.CustomerCorporationDto;
import com.changhong.sei.dms.general.dto.CustomerDto;
import com.changhong.sei.dms.general.dto.search.ErpCodeQuickSearchParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 客户(Customer)API
 *
 * @author sei
 * @since 2021-05-06 13:05:42
 */
@Valid
@FeignClient(name = "dms", path = CustomerApi.PATH)
public interface CustomerApi extends BaseEntityApi<CustomerDto>, FindByPageApi<CustomerDto> {
    String PATH = "customer";


    /**
     * 获取客户的公司信息
     *
     * @param customerId 客户Id
     * @return 公司信息
     */
    @GetMapping(path = "getCorporationInfo")
    @ApiOperation(value = "获取客户的公司信息", notes = "获取客户的公司信息")
    ResultData<List<CustomerCorporationDto>> getCorporationInfo(@RequestParam("customerId") String customerId);

    /**
     * 保存客户的公司信息
     *
     * @param dto 客户的公司信息DTO
     * @return 操作结果
     */
    @PostMapping(path = "saveCorporationInfo", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "保存客户的公司信息", notes = "保存客户的公司信息")
    ResultData<CustomerCorporationDto> saveCorporationInfo(@RequestBody @Valid CustomerCorporationDto dto);

    /**
     * 删除客户的公司信息
     *
     * @param id 客户的公司信息Id
     * @return 操作结果
     */
    @DeleteMapping(path = "deleteCorporationInfo/{id}")
    @ApiOperation(value = "删除客户的公司信息", notes = "删除客户的公司信息")
    ResultData<?> deleteCorporationInfo(@PathVariable("id") String id);


    /**
     * 分页查询客户的公司信息
     *
     * @param search 查询参数
     * @return 查询结果
     */
    @PostMapping(path = "findCorporationInfoByPage", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "分页查询客户的公司信息", notes = "分页查询客户的公司信息")
    ResultData<PageResult<CustomerCorporationDto>> findCorporationInfoByPage(@RequestBody Search search);

    /**
     * 根据代码查询客户
     *
     * @param code 客户代码
     * @return 客户
     */
    @GetMapping(path = "findByCode")
    @ApiOperation(value = "根据代码查询客户", notes = "根据代码查询客户")
    ResultData<CustomerDto> findByCode(@RequestParam("code") String code);

    /**
     * 分页查询客户主数据
     * @param searchParam 查询参数
     * @return 分页查询结果
     */
    @PostMapping(path = "search", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "分页查询客户主数据", notes = "分页查询客户主数据，限定ERP公司代码")
    ResultData<PageResult<CustomerDto>> search(@RequestBody ErpCodeQuickSearchParam searchParam);

    /**
     * 根据名称查询客户主数据
     * @param name 名称
     * @return 客户主数据集合
     */
    @PostMapping(path = "findByName", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "根据名称查询客户主数据", notes = "根据名称查询客户主数据")
    ResultData<List<CustomerDto>> findByName(@RequestParam("name") String name);
}