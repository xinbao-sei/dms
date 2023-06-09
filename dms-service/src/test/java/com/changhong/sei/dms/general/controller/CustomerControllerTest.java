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
 * @author 王锦光 wangjg
 * @version 2021-06-09 15:07
 */
class CustomerControllerTest extends BaseUnit5Test {
    @Autowired
    private CustomerController controller;

    @Test
    void search() {
        ErpCodeQuickSearchParam searchParam = new ErpCodeQuickSearchParam();
        searchParam.setPageInfo(new PageInfo());
        searchParam.setErpCode("Q000");
        searchParam.setQuickSearchValue("平安");
        ResultData<?> resultData = controller.search(searchParam);
        System.out.println(JsonUtils.toJson(resultData));
        Assertions.assertTrue(resultData.successful());
    }

    @Test
    void findByName() {
        ResultData<?> resultData = controller.findByName("四川虹信软件股份有限公司");
        System.out.println(JsonUtils.toJson(resultData));
        Assertions.assertTrue(resultData.successful());
    }
}