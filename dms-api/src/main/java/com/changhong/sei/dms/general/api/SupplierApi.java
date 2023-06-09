package com.changhong.sei.dms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.dms.general.dto.SupplierCorporationDto;
import com.changhong.sei.dms.general.dto.SupplierDto;
import com.changhong.sei.dms.general.dto.search.ErpCodeQuickSearchParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 供应商(Supplier)API
 *
 * @author sei
 * @since 2021-05-06 14:07:50
 */
@Valid
@FeignClient(name = "dms", path = SupplierApi.PATH)
public interface SupplierApi extends BaseEntityApi<SupplierDto>, FindByPageApi<SupplierDto> {
    String PATH = "supplier";

    /**
     * 获取供应商的公司信息
     *
     * @param supplierId 供应商Id
     * @return 公司信息
     */
    @GetMapping(path = "getCorporationInfo")
    @ApiOperation(value = "获取供应商的公司信息", notes = "获取供应商的公司信息")
    ResultData<List<SupplierCorporationDto>> getCorporationInfo(@RequestParam("supplierId") String supplierId);

    /**
     * 保存供应商的公司信息
     *
     * @param dto 供应商的公司信息DTO
     * @return 操作结果
     */
    @PostMapping(path = "saveCorporationInfo", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "保存供应商的公司信息", notes = "保存供应商的公司信息")
    ResultData<SupplierCorporationDto> saveCorporationInfo(@RequestBody @Valid SupplierCorporationDto dto);

    /**
     * 删除供应商的公司信息
     *
     * @param id 供应商的公司信息Id
     * @return 操作结果
     */
    @DeleteMapping(path = "deleteCorporationInfo/{id}")
    @ApiOperation(value = "删除供应商的公司信息", notes = "删除供应商的公司信息")
    ResultData<?> deleteCorporationInfo(@PathVariable("id") String id);

    /**
     * 分页查询供应商的公司信息
     *
     * @param search 查询参数
     * @return 查询结果
     */
    @PostMapping(path = "findCorporationInfoByPage", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "分页查询供应商的公司信息", notes = "分页查询供应商的公司信息")
    ResultData<PageResult<SupplierCorporationDto>> findCorporationInfoByPage(@RequestBody Search search);

    /**
     * 根据代码查询供应商
     *
     * @param code 供应商代码
     * @return 供应商
     */
    @GetMapping(path = "findByCode")
    @ApiOperation(value = "根据代码查询供应商", notes = "根据代码查询供应商")
    ResultData<SupplierDto> findByCode(@RequestParam("code") String code);

    /**
     * 分页查询供应商主数据
     *
     * @param searchParam 查询参数
     * @return 分页查询结构
     */
    @PostMapping(path = "search", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "分页查询供应商主数据", notes = "分页查询供应商主数据，限定ERP公司代码")
    ResultData<PageResult<SupplierDto>> search(@RequestBody ErpCodeQuickSearchParam searchParam);

    /**
     * 根据名称查询供应商主数据
     * @param name 名称
     * @return 供应商主数据集合
     */
    @PostMapping(path = "findByName", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "根据名称查询供应商主数据", notes = "根据名称查询供应商主数据")
    ResultData<List<SupplierDto>> findByName(@RequestParam("name") String name);
}