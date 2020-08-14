package com.changhong.sei.mdms.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.mdms.api.MasterDataUiConfigApi;
import com.changhong.sei.mdms.dto.MasterDataRegisterRequest;
import com.changhong.sei.mdms.dto.MasterDataUiConfigDto;
import com.changhong.sei.mdms.entity.MasterDataUiConfig;
import com.changhong.sei.mdms.service.MasterDataUiConfigService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 主数据UI配置(MasterDataUiConfig)控制类
 *
 * @author sei
 * @since 2020-08-13 22:47:17
 */
@RestController
@Api(value = "MasterDataUiConfigApi", tags = "主数据UI配置服务")
@RequestMapping(path = "masterDataUiConfig", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MasterDataUiConfigController extends BaseEntityController<MasterDataUiConfig, MasterDataUiConfigDto> implements MasterDataUiConfigApi {
    /**
     * 主数据UI配置服务对象
     */
    @Autowired
    private MasterDataUiConfigService service;

    @Override
    public BaseEntityService<MasterDataUiConfig> getService() {
        return service;
    }

    /**
     * 主数据注册
     *
     * @param request 主数据注册请求
     * @return 操作结果
     */
    @Override
    public ResultData<String> register(MasterDataRegisterRequest request) {
        MasterDataUiConfig config = getModelMapper().map(request, MasterDataUiConfig.class);
        OperateResultWithData<MasterDataUiConfig> result = service.save(config);
        if (result.successful()) {
            return ResultData.success(result.getMessage());
        } else {
            return ResultData.fail(result.getMessage());
        }
    }
}