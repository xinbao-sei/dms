package com.changhong.sei.dms.general.controller;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageInfo;
import com.changhong.sei.core.test.BaseUnit5Test;
import com.changhong.sei.core.util.JsonUtils;
import com.changhong.sei.dms.general.dto.search.ErpCodeQuickSearchParam;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 实现功能:
 *
 * @author 杨沄炜
 * @version 2021/06/23 16:37
 */
class ServiceControllerTest extends BaseUnit5Test {
    @Autowired
    private SupplierController controller;

    @Test
    void search(){
        ErpCodeQuickSearchParam searchParam = new ErpCodeQuickSearchParam();
        searchParam.setPageInfo(new PageInfo());
        searchParam.setErpCode("Q000");
        searchParam.setQuickSearchValue("平安");
        ResultData<?> resultData = controller.search(searchParam);
        System.out.println(JsonUtils.toJson(resultData));
        Assertions.assertTrue(resultData.successful());
    }
}
