package com.changhong.sei.mdms.service;

import com.changhong.sei.core.cache.CacheBuilder;
import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.mdms.common.Constants;
import com.changhong.sei.mdms.dao.MasterDataUiConfigDao;
import com.changhong.sei.mdms.dto.CodeNameDto;
import com.changhong.sei.mdms.dto.EntityDto;
import com.changhong.sei.mdms.entity.MasterDataUiConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


/**
 * 主数据UI配置(MasterDataUiConfig)业务逻辑实现类
 *
 * @author sei
 * @since 2020-08-13 22:47:16
 */
@Service("masterDataUiConfigService")
public class MasterDataUiConfigService extends BaseEntityService<MasterDataUiConfig> {
    @Autowired
    private CacheBuilder cacheBuilder;
    @Autowired
    private MasterDataUiConfigDao dao;


    @Override
    protected BaseEntityDao<MasterDataUiConfig> getDao() {
        return dao;
    }

    public ResultData<String> unregister(String id) {
        MasterDataUiConfig config = dao.findOne(id);
        if (Objects.isNull(config)) {
            return ResultData.fail("未找到对应的数据");
        }
        config.setFrozen(Boolean.TRUE);
        OperateResultWithData<MasterDataUiConfig> result = this.save(config);
        if (result.successful()) {
            return ResultData.success(result.getMessage());
        } else {
            return ResultData.fail(result.getMessage());
        }
    }

    public ResultData<List<EntityDto>> getAllMasterDataEntities() {
        List<EntityDto> entityDtos = cacheBuilder.get(Constants.ENTITY_CACHE_KEY);
        return ResultData.success(entityDtos);
    }

    /**
     * 获取指定表字段信息
     *
     * @param code 主数据代码
     * @return 返回指定表字段清单
     */
    public ResultData<List<CodeNameDto>> getPropertiesByCode(String code) {
        List<CodeNameDto> dtos = cacheBuilder.get(Constants.PROPERTY_CACHE_KEY + code);
        return ResultData.success(dtos);
    }
}