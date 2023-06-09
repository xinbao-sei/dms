package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.api.BankProvincesApi;
import com.changhong.sei.dms.general.dto.BankProvincesDto;
import com.changhong.sei.dms.general.dto.TaxRateDto;
import com.changhong.sei.dms.general.entity.BankProvinces;
import com.changhong.sei.dms.general.entity.TaxRate;
import com.changhong.sei.dms.general.service.BankProvincesService;
import com.changhong.sei.util.ArithUtils;
import io.swagger.annotations.Api;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * 银行省区(BankProvinces)控制类
 *
 * @author sei
 * @since 2021-05-07 14:34:40
 */
@RestController
@Api(value = "BankProvincesApi", tags = "银行省区服务")
@RequestMapping(path = BankProvincesApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class BankProvincesController extends BaseEntityController<BankProvinces, BankProvincesDto> implements BankProvincesApi {
    /**
     * 银行省区服务对象
     */
    @Autowired
    private BankProvincesService service;
    @Autowired
    private ModelMapper mapper;

    @Override
    public BaseEntityService<BankProvinces> getService() {
        return service;
    }

    /**
     * 分页查询业务实体
     *
     * @param search 查询参数
     * @return 分页查询结果
     */
    @Override
    public ResultData<PageResult<BankProvincesDto>> findByPage(Search search) {
        return convertToDtoPageResult(service.findByPage(search));
    }


    /**
     * 将实体转换成DTO
     *
     * @param entity 业务实体
     * @return DTO
     */
    @Override
    public BankProvincesDto convertToDto(BankProvinces entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        BankProvincesDto dto = mapper.map(entity, BankProvincesDto.class);
        if (Objects.nonNull(entity.getRegion())) {
            dto.setRegionCode(entity.getRegion().getCode());
            dto.setRegionName(entity.getRegion().getName());
            //国家映射
            if (Objects.nonNull(entity.getRegion().getCountry())) {
                dto.setCountryCode(entity.getRegion().getCountry().getCode());
                dto.setCountryName(entity.getRegion().getCountry().getName());
            }
        }
        return dto;
    }
}