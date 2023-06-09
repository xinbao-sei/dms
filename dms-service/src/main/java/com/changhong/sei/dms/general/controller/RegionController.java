package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.controller.BaseTreeController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseTreeService;
import com.changhong.sei.core.service.bo.ResponseData;
import com.changhong.sei.dms.general.api.RegionApi;
import com.changhong.sei.dms.general.dto.MobileRegionDto;
import com.changhong.sei.dms.general.dto.RegionDto;
import com.changhong.sei.dms.general.dto.search.MobileRegionParam;
import com.changhong.sei.dms.general.entity.Region;
import com.changhong.sei.dms.general.service.RegionService;
import io.swagger.annotations.Api;
import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 行政区域(Region)控制类
 *
 * @author sei
 * @since 2020-08-17 14:02:48
 */
@RestController
@Api(value = "RegionApi", tags = "行政区域服务")
@RequestMapping(path = "region", produces = MediaType.APPLICATION_JSON_VALUE)
public class RegionController extends BaseTreeController<Region, RegionDto> implements RegionApi {
    /**
     * 行政区域服务对象
     */
    @Autowired
    private RegionService service;
    @Autowired
    private ModelMapper mapper;

    @Override
    public BaseTreeService<Region> getService() {
        return service;
    }

    /**
     * 获取所有行政区域树
     *
     * @return 行政区域树形对象集合
     */
    @Override
    public ResultData<List<RegionDto>> getMultipleRoots() {
        return ResultData.success(convertToDtos(service.getRegionTree()));
    }

    /**
     * 通过国家id查询行政区域树
     *
     * @param countryId 国家id
     * @return 行政区域树清单
     */
    @Override
    public ResultData<List<RegionDto>> getRegionTreeByCountry(String countryId) {
        return ResultData.success(convertToDtos(service.getRegionTreeByCountry(countryId)));
    }

    /**
     * 通过国家id查询省
     *
     * @param countryId 国家Id
     */
    @Override
    public ResultData<List<RegionDto>> getProvinceByCountry(String countryId) {
        return ResultData.success(convertToDtos(service.getProvinceByCountry(countryId)));
    }

    /**
     * 通过省id查询市
     *
     * @param provinceId 省级行政区域Id
     */
    @Override
    public ResultData<List<RegionDto>> getCityByProvince(String provinceId) {
        return ResultData.success(convertToDtos(service.getCityByProvince(provinceId)));
    }


    /**
     * 查询行政区域
     *
     * @param param 查询参数
     * @return 行政区域清单
     */
    @Override
    public ResultData<Map<String, List<MobileRegionDto>>> getRegionByInitials(MobileRegionParam param) {
        ResponseData<List<Region>> resultData = service.getRegionByInitials(param);
        if (resultData.notSuccessful()) {
            return ResultData.fail(resultData.getMessage());
        }
        Map<String, List<MobileRegionDto>> result;
        if (Objects.isNull(resultData.getData()) || CollectionUtils.isEmpty(resultData.getData())) {
            result = new HashMap<>();
        } else {
            result = resultData.getData().parallelStream().map(i -> mapper.map(i, MobileRegionDto.class))
                    .sorted(Comparator.comparing(MobileRegionDto::getPinYin))
                    .collect(Collectors.groupingBy(MobileRegionDto::getInitials, HashMap::new, Collectors.toList()));
        }
        return ResultData.success(result);
    }

    /**
     * 分页查询业务实体
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @Override
    public ResultData<PageResult<RegionDto>> findByPage(Search search) {
        return convertToDtoPageResult(service.findByPage(search));
    }

    /**
     * 将数据实体转换成DTO
     *
     * @param entity 业务实体
     * @return DTO
     */
    @Override
    public RegionDto convertToDto(Region entity) {
        return RegionController.custConvertToDto(entity);
    }

    /**
     * 自定义将数据实体转换成DTO
     *
     * @param entity 业务实体
     * @return DTO
     */
    static RegionDto custConvertToDto(Region entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        ModelMapper custMapper = new ModelMapper();
        // 创建自定义映射规则
        PropertyMap<Region, RegionDto> propertyMap = new PropertyMap<Region, RegionDto>() {
            @Override
            protected void configure() {
                // 自定义转换规则
                map().setCountryId(source.getCountryId());
            }
        };
        // 添加映射器
        custMapper.addMappings(propertyMap);
        // 转换
        return custMapper.map(entity, RegionDto.class);
    }
}