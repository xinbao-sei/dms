package com.changhong.sei.mdms.dao;

import com.changhong.sei.core.dao.BaseTreeDao;
import com.changhong.sei.mdms.entity.MasterDataType;
import org.springframework.stereotype.Repository;

/**
 * 主数据分类(MasterDataType)数据库访问类
 *
 * @author sei
 * @since 2020-08-13 22:47:06
 */
@Repository
public interface MasterDataTypeDao extends BaseTreeDao<MasterDataType> {

}