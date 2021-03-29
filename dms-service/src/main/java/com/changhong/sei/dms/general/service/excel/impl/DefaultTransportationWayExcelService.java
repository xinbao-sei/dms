package com.changhong.sei.dms.general.service.excel.impl;

import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dms.common.excel.BaseExcelService;
import com.changhong.sei.dms.general.entity.TransportationWay;
import com.changhong.sei.dms.general.entity.Unit;
import com.changhong.sei.dms.general.service.excel.TransportationWayExcelService;
import com.changhong.sei.dms.general.service.excel.UnitExcelService;
import com.changhong.sei.dms.general.service.excel.vo.TransportationWayVo;
import com.changhong.sei.dms.general.service.excel.vo.UnitVo;

/**
 * 实现功能：导入导出服务
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-10-12 00:35
 */
public class DefaultTransportationWayExcelService extends BaseExcelService<TransportationWay, TransportationWayVo> implements TransportationWayExcelService {

    public DefaultTransportationWayExcelService(BaseEntityService<TransportationWay> service) {
        super(service);
    }

}
