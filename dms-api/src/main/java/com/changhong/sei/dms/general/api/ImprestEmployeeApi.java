package com.changhong.sei.dms.general.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.dms.general.dto.*;
import com.changhong.sei.dms.general.dto.search.ErpCodeQuickSearchParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 备用金员工(ERP)(ImprestEmployee)API
 *
 * @author sei
 * @since 2021-04-20 16:41:17
 */
@Valid
@FeignClient(name = "dms", path = ImprestEmployeeApi.PATH)
public interface ImprestEmployeeApi extends BaseEntityApi<ImprestEmployeeDto>, FindByPageApi<ImprestEmployeeDto> {
    String PATH = "imprestEmployee";


    /**
     * 获取备用金员工的公司信息
     *
     * @param imprestEmployeeId 备用金员工Id
     * @return 公司信息
     */
    @GetMapping(path = "getCorporationInfo")
    @ApiOperation(value = "获取备用金员工的公司信息", notes = "获取备用金员工的公司信息")
    ResultData<List<ImprestEmployeeCorporationDto>> getCorporationInfo(@RequestParam("imprestEmployeeId") String imprestEmployeeId);

    /**
     * 保存备用金员工的公司信息
     *
     * @param dto 备用金员工的公司信息DTO
     * @return 操作结果
     */
    @PostMapping(path = "saveCorporationInfo", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "保存备用金员工的公司信息", notes = "保存备用金员工的公司信息")
    ResultData<ImprestEmployeeCorporationDto> saveCorporationInfo(@RequestBody @Valid ImprestEmployeeCorporationDto dto);

    /**
     * 删除备用金员工的公司信息
     *
     * @param id 备用金员工的公司信息Id
     * @return 操作结果
     */
    @DeleteMapping(path = "deleteCorporationInfo/{id}")
    @ApiOperation(value = "删除备用金员工的公司信息", notes = "删除备用金员工的公司信息")
    ResultData<?> deleteCorporationInfo(@PathVariable("id") String id);
//
//
//    /**
//     * 分页查询备用金员工的公司信息
//     *
//     * @param search 查询参数
//     * @return 查询结果
//     */
//    @PostMapping(path = "findCorporationInfoByPage", consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ApiOperation(value = "分页查询备用金员工的公司信息", notes = "分页查询备用金员工的公司信息")
//    ResultData<PageResult<ImprestEmployeeCorporationDto>> findCorporationInfoByPage(@RequestBody Search search);

    /**
     * 分页查询备用金员工
     *
     * @param searchParam 查询参数
     * @return 分页查询结果
     */
    @PostMapping(path = "search", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "分页查询备用金员工", notes = "分页查询备用金员工，限定ERP公司代码")
    ResultData<PageResult<ImprestEmployeeDto>> search(@RequestBody ErpCodeQuickSearchParam searchParam);

    /**
     * 根据员工编号、ERP公司代码查询备用金员工的公司信息
     *
     * @param personnelCode      员工编号
     * @param erpCorporationCode ERP公司代码
     * @return 查询结果
     */
    @GetMapping(path = "getCorpInfoByPersonnel")
    @ApiOperation(value = "根据员工编号、ERP公司代码查询备用金员工的公司信息", notes = "根据员工编号、ERP公司代码查询备用金员工的公司信息")
    ResultData<ImprestEmployeeCorporationDto> getCorpInfoByPersonnel(@RequestParam("personnelCode") String personnelCode,
                                                                     @RequestParam("erpCorporationCode") String erpCorporationCode);
}