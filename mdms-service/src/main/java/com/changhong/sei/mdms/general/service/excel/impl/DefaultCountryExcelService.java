package com.changhong.sei.mdms.general.service.excel.impl;

import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.mdms.common.excel.BaseExcelService;
import com.changhong.sei.mdms.general.entity.Country;
import com.changhong.sei.mdms.general.service.CountryService;
import com.changhong.sei.mdms.general.service.excel.CountryExcelService;
import com.changhong.sei.mdms.general.service.excel.vo.CountryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 实现功能：国家导入导出服务
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-10-12 00:35
 */
public class DefaultCountryExcelService extends BaseExcelService<Country, CountryVo> implements CountryExcelService {
    /**
     * 国家服务对象
     */
    @Autowired
    private CountryService service;

    /**
     * 处理数据方法
     *
     * @param dataList 校验通过的解析数据
     */
    @Override
    @Transactional
    public void doImportHandle(final String batchId, List<CountryVo> dataList) {
        List<Country> countries = dataList.stream()
                .map(o -> MODEL_MAPPER.map(o, Country.class)).collect(Collectors.toList());
        service.save(countries);
    }

    /**
     * 分页导出数据
     *
     * @param search 分页查询对象
     * @return 返回分页查询结果
     */
    @Override
    public PageResult<Country> findByPage(Search search) {
        return service.findByPage(search);
    }
}
