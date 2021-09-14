package com.changhong.sei.dms.general.dao;

import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.dms.general.dto.search.ErpCodeQuickSearchParam;
import com.changhong.sei.dms.general.entity.Customer;

/**
 * 实现功能: 客户数据访问扩展接口
 *
 * @author 王锦光 wangjg
 * @version 2021-06-09 14:53
 */
public interface CustomerExtDao {
    /**
     * 分页查询客户主数据
     *
     * @param searchParam 查询参数
     * @return 客户主数据
     */
    PageResult<Customer> search(ErpCodeQuickSearchParam searchParam);
}
