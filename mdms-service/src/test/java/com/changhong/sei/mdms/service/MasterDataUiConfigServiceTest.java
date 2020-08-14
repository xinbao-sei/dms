package com.changhong.sei.mdms.service;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.test.BaseUnitTest;
import com.changhong.sei.mdms.dto.CodeNameDto;
import com.changhong.sei.mdms.dto.EntityDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-08-15 02:04
 */
public class MasterDataUiConfigServiceTest extends BaseUnitTest {

    @Autowired
    private MasterDataUiConfigService service;

    @Test
    public void getAllMasterDataEntities() {
        ResultData<List<EntityDto>> entityDtos = service.getAllMasterDataEntities();
        System.out.println(entityDtos);
    }

    @Test
    public void getPropertiesByCode() {
        ResultData<List<CodeNameDto>> entityDtos = service.getPropertiesByCode("dataModel");
        System.out.println(entityDtos);
    }
}