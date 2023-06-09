package com.changhong.sei.dms.general.service;

import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.general.dao.TaxTypeDao;
import com.changhong.sei.dms.general.dto.TaxCategory;
import com.changhong.sei.dms.general.entity.TaxType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 税类型(TaxType)业务逻辑实现类
 *
 * @author 杨沄炜
 * @since 2021/06/23 8:30
 */
@Service("taxTypeService")
public class TaxTypeService extends BaseEntityService<TaxType>{
    @Autowired
    private TaxTypeDao dao;

    @Override
    protected BaseEntityDao<TaxType> getDao() { return dao; }

    /**
     * 根据税分类获取税类型清单
     *
     * @param taxCategory 税分类
     * @return 税类型清单
     */
    public List<TaxType> findByTaxCategory(TaxCategory taxCategory) {
        String tenantCode = ContextUtil.getTenantCode();
        return dao.findByTaxCategory(taxCategory, tenantCode);
    }

    /**
     * 根据税码获取税类型
     *
     * @param code 税码
     * @return 税类型
     */
    public TaxType findByCode(String code) {
        String tenantCode = ContextUtil.getTenantCode();
        return dao.findByCodeAndTenantCode(code, tenantCode);
    }
}